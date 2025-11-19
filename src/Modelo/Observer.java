/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import java.util.List;



/**
 *
 * @author ilope
 */
public interface Observer {
      void onNumeroCantado(int numero);
      void onGanadores(List<Carton> ganadores);
}
