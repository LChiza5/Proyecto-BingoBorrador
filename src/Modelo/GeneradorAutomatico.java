/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author ilope
 */
public class GeneradorAutomatico {
    private static final Random rnd = new Random();

    public static int[][] generar() {

        int[][] nums = new int[5][5];
        Set<Integer> usados = new HashSet<>();

        for (int col = 0; col < 5; col++) {

            int min = col * 15 + 1;
            int max = col * 15 + 15;

            for (int fila = 0; fila < 5; fila++) {

                if (fila == 2 && col == 2) {
                    nums[fila][col] = 0;
                    continue;
                }

                int n;
                do {
                    n = rnd.nextInt(max - min + 1) + min;
                } while (usados.contains(n));

                usados.add(n);
                nums[fila][col] = n;
            }
        }

        return nums;
    }
}