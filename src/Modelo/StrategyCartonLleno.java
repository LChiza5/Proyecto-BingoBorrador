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
        for (int r=0;r<5;r++) for (int co=0;co<5;co++) if (!c.isMarcado(r,co)) return false;
        return true;
    }
}
