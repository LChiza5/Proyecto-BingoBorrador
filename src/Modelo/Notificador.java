/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ilope
 */
public abstract class Notificador {
    private final ArrayList<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    protected void notificar(int numero) {
        for (Observer o : observers) o.onNumeroCantado(numero);
    }

    protected List<Observer> getObservers() {
        return observers;
    }
}
