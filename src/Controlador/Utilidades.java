/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Carton;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author ilope
 */
public class Utilidades {
    public static Carton generarCartonAleatorio(String id) {
        Carton c = new Carton(id);
        Random rnd = new Random();
        for (int col=0; col<5; col++) {
            Set<Integer> set = new HashSet<>();
            int min = col*15 + 1;
            int max = col*15 + 15;
            while (set.size() < 5) {
                int n = rnd.nextInt(max - min + 1) + min;
                set.add(n);
            }
            Integer[] arr = set.toArray(new Integer[0]);
            for (int row=0; row<5; row++) c.setNumero(row, col, arr[row]);
        }
        c.setNumero(2,2,0);
        return c;
    }
}
