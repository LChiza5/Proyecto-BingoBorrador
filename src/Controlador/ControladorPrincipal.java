/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Carton;
import Modelo.Juego;
import Modelo.ModoJuego;
import Modelo.Strategy;
import Modelo.StrategyCartonLleno;
import Modelo.StrategyCuatroEsquinas;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author ilope
 */
public class ControladorPrincipal {
   
    
    private final Juego juego;

    public ControladorPrincipal() {
        this.juego = Juego.getInstancia();
    }

    // ================== MODO DE JUEGO ==================

    public void setModoJuego(ModoJuego modo) {
        switch (modo) {
            case NORMAL -> juego.setEstrategia(new Strategy());
            case CUATRO_ESQUINAS -> juego.setEstrategia(new StrategyCuatroEsquinas());
            case CARTON_LLENO -> juego.setEstrategia(new StrategyCartonLleno());
        }
    }

    // ================== CARTONES ==================

//    public String agregarCartonManual() {
//        int num = 0;
//        String[] mensajes = new String[5];
//        mensajes[0]= "columna 1 del 1 al 15";
//        mensajes[1]= "columna 2 del 16 al 30";
//        mensajes[2]= "columna 3 del 31 al 45";
//        mensajes[3]= "columna 4 del 46 al 60";
//        mensajes[4]= "columna 5 del 61 al 75";
//        String id = JOptionPane.showInputDialog("Escriba el ID");
//        Carton c = new Carton(id);
//        for (int r = 0; r < 5; r++){
//            for (int col = 0; col < 5; col++){
//                    if (r == 2 && col == 2) {
//                        c.setNumero(r, col, 0);
//                    continue;
//                    }
//                num = Integer.valueOf(JOptionPane.showInputDialog(mensajes[col]));
//                c.setNumero(r, col, num);
//                
//                try {
//                num = Integer.parseInt(JOptionPane.showInputDialog(mensajes[col]));
//                c.setNumero(r, col, num);
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
//                return null;
//            }
//            }
//        }
//            
//        if (!c.validar()){
//            JOptionPane.showMessageDialog(null, "Cartón inválido");
//        return null;
//        }
//
//        JOptionPane.showMessageDialog(null, "Cartón agregado");
//        juego.agregarCarton(c);
//        return id;
//    }
    
    public String agregarCartonManual() {

    String[] mensajes = {
        "Columna 1: números del 1 al 15",
        "Columna 2: números del 16 al 30",
        "Columna 3: números del 31 al 45",
        "Columna 4: números del 46 al 60",
        "Columna 5: números del 61 al 75"
    };

    String id = JOptionPane.showInputDialog("Escriba el ID del cartón:");
    if (id == null || id.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "ID inválido.");
        return null;
    }

    Carton c = new Carton(id);

    Set<Integer> usados = new HashSet<>();

    for (int r = 0; r < 5; r++) {
        for (int col = 0; col < 5; col++) {

            // Espacio libre
            if (r == 2 && col == 2) {
                c.setNumero(r, col, 0);
                continue;
            }

            int min = col * 15 + 1;
            int max = col * 15 + 15;

            boolean valido = false;
            int num = 0;

            // Repetir hasta que el usuario ingrese un número correcto
            while (!valido) {
                String entrada = JOptionPane.showInputDialog(
                        "Fila " + (r+1) + ", Columna " + (col+1) + "\n" + mensajes[col]);

                if (entrada == null) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un número.");
                    continue;
                }

                try {
                    num = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida. Ingrese solo números.");
                    continue;
                }

                if (num < min || num > max) {
                    JOptionPane.showMessageDialog(null,
                        "Número fuera del rango permitido (" + min + " - " + max + ").");
                    continue;
                }

                if (usados.contains(num)) {
                    JOptionPane.showMessageDialog(null,
                        "Este número ya fue ingresado en el cartón. No se permiten duplicados.");
                    continue;
                }

                valido = true;
                usados.add(num);
                c.setNumero(r, col, num);
            }
        }
    }

    if (!c.validar()) {
        JOptionPane.showMessageDialog(null,
            "❌ Error inesperado: el cartón no pasó la validación interna.\n" +
            "Esto no debería ocurrir. Revise la lógica.");
        return null;
    }

    juego.agregarCarton(c);
    JOptionPane.showMessageDialog(null, "✔ Cartón agregado correctamente.");
    return id;
}
    
    

    public String agregarCartonAutomatico() {
        String id = JOptionPane.showInputDialog("Escriba el ID");
        Carton c = Utilidades.generarCartonAleatorio(id);
        juego.agregarCarton(c);
        return c.getId();
    }

    public void eliminarCarton(String id) {
        juego.eliminarCarton(id);
    }

    public List<Carton> listarCartones() {
        return juego.getCartones();
    }

    public Carton buscarCarton(String id) {
        return juego.getCartones()
               .stream()
               .filter(c -> c.getId().equals(id))
               .findFirst()
               .orElse(null);
    }
    
    // ================== TÓMBOLA ==================

    public int sacarNumeroAuto() {
        return juego.sacarAutomatico(); // YA MARCA AUTOMÁTICAMENTE
    }

    public boolean ingresarNumeroManual(int numero) {
        return juego.ingresarManual(numero); // idem
    }

    public List<Integer> getNumerosSalidos() { return juego.getNumerosSalidos(); }
    public int getUltimoNumero() { return juego.getUltimoNumero(); }
   public List<Integer> getNumerosRestantes() {
    return juego.getNumerosRestantes();
}

    // ================== Verificación ==================

    public boolean esGanador(Carton c) {
        return c != null && juego.getEstrategia().esGanador(c);
    }

    // ================== RESET ==================

    public void reiniciarJuego() {
        juego.iniciarRonda();
    }
}
