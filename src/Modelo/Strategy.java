/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ilope
 */
public class Strategy implements StrategyGanador{
    
    @Override
    public boolean esGanador(Carton c) {
        // filas
        for (int r=0;r<5;r++) {
            boolean ok = true;
            for (int co=0; co<5; co++) if (!c.isMarcado(r,co)) { ok=false; break; }
            if (ok) return true;
        }
        // columnas
        for (int co=0; co<5; co++) {
            boolean ok = true;
            for (int r=0;r<5;r++) if (!c.isMarcado(r,co)) { ok=false; break; }
            if (ok) return true;
        }
        // diagonales
        boolean d1=true, d2=true;
        for (int i=0;i<5;i++) { if (!c.isMarcado(i,i)) d1=false; if (!c.isMarcado(i,4-i)) d2=false; }
        if (d1 || d2) return true;
        // cuatro esquinas
        return c.isMarcado(0,0) && c.isMarcado(0,4) && c.isMarcado(4,0) && c.isMarcado(4,4);
    }
}
