/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ilope
 */
public class ModoNormal implements StrategyGanador {

    @Override
    public boolean esGanador(Carton c) {

        boolean[][] marcados = c.getMarcados();

        // Filas
        for (int i = 0; i < 5; i++) {
            boolean fila = true;
            for (int j = 0; j < 5; j++) {
                if (!marcados[i][j]) fila = false;
            }
            if (fila) return true;
        }

        // Columnas
        for (int j = 0; j < 5; j++) {
            boolean col = true;
            for (int i = 0; i < 5; i++) {
                if (!marcados[i][j]) col = false;
            }
            if (col) return true;
        }

        // Diagonal principal
        boolean diag1 = true;
        for (int i = 0; i < 5; i++) {
            if (!marcados[i][i]) diag1 = false;
        }

        if (diag1) return true;

        // Diagonal secundaria
        boolean diag2 = true;
        for (int i = 0; i < 5; i++) {
            if (!marcados[i][4 - i]) diag2 = false;
        }

        if (diag2) return true;

        // Cuatro esquinas
        if (marcados[0][0] && marcados[0][4] &&
            marcados[4][0] && marcados[4][4]) {
            return true;
        }

        return false;
    }
}