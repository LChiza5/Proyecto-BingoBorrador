/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ilope
 */
public class Carton {
    private String id;
    private int[][] numeros;      // 5x5
    private boolean[][] marcados; // 5x5

    public Carton(String id) {
        this.id = id;
        this.numeros = new int[5][5];
        this.marcados = new boolean[5][5];
        // centro libre
        this.numeros[2][2] = 0;
        this.marcados[2][2] = true;
    }

    public String getId() { return id; }

    public int getNumero(int fila, int col) { return numeros[fila][col]; }
    public void setNumero(int fila, int col, int valor) { numeros[fila][col] = valor; }

    public boolean isMarcado(int fila, int col) { return marcados[fila][col]; }

    public boolean marcar(int numero) {
        boolean marcado = false;
        for (int r=0;r<5;r++) for (int c=0;c<5;c++) {
            if (numeros[r][c] == numero) { marcados[r][c] = true; marcado = true; }
        }
        // asegurar centro marcado
        marcados[2][2] = true;
        return marcado;
    }

    public boolean desmarcar(int numero) {
        boolean desmarcado = false;
        for (int r=0;r<5;r++) for (int c=0;c<5;c++) {
            if (numeros[r][c] == numero) { marcados[r][c] = false; desmarcado = true; }
        }
        marcados[2][2] = true;
        return desmarcado;
    }

    public void limpiarMarcados() {
        for (int r=0;r<5;r++) for (int c=0;c<5;c++) marcados[r][c] = false;
        marcados[2][2] = true;
    }

    public boolean contieneNumero(int numero) {
        for (int r=0;r<5;r++) for (int c=0;c<5;c++) if (numeros[r][c] == numero) return true;
        return false;
    }

    /**
     * Validaciones:
     * - 24 numeros entre 1..75 (centro libre)
     * - rango por columna
     * - no repetidos
     */
    public boolean validar() {
        Set<Integer> seen = new HashSet<>();
        int count = 0;
        for (int r=0;r<5;r++) {
            for (int c=0;c<5;c++) {
                if (r==2 && c==2) continue;
                int n = numeros[r][c];
                if (n < 1 || n > 75) return false;
                int min = c*15 + 1;
                int max = c*15 + 15;
                if (n < min || n > max) return false;
                if (seen.contains(n)) return false;
                seen.add(n);
                count++;
            }
        }
        return count == 24;
    }

    public boolean[][] getMarcados() { return marcados; }
    public int[][] getNumeros() { return numeros; }
}
