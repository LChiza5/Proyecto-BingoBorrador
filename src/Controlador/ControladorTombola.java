/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Tombola;
import java.util.List;

/**
 *
 * @author ilope
 */
public class ControladorTombola {
    private final Tombola tombola;

    public ControladorTombola() { tombola = new Tombola(); }

    public int sacarAleatorio() { return tombola.sacarAleatorio(); }
    public boolean ingresarManual(int n) { return tombola.ingresarManual(n); }
    public void reiniciar() { tombola.reiniciar(); }
    public List<Integer> getSalidos() { return tombola.getSalidos(); }
}
