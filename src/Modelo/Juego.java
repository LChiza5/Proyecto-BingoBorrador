/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ilope
 */
public class Juego implements Observer {

    private static Juego instancia;

    public static Juego getInstancia() {
        if (instancia == null) instancia = new Juego();
        return instancia;
    }

    private final List<Carton> cartones = new ArrayList<>();
    private final Tombola tombola = Tombola.getInstance();
    private StrategyGanador estrategia = new ModoNormal();
private final VerificadorGanador verificador = new VerificadorGanador(estrategia);

    private int ultimoNumero = -1;
    private boolean enRonda = false;

    private Juego() {
        tombola.addObserver(this);
    }

    public void agregarCarton(Carton c) { cartones.add(c); }

    public void eliminarCarton(String id) {
        cartones.removeIf(x -> x.getId().equals(id));
    }

    public List<Carton> getCartones() {
        return Collections.unmodifiableList(cartones);
    }

    public void setEstrategia(StrategyGanador e) {
        this.estrategia = e;
        verificador.setEstrategia(e);
    }

    public StrategyGanador getEstrategia() {
        return estrategia;
    }

    public void iniciarRonda() {
        enRonda = true;
        tombola.reiniciar();
        for (Carton c : cartones) c.limpiarMarcados();
    }

    public void finalizarRonda() { enRonda = false; }

    public int sacarAutomatico() {
        if (!enRonda) iniciarRonda();
        return tombola.sacarAleatorio();
    }

    public boolean ingresarManual(int n) {
        if (!enRonda) iniciarRonda();
        return tombola.ingresarManual(n);
    }

    public List<Integer> getNumerosSalidos() {
        return tombola.getSalidos();
    }

    @Override
    public void onNumeroCantado(int numero) {
        this.ultimoNumero = numero;
        if (numero == -1) return;

        for (Carton c : cartones) c.marcar(numero);

        List<Carton> ganadores = verificador.verificar(cartones);

        if (!ganadores.isEmpty()) {
            tombola.notifyGanadores(ganadores);
            enRonda = false;
        }
    }

    
    public void onGanadores(List<Carton> ganadores) {
        // para expansión futura
    }

    public List<Integer> getNumerosRestantes() {
    List<Integer> restantes = new ArrayList<>();
    for (int i = 1; i <= 75; i++) {
        if (!getNumerosSalidos().contains(i)) {
            restantes.add(i);
        }
    }
    return restantes;
}
public int getUltimoNumero() {
    return ultimoNumero;
}
public void modoNormal() {
    setEstrategia(new ModoNormal());
}

// Cambiar a CUATRO ESQUINAS
public void modoCuatroEsquinas() {
    setEstrategia(new StrategyCuatroEsquinas());
}

// Cambiar a CARTÓN LLENO
public void modoCartonLleno() {
    setEstrategia(new StrategyCartonLleno());
}
public Tombola getTombola() {
    return tombola;
}
}
