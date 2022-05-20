/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesproyecto;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author admin
 */
public class Movimientos {

    public int ID, daño;
    public String tipo, nombre;
    public Connection conexion;
    public Statement miStatement;
    public ResultSet miResultSet;

    public Movimientos(int ID, int daño, String tipo, String nombre) {
        this.ID = ID;
        this.daño = daño;
        this.tipo = tipo;
        this.nombre = nombre;

    }

    public Movimientos() {

    }

    public static Movimientos obtenerMovimientoDebil() {

        ArrayList<Movimientos> debil = new ArrayList();

        String nombre = "debil";

        //METODOS CONEXION A BBDD
        try {
            //CREAR CONEXION
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/juego", "root", "101099");

            //CREAR STATEMENT
            Statement miStatement = Conexion.createStatement();

            //CREAR RESULTSET O CONSULTA
            ResultSet miResulset = miStatement.executeQuery("SELECT * FROM MOVIMIENTOS");

            while (miResulset.next()) {
                if (miResulset.getString("Tipo").toLowerCase().equals(nombre)) {

                    Movimientos movDebil = new Movimientos(miResulset.getInt("ID"), miResulset.getInt("daño"), miResulset.getString("tipo"), miResulset.getString("nombre"));

                    debil.add(movDebil);
                }
            }

        } catch (Exception e) {
            System.out.println("No se ha encontrado movimiento");
        }

        Random random = new Random();

        int n = random.nextInt(debil.size());

        return debil.get(n);

    }

    public static Movimientos obtenerMovimientoFuerte() {
        ArrayList<Movimientos> fuerte = new ArrayList();

        String nombre = "fuerte";

        //METODOS CONEXION A BBDD
        try {
            //CREAR CONEXION
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/juego", "root", "101099");

            //CREAR STATEMENT
            Statement miStatement = Conexion.createStatement();

            //CREAR RESULTSET O CONSULTA
            ResultSet miResulset = miStatement.executeQuery("SELECT * FROM MOVIMIENTOS");

            while (miResulset.next()) {
                if (miResulset.getString("Tipo").toLowerCase().equals(nombre)) {

                    Movimientos movfuerte = new Movimientos(miResulset.getInt("ID"), miResulset.getInt("daño"), miResulset.getString("tipo"), miResulset.getString("nombre"));

                    fuerte.add(movfuerte);
                }
            }

        } catch (Exception e) {
            System.out.println("No se ha encontrado movimiento");
        }

        Random random = new Random();

        int n = random.nextInt(fuerte.size());

        return fuerte.get(n);

    }

    public static Movimientos obtenerMovimientoProtec() {
        ArrayList<Movimientos> protec = new ArrayList();

        String nombre = "proteccion";

        //METODOS CONEXION A BBDD
        try {
            //CREAR CONEXION
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/juego", "root", "101099");

            //CREAR STATEMENT
            Statement miStatement = Conexion.createStatement();

            //CREAR RESULTSET O CONSULTA
            ResultSet miResulset = miStatement.executeQuery("SELECT * FROM MOVIMIENTOS");

            while (miResulset.next()) {
                if (miResulset.getString("Tipo").toLowerCase().equals(nombre)) {

                    Movimientos movDebil = new Movimientos(miResulset.getInt("ID"), miResulset.getInt("daño"), miResulset.getString("tipo"), miResulset.getString("nombre"));

                    protec.add(movDebil);
                }
            }

        } catch (Exception e) {
            System.out.println("No se ha encontrado movimiento");
        }

        Random random = new Random();

        int n = random.nextInt(protec.size());

        return protec.get(n);

    }

    public static Movimientos obtenerMovimientoUlti() {
        ArrayList<Movimientos> ulti = new ArrayList();

        String nombre = "ultimate";

        //METODOS CONEXION A BBDD
        try {
            //CREAR CONEXION
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/juego", "root", "101099");

            //CREAR STATEMENT
            Statement miStatement = Conexion.createStatement();

            //CREAR RESULTSET O CONSULTA
            ResultSet miResulset = miStatement.executeQuery("SELECT * FROM MOVIMIENTOS");

            while (miResulset.next()) {
                if (miResulset.getString("Tipo").toLowerCase().equals(nombre)) {

                    Movimientos movDebil = new Movimientos(miResulset.getInt("ID"), miResulset.getInt("daño"), miResulset.getString("tipo"), miResulset.getString("nombre"));

                    ulti.add(movDebil);
                }
            }

        } catch (Exception e) {
            System.out.println("No se ha encontrado movimiento");
        }

        Random random = new Random();

        int n = random.nextInt(ulti.size());

        return ulti.get(n);

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
