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
public class Tombola extends Notificador {

    private static Tombola instancia;

    private ArrayList<Integer> disponibles;
    private ArrayList<Integer> salidos;

    private Tombola() {
        reiniciar();
    }

    public static Tombola getInstance() {
        if (instancia == null) instancia = new Tombola();
        return instancia;
    }

    public void reiniciar() {
        disponibles = new ArrayList<>();
        salidos = new ArrayList<>();

        for (int i = 1; i <= 75; i++) disponibles.add(i);
        Collections.shuffle(disponibles);
    }

    public int sacarAleatorio() {
        if (disponibles.isEmpty()) {
            notificar(-1); 
            return -1;
        }

        int numero = disponibles.remove(0);
        salidos.add(numero);

        notificar(numero); // 🔥 DELEGADO AL NOTIFICADOR

        return numero;
    }

    public boolean ingresarManual(int numero) {
        if (numero < 1 || numero > 75) return false;
        if (!disponibles.contains(numero)) return false;

        disponibles.remove((Integer) numero);
        salidos.add(numero);

        notificar(numero);

        return true;
    }

    public List<Integer> getSalidos() {
        return Collections.unmodifiableList(salidos);
    }

    public List<Integer> getDisponibles() {
        return Collections.unmodifiableList(disponibles);
    }

    public boolean contiene(int numero) {
        return disponibles.contains(numero);
    }

    // MANDA LISTA DE GANADORES A TODOS LOS OBSERVERS
    public void notifyGanadores(List<Carton> ganadores) {
        for (Observer o : getObservers()) {
            o.onGanadores(ganadores);
        }
    }
    public void desmarcarNumero(int n) {

    // Si el número estaba en salidos → lo sacamos
    if (salidos.contains(n)) {
        salidos.remove((Integer)n);
    }

    // Si no está en disponibles → volver a ponerlo
    if (!disponibles.contains(n)) {
        disponibles.add(n);
        Collections.shuffle(disponibles); // para mantener aleatoriedad
    }
}

}

