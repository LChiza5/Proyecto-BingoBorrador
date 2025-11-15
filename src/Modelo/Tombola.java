/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ilope
 */
public class Tombola {

    private final List<Integer> disponibles = new ArrayList<>();
    private final List<Integer> salidos = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    public Tombola() { reiniciar(); }

    public void reiniciar() {
        disponibles.clear();
        salidos.clear();
        for (int i=1;i<=75;i++) disponibles.add(i);
        Collections.shuffle(disponibles);
        notifyNumero(-1);
    }

    public int sacarAleatorio() {
        if (disponibles.isEmpty()) return -1;
        int n = disponibles.remove(0);
        salidos.add(n);
        notifyNumero(n);
        return n;
    }

    public boolean ingresarManual(int numero) {
        if (numero < 1 || numero > 75) return false;
        if (salidos.contains(numero)) return false;
        boolean removed = disponibles.remove((Integer) numero);
        if (removed) {
            salidos.add(numero);
            notifyNumero(numero);
        }
        return removed;
    }

    public List<Integer> getSalidos() { return new ArrayList<>(salidos); }

    // Observer management
    public void addObserver(Observer o) { if (!observers.contains(o)) observers.add(o); }
    public void removeObserver(Observer o) { observers.remove(o); }

    private void notifyNumero(int numero) {
        for (Observer o : observers) o.onNumeroCantado(numero);
    }

    public void notifyGanadores(List<Carton> ganadores) {
        for (Observer o : observers) o.onGanadores(ganadores);
    }
}
