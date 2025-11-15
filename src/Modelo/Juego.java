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
    private final Tombola tombola = new Tombola();
    private StrategyGanador estrategia = new Strategy();
    private final VerificadorGanador verificador = new VerificadorGanador(estrategia);
    private int ultimoNumero = -1;
    private boolean enRonda = false;

    private Juego() {
        tombola.addObserver(this);
    }

    public void agregarCarton(Carton c) { cartones.add(c); }
    public void eliminarCarton(String id) { cartones.removeIf(x -> x.getId().equals(id)); }
    public List<Carton> getCartones() { return Collections.unmodifiableList(cartones); }

    public void setEstrategia(StrategyGanador e) {
        this.estrategia = e;
        verificador.setEstrategia(e);
    }

    public void iniciarRonda() {
        enRonda = true;
        tombola.reiniciar();
        for (Carton c : cartones) c.limpiarMarcados();
    }

    public void finalizarRonda() { enRonda = false; }

    public int sacarAutomatico() { if (!enRonda) iniciarRonda(); return tombola.sacarAleatorio(); }
    public boolean ingresarManual(int n) { if (!enRonda) iniciarRonda(); return tombola.ingresarManual(n); }

    public List<Integer> getNumerosSalidos() { return tombola.getSalidos(); }

    @Override
    public void onNumeroCantado(int numero) {
        this.ultimoNumero = numero;
        if (numero == -1) return;
        // marcar en todos los cartones
        for (Carton c : cartones) c.marcar(numero);
        // verificar ganadores con la estrategia actual
        List<Carton> ganadores = verificador.verificar(cartones);
        if (!ganadores.isEmpty()) {
            // notificar a la tómbola/vistas mediante tombola.notifyGanadores
            tombola.notifyGanadores(ganadores);
            enRonda = false;
        }
    }

    @Override
    public void onGanadores(List<Carton> ganadores) {
        // no usado aquí; tombola notifica a observers directamente
    }

    public int getUltimoNumero() { return ultimoNumero; }
}
