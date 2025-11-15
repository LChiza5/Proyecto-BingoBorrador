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
    public enum Tipo { MANUAL, AUTOMATICO }

    public static Carton crear(String id, Tipo tipo, int[][] manual) {
        if (tipo == Tipo.MANUAL) {
            Carton c = new Carton(id);
            for (int r=0;r<5;r++) for (int co=0;co<5;co++) c.setNumero(r,co,manual[r][co]);
            return c;
        } else {
            return Utilidades.generarCartonAleatorio(id);
        }
    }
}
