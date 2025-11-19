/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ilope
 */
public class StrategyCuatroEsquinas implements StrategyGanador {
   @Override
    public boolean esGanador(Carton c) {
        boolean[][] m = c.getMarcados();

        return m[0][0] && m[0][4] && m[4][0] && m[4][4];
    }
}
