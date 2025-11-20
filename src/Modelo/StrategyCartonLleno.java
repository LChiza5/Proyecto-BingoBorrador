/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ilope
 */
public class StrategyCartonLleno implements StrategyGanador {
    @Override
    public boolean esGanador(Carton c) {
        boolean[][] m = c.getMarcados();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

           
                if (i == 2 && j == 2) continue;

                if (!m[i][j]) return false;
            }
        }

        return true;
    }
}
