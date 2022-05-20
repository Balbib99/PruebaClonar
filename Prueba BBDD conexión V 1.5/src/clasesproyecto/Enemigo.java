/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesproyecto;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Enemigo {

    String nombre;
    ArrayList<Movimientos> ataques = new ArrayList<>();
    public int vida;

    public Enemigo(String nombre) {
        this.nombre = nombre;
        ataques.add(Movimientos.obtenerMovimientoDebil());
        ataques.add(Movimientos.obtenerMovimientoFuerte());
        ataques.add(Movimientos.obtenerMovimientoProtec());
        ataques.add(Movimientos.obtenerMovimientoUlti());
        this.vida=200;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public ArrayList<Movimientos> getAtaques() {
        return ataques;
    }

    public void setAtaques(ArrayList<Movimientos> ataques) {
        this.ataques = ataques;
    }


}
