/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesproyecto;

/**
 *
 * @author admin
 */
public class Puntuacion {
    int ID,victorias;
    String nombreJugador,nombrePersonaje;
    
    public Puntuacion (int ID, String nombreJugador, String nombrePersonaje){
        this.ID=ID;
        this.victorias = 0;
        this.nombreJugador=nombreJugador;
        this.nombrePersonaje=nombrePersonaje;
    }
}
