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
public class FabricaCarton {

    private static final Set<String> idsGenerados = new HashSet<>();

    private static String generarID() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random r = new Random();
        String id;

        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                sb.append(chars.charAt(r.nextInt(chars.length())));
            }
            id = sb.toString();
        } while (idsGenerados.contains(id));

        idsGenerados.add(id);
        return id;
    }

    public static Carton crear(String tipo) {

        // 👇 AQUI CAMBIAMOS LA GENERACIÓN DEL ID
        String id = generarID();

        switch (tipo.toUpperCase()) {

            case "MANUAL" -> {
                return new Carton(id);
            }

            case "AUTO" -> {
                Carton c = new Carton(id);

                int[][] nums = GeneradorAutomatico.generar();

                for (int r = 0; r < 5; r++) {
                    for (int col = 0; col < 5; col++) {
                        if (r == 2 && col == 2) continue;
                        c.setNumero(r, col, nums[r][col]);
                    }
                }

                return c;
            }

            default -> {
                return null;
            }
        }
    }
}