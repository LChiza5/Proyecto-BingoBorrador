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
import java.util.List;

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

    public boolean agregarCartonManual(String id, int[][] numeros) {
        Carton c = new Carton(id);
        for (int r = 0; r < 5; r++)
            for (int col = 0; col < 5; col++)
                c.setNumero(r, col, numeros[r][col]);

        if (!c.validar()) return false;

        juego.agregarCarton(c);
        return true;
    }

    public String agregarCartonAutomatico(String id) {
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
