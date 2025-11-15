/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ilope
 */
public class VerificadorGanador {
     private StrategyGanador estrategia;

    public VerificadorGanador(StrategyGanador estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(StrategyGanador e) { this.estrategia = e; }

    public List<Carton> verificar(List<Carton> cartones) {
        List<Carton> ganadores = new ArrayList<>();
        for (Carton c : cartones) if (estrategia.esGanador(c)) ganadores.add(c);
        return ganadores;
    }
}
