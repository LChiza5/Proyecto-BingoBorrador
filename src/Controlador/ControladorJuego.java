/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Carton;
import Modelo.FabricaCarton;
import Modelo.Juego;
import Modelo.ModoJuego;
import Modelo.ModoNormal;
import Modelo.Observer;
import Modelo.StrategyCartonLleno;
import Modelo.StrategyCuatroEsquinas;
import Modelo.StrategyGanador;
import Modelo.Tombola;
import java.util.List;

/**
 *
 * @author ilope
 */
public class ControladorJuego {
     private final Juego juego = Juego.getInstancia();
    private final Tombola tombola = Tombola.getInstance();

    // =============================
    //        CARTONES
    // =============================

    public String agregarCartonAutomatico() {
        Carton c = FabricaCarton.crear("AUTO");
        juego.agregarCarton(c);
        return c.getId();
    }

    public String agregarCartonManual() {
        Carton c = FabricaCarton.crear("MANUAL");
        juego.agregarCarton(c);
        return c.getId();
    }

    public Carton buscarCarton(String id) {
        for (Carton c : juego.getCartones()) {
            if (c.getId().equals(id)) return c;
        }
        return null;
    }

    public List<Carton> listarCartones() {
        return juego.getCartones();
    }

    public void eliminarCarton(String id) {
        juego.eliminarCarton(id);
    }

    // =============================
    //     MODO DE JUEGO (STRATEGY)
    // =============================

    public void setModo(StrategyGanador modo) {
        juego.setEstrategia(modo);
    }
    public void setModo(ModoJuego modo) {
    switch (modo) {
        case NORMAL ->
            setModo(new ModoNormal());
        case CUATRO_ESQUINAS ->
            setModo(new StrategyCuatroEsquinas());
        case CARTON_LLENO ->
            setModo(new StrategyCartonLleno());
    }
}
    // =============================
    //        NÚMEROS Y TÓMBOLA
    // =============================

    public int sacarNumeroAuto() {
        return juego.sacarAutomatico();
    }

    public boolean ingresarManual(int n) {
        return juego.ingresarManual(n);
    }

    public int getUltimoNumero() {
        return juego.getUltimoNumero();
    }

    public List<Integer> getNumerosSalidos() {
        return juego.getNumerosSalidos();
    }

    public List<Integer> getNumerosRestantes() {
        return juego.getNumerosRestantes();
    }

    public void reiniciarJuego() {
        juego.iniciarRonda();
    }

    // =============================
    //      GANADORES
    // =============================

    public boolean esGanador(Carton c) {
        return juego.getEstrategia().esGanador(c);
    }
public void registrarObserver(Observer o) {
    juego.getTombola().addObserver(o);
}

public void eliminarObserver(Observer o) {
    juego.getTombola().removeObserver(o);
}
public void desmarcarNumero(int n) {
 
    for (Carton c : juego.getCartones()) {
        c.desmarcar(n);
    }
    juego.getTombola().desmarcarNumero(n);
}

public void reiniciarJuegoCompleto() {
    juego.iniciarRonda(); // Reinicia tómbola

    // Limpiar marcados del modelo
    for (Carton c : juego.getCartones()) {
        c.limpiarMarcados();
    }
}
}
