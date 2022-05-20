/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesproyecto;

/**
 *
 * @author admin
 */
public class Personaje {

    public String nombre;
    public Movimientos debil, fuerte, ulti, protec;
    public int vida;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.debil=Movimientos.obtenerMovimientoDebil();
        this.fuerte=Movimientos.obtenerMovimientoFuerte();
        this.protec=Movimientos.obtenerMovimientoProtec();
        this.ulti=Movimientos.obtenerMovimientoUlti();
        this.vida=200;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setDebil(Movimientos debil) {
        this.debil = debil;
    }

    public void setFuerte(Movimientos fuerte) {
        this.fuerte = fuerte;
    }

    public void setUlti(Movimientos ulti) {
        this.ulti = ulti;
    }

    public void setProtec(Movimientos protec) {
        this.protec = protec;
    }

    public Movimientos getDebil() {
        return debil;
    }

    public Movimientos getFuerte() {
        return fuerte;
    }

    public Movimientos getUlti() {
        return ulti;
    }

    public Movimientos getProtec() {
        return protec;
    }
    
     public static void main(String[] args){
         
         Movimientos a = new Movimientos();
         
         Personaje balbi = new Personaje("balbi");
         
         System.out.println(balbi.getNombre());
     }

}
