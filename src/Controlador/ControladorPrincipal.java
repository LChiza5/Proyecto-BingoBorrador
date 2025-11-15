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

    public void setModoJuego(ModoJuego modo) {
        switch (modo) {
            case NORMAL -> juego.setEstrategia(new Strategy());
            case CUATRO_ESQUINAS -> juego.setEstrategia(new StrategyCuatroEsquinas());
            case CARTON_LLENO -> juego.setEstrategia(new StrategyCartonLleno());
        }
    }

    // Cartones
    public boolean agregarCartonManual(String id, int[][] numeros) {
        Carton c = new Carton(id);
        for (int r=0;r<5;r++) for (int co=0;co<5;co++) c.setNumero(r,co,numeros[r][co]);
        if (!c.validar()) return false;
        juego.agregarCarton(c);
        return true;
    }

    public String agregarCartonAutomatico(String id) {
        Carton c = Utilidades.generarCartonAleatorio(id);
        juego.agregarCarton(c);
        return c.getId();
    }

    public void eliminarCarton(String id) { juego.eliminarCarton(id); }
    public List<Carton> listarCartones() { return juego.getCartones(); }

    // Tómbola
    public int sacarNumeroAuto() { return juego.sacarAutomatico(); }
    public boolean ingresarNumeroManual(int numero) { return juego.ingresarManual(numero); }
    public List<Integer> getNumerosSalidos() { return juego.getNumerosSalidos(); }
    public int getUltimoNumero() { return juego.getUltimoNumero(); }

    // Reinicio
    public void reiniciarJuego() { juego.iniciarRonda(); }

    // Desmarcar (por error)
    public void desmarcarNumero(int numero) {
        for (Carton c : juego.getCartones()) c.desmarcar(numero);
    }
}
