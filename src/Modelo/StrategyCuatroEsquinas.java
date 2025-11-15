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
        return c.isMarcado(0,0) && c.isMarcado(0,4) && c.isMarcado(4,0) && c.isMarcado(4,4);
    }
}
