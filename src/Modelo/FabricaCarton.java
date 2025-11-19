/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.Utilidades;

/**
 *
 * @author ilope
 */
public class FabricaCarton {

    public static Carton crear(String tipo) {

        switch (tipo.toUpperCase()) {

            case "MANUAL" -> {
                // El formulario lo va a llenar luego
                String id = "C" + System.currentTimeMillis();
                return new Carton(id);
            }

            case "AUTO" -> {
                String id = "C" + System.currentTimeMillis();
                Carton c = new Carton(id);

                int[][] nums = GeneradorAutomatico.generar();

                // Insertar uno por uno porque tu Carton NO tiene setNumeros()
                for (int r = 0; r < 5; r++) {
                    for (int col = 0; col < 5; col++) {

                        if (r == 2 && col == 2) continue; // centro libre

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

