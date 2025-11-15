/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

/**
 *
 * @author ilope
 */
public interface Notificador {
    void agregarObservador(Observer o);
    void eliminarObservador(Observer o);
    void notificar(int numero);
}
