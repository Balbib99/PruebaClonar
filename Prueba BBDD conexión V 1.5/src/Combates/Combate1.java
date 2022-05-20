package Combates;

import Bienvenida.PantallaDerrota;
import Bienvenida.PantallaVictoria;
import SeleccionPersonajes.SeleccionPersonajes;
import clasesproyecto.Enemigo;
import clasesproyecto.Movimientos;
import clasesproyecto.Personaje;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author DAM
 */
public class Combate1 extends javax.swing.JFrame {
    
    /**
     * Creates new form Interfaz
     */
    FondoPanel fondo = new FondoPanel(); //PANEL PARA PODER INTRODUCIR COSAS
    SeleccionPersonajes aux = new SeleccionPersonajes();
    Personaje balbi = new Personaje("Balbi");   //PERSONAJE EN PARTIDA
    Enemigo bruja = new Enemigo("bruja");   //ENEMIGO EN PARTIDA
    /**
     * VARIABLES PARA TIMER
     *
     */
    boolean botonPulsado = false;   // BOOLEANO QUE CONTROLA SI UN BOTON HA SIDO PULSADO O NO
    String text = "";   // TEXTO QUE SE UTILIZARÁ PARA ESCRIBIR EN PANTALLA
    String tipo = "";   //STRING PARA PASAR AL METODO DAÑO EL TIPO DE ATAQUE
    int i = 0;  // CONTADOR CREADO PARA FUNCIONAMIENTO DEL TIMER
    int j = 0;
    int contadoreo = 0;
    int movIn;
    
    
    /**
     * FONDO DE PANEL
     *
     */
    class FondoPanel extends JPanel {

        private Image fondo;

        @Override
        public void paint(Graphics g) {
            fondo = new ImageIcon(getClass().getResource("/combates/Escenario3.gif")).getImage();

            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), (ImageObserver) this);
            setOpaque(false);

            super.paint(g);
        }
    }
    
    /**
     * ICONO PERSONAJE SELECCIONADO
     */
    public Icon iconoPj;  //ICONO ESCOGIDO EN SELECCION PERSONAJE
    public String nombrePj; //NOMBRE PJ ESCOGIDO EN SELECCION PERSONAJE

    /**
     * CONTRLADORES COMBATE
     */
    int contFuerte = 0;
    int contProt = 0;
    boolean ultimate = true;

    public Combate1() {

        //ASIGNACION DE MOVIMIENTOS AL PERSONAJE

        initComponents();
        this.movIn = jLabel1Personaje.getX();
        botonDebil.setText(balbi.getDebil().getNombre().toUpperCase());
        botonFuerte.setText(balbi.getFuerte().getNombre().toUpperCase());
        botonProteccion.setText(balbi.getProtec().getNombre().toUpperCase());
        botonUlti.setText(balbi.getUlti().getNombre().toUpperCase());
        /**
         * ICONO PERSONAJE ELEGIDO
         */
        nombrePj = aux.getNombrePj();
        iconoPj = aux.getPjElegido();
        jLabel1Personaje.setBounds(movIn,jLabel1Personaje.getY(), 0, 0);
        jLabel1Personaje.setIcon(iconoPj);
        jLabel1Personaje.setVisible(true);
        jProgressBar1Personaje.setValue(100);
        jProgressBar2Enemigo.setValue(100);
    }

    //TIMER QUE PERMITE MOSTRAR LETRA A LETRA EL TEXTO
    Timer timer = new Timer(25, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            char character[] = text.toCharArray();
            int arrayNumber = character.length;

            String addedCharacter = "";
            String blank = "";
                 
            if (i < arrayNumber) {
                addedCharacter = blank + character[i];
                areaCombate.append(addedCharacter);
            } else {
                i = 0;
                areaCombate.append("\n");
                botonPulsado = false;
                jLabel1Personaje.setBounds(movIn,jLabel1Personaje.getY(), 200, 200);
                timer.stop();
            }

            i++;
        }
    });
    
    //TIMER MOVIMIENTO
    Timer mov = new Timer(5, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            jLabel1Personaje.setBounds(movIn+j,jLabel1Personaje.getY(),200, 200);
            if (j>60) {
                j=0;
                contadoreo++;
            }
            
            if(contadoreo>=2){
                contadoreo=0;
                jLabel1Personaje.setBounds(movIn,jLabel1Personaje.getY(),200,200);
                timer.start();
                mov.stop();
            }
            j++;
        }
    });
    // METODO QUE EVALUA EL ESTADO DE LA PARTIDA Y EN FUNCION DE LAS CONDICIONES PUEDE ABRIR UNA PANTALLA U OTRA
    /**
     *
     */
    public void estadoPartida() {
        if (bruja.getVida() <= 0 && balbi.getVida() <= 0) {
            JOptionPane.showMessageDialog(null, "A pesar de haber sido derrotados ambos, tú has atacado primero, por lo tanto has ganado");
            PantallaVictoria abrir = new PantallaVictoria();
            abrir.setVisible(true);
            this.setVisible(false);
        } else if (balbi.getVida() <= 0) {
            JOptionPane.showMessageDialog(null, "En el ultimo ataque de la bruja te inflingio suficiente daño para matarte, GAME OVER");
            PantallaDerrota abrir = new PantallaDerrota();
            abrir.setVisible(true);
            this.setVisible(false);
        } else if (bruja.getVida() <= 0) {
            JOptionPane.showMessageDialog(null, "En tu ultimo ataque causaste el daño necesario para matar al enemigo, has ganado");
            PantallaVictoria abrir = new PantallaVictoria();
            abrir.setVisible(true);
            this.setVisible(false);
        }

    }

    // METODO QUE EVALUA EL DAÑO 
    /**
     *
     * @param num
     * @param tipo
     */
    public void daño(int num, String tipo) {
        if (tipo.toLowerCase().equals("debil")) {
            bruja.setVida(bruja.getVida() - balbi.getDebil().getDaño());
            balbi.setVida(balbi.getVida() - bruja.getAtaques().get(num).getDaño());   
        } else if (tipo.toLowerCase().equals("fuerte")) {
            bruja.setVida(bruja.getVida() - balbi.getFuerte().getDaño());
            balbi.setVida(balbi.getVida() - bruja.getAtaques().get(num).getDaño());   
        } else if (tipo.toLowerCase().equals("ulti")) {
            bruja.setVida(bruja.getVida() - balbi.getUlti().getDaño());
            balbi.setVida(balbi.getVida() - bruja.getAtaques().get(num).getDaño());   
        }
        
        //Progreso de la barra de daño del Personaje aliado
        if (bruja.getAtaques().get(num).getTipo().toLowerCase().equals("debil")) {
            jProgressBar1Personaje.setValue(jProgressBar1Personaje.getValue()-10);
        }else if (bruja.getAtaques().get(num).getTipo().toLowerCase().equals("fuerte")) {
            jProgressBar1Personaje.setValue(jProgressBar1Personaje.getValue()-25);
        }else if (bruja.getAtaques().get(num).getTipo().toLowerCase().equals("ulti")) {
            jProgressBar1Personaje.setValue(jProgressBar1Personaje.getValue()-50);
        }   
    }

    /**
     *
     * Elementos a usar durante los combates
     *
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanel();
        jLabel1Personaje = new javax.swing.JLabel();
        jProgressBar1Personaje = new javax.swing.JProgressBar();
        jProgressBar2Enemigo = new javax.swing.JProgressBar();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaCombate = new javax.swing.JTextArea();
        botonDebil = new javax.swing.JButton();
        botonFuerte = new javax.swing.JButton();
        botonProteccion = new javax.swing.JButton();
        botonUlti = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jProgressBar1Personaje.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar1Personaje.setForeground(new java.awt.Color(255, 0, 0));

        jProgressBar2Enemigo.setForeground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jLabel1Personaje, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jProgressBar1Personaje, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jProgressBar2Enemigo, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar2Enemigo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBar1Personaje, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addComponent(jLabel1Personaje, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        areaCombate.setColumns(20);
        areaCombate.setRows(5);
        jScrollPane1.setViewportView(areaCombate);

        botonDebil.setText("ATAQUE DÉBIL");
        botonDebil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonDebilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonDebilMouseExited(evt);
            }
        });
        botonDebil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDebilActionPerformed(evt);
            }
        });

        botonFuerte.setText("ATAQUE FUERTE");
        botonFuerte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonFuerteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonFuerteMouseExited(evt);
            }
        });
        botonFuerte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFuerteActionPerformed(evt);
            }
        });

        botonProteccion.setText("PROTECCIÓN");
        botonProteccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonProteccionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonProteccionMouseExited(evt);
            }
        });
        botonProteccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonProteccionActionPerformed(evt);
            }
        });

        botonUlti.setText("ATAQUEULTIMATE");
        botonUlti.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        botonUlti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonUltiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonUltiMouseExited(evt);
            }
        });
        botonUlti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonUltiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonFuerte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonDebil, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonUlti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonProteccion, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(267, 267, 267))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(botonDebil, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonFuerte, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(botonProteccion, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonUlti, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //METODO QUE EVALUA DISTINTAS OPCIONES TRAS ATAQUE DEBIL
    private void textToTimerDebil(Personaje balbi, Enemigo bruja) {
        Random rd = new Random();

        int num = rd.nextInt(4);
        tipo = "debil";

        if (bruja.getAtaques().get(num).getTipo().toLowerCase().equals("proteccion")) {

            text = ("\nHas realizado el ataque " + balbi.getDebil().getNombre()
                    + "\nEl enemigo ha usado " + bruja.getAtaques().get(num).getNombre()) + " y se ha protegido."
                    + "\nTu vida es :" + balbi.getVida()
                    + "\nVida restante enemigo: " + bruja.getVida();

        } else {
            daño(num, tipo);
            text = ("\nHas realizado el ataque " + balbi.getDebil().getNombre() + " has hecho " + balbi.getDebil().getDaño() + " de damage"
                    + "\nVida restante enemigo: " + bruja.getVida()
                    + "\nEl enemigo ha realizado el ataque " + bruja.getAtaques().get(num).getNombre()) + " ha hecho " + bruja.getAtaques().get(num).getDaño() + " de damage"
                    + "\nTu vida es :" + balbi.getVida();
            
            jProgressBar2Enemigo.setValue(jProgressBar2Enemigo.getValue()-10);
        }

    }

    //EVENTO AL PULSAR BOTON DEBIL
    private void botonDebilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDebilActionPerformed

        if (botonPulsado == false) {
            botonPulsado = true;
            System.out.println(text);
            textToTimerDebil(balbi, bruja);
            mov.start();

            if (contFuerte != 0) {
                contFuerte--;
            }
            if (contFuerte == 0) {
                botonFuerte.setEnabled(true);
            }
            if (contProt != 0) {
                contProt--;
            }
            if (contProt == 0) {
                botonProteccion.setEnabled(true);
            }

            estadoPartida();
        }


    }//GEN-LAST:event_botonDebilActionPerformed

    // METODO QUE EVALUA CONDICIONES TRAS ATAQUE ULTI
    private void textToTimerUlti(Personaje balbi, Enemigo bruja) {
        Random rd = new Random();

        int num = rd.nextInt(4);
        tipo = "ulti";

        if (bruja.getAtaques().get(num).getTipo().toLowerCase().equals("proteccion")) {
            text = ("\nHas realizado el ataque " + balbi.getUlti().getNombre()
                    + "\nEl enemigo ha usado " + bruja.getAtaques().get(num).getNombre()) + " y se ha protegido"
                    + "\nTu vida es :" + balbi.getVida()
                    + "\nVida restante enemigo: " + bruja.getVida();

        } else {

            daño(num, tipo);
            text = ("\nHas realizado el ataque " + balbi.getUlti().getNombre() + " has hecho " + balbi.getUlti().getDaño() + " de damage"
                    + "\nVida restante enemigo: " + bruja.getVida()
                    + "\nEl enemigo ha realizado el ataque " + bruja.getAtaques().get(num).getNombre()) + " ha hecho " + bruja.getAtaques().get(num).getDaño() + " de damage"
                    + "\nTu vida es :" + balbi.getVida();
            
            jProgressBar2Enemigo.setValue(jProgressBar2Enemigo.getValue()-50);
        }

    }

    //EVENTO TRAS PULSAR BOTON ULTI
    private void botonUltiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonUltiActionPerformed
        if (ultimate) {
            if (botonPulsado == false) {
                botonPulsado = true;
                textToTimerUlti(balbi, bruja);
                mov.start();
                estadoPartida();
                botonUlti.setEnabled(false);
            }
            if (contFuerte != 0) {
                contFuerte--;
            }
            if (contFuerte == 0) {
                botonFuerte.setEnabled(true);
            }
            if (contProt != 0) {
                contProt--;
            }
            if (contProt == 0) {
                botonProteccion.setEnabled(true);
            }
        }

    }//GEN-LAST:event_botonUltiActionPerformed

    //  METODO QUE EVALUA CONDICIONES TRAS ATAQUE FUERTE
    private void textToTimerFuerte(Personaje balbi, Enemigo bruja) {
        Random rd = new Random();

        int num = rd.nextInt(4);
        tipo = "fuerte";
        if (bruja.getAtaques().get(num).getTipo().toLowerCase().equals("proteccion")) {
            text = ("\nHas realizado el ataque " + balbi.getFuerte().getNombre()
                    + "\nEl enemigo ha utilizado " + bruja.getAtaques().get(num).getNombre()) + " y se ha protegido"
                    + "\nTu vida es :" + balbi.getVida()
                    + "\nVida restante enemigo: " + bruja.getVida();

        } else {
            daño(num, tipo);
            text = ("\nHas realizado el ataque " + balbi.getFuerte().getNombre() + " has hecho " + balbi.getFuerte().getDaño() + " de damage"
                    + "\nVida restante enemigo: " + bruja.getVida()
                    + "\nEl enemigo ha realizado el ataque " + bruja.getAtaques().get(num).getNombre()) + " ha hecho " + bruja.getAtaques().get(num).getDaño() + " de damage"
                    + "\nTu vida es :" + balbi.getVida();
            
            jProgressBar2Enemigo.setValue(jProgressBar2Enemigo.getValue()-25);
        }

    }

    //  EVENTO TRAS PULSAR BOTON FUERTE
    private void botonFuerteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFuerteActionPerformed

        if (contFuerte == 0) {
            if (botonPulsado == false) {
                botonPulsado = true;
                textToTimerFuerte(balbi, bruja);
                mov.start();
                botonFuerte.setEnabled(false);
            }

            estadoPartida();
            contFuerte = 2;

            if (contProt != 0) {
                contProt--;
            }
            if (contProt == 0) {
                botonProteccion.setEnabled(true);
            }
        }


    }//GEN-LAST:event_botonFuerteActionPerformed

    //  METODO QUE EVALUA CONDICIONES TRAS PROTECCION
    private void textToTimerProtec(Personaje balbi, Enemigo bruja) {
        Random rd = new Random();

        int num = rd.nextInt(4);
        balbi.setVida(balbi.getVida() - 0);

        int i = 0;
        text = ("\nHas usado " + balbi.getProtec().getNombre() + ". Te has protegido"
                + "\nEl enemigo ha realizado el ataque " + bruja.getAtaques().get(num).getNombre() + " pero no ha surgido efecto")
                + "\nTu vida: " + balbi.getVida() + "\n"
                + "Vida del rival: " + bruja.getVida();

    }

    //  EVENTO TRAS PULSAR BOTON PROTECCION
    private void botonProteccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonProteccionActionPerformed
        if (contProt == 0) {
            if (botonPulsado == false) {
                botonPulsado = true;
                textToTimerProtec(balbi, bruja);
                mov.start();
                contProt = 2;
                botonProteccion.setEnabled(false);

                if (contFuerte != 0) {
                    contFuerte--;
                }
                if (contFuerte == 0) {
                    botonFuerte.setEnabled(true);
                }
            }
        }


    }//GEN-LAST:event_botonProteccionActionPerformed

    private void botonUltiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonUltiMouseEntered
        botonUlti.setSize(200, 60);
    }//GEN-LAST:event_botonUltiMouseEntered

    private void botonUltiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonUltiMouseExited
        botonUlti.setSize(140, 50);
    }//GEN-LAST:event_botonUltiMouseExited

    private void botonProteccionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonProteccionMouseEntered
        botonProteccion.setSize(200, 60);
    }//GEN-LAST:event_botonProteccionMouseEntered

    private void botonProteccionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonProteccionMouseExited
        botonProteccion.setSize(140, 50);
    }//GEN-LAST:event_botonProteccionMouseExited

    private void botonDebilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonDebilMouseEntered
        botonDebil.setSize(200, 60);
    }//GEN-LAST:event_botonDebilMouseEntered

    private void botonDebilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonDebilMouseExited
        botonDebil.setSize(140, 50);
    }//GEN-LAST:event_botonDebilMouseExited

    private void botonFuerteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonFuerteMouseEntered
        botonFuerte.setSize(200, 60);
    }//GEN-LAST:event_botonFuerteMouseEntered

    private void botonFuerteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonFuerteMouseExited
        botonFuerte.setSize(140, 50);
    }//GEN-LAST:event_botonFuerteMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Combate1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Combate1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Combate1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Combate1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */;
        java.awt.EventQueue.invokeLater(() -> {
            new Combate1().setVisible(true);
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaCombate;
    private javax.swing.JButton botonDebil;
    private javax.swing.JButton botonFuerte;
    private javax.swing.JButton botonProteccion;
    private javax.swing.JButton botonUlti;
    private javax.swing.JLabel jLabel1Personaje;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1Personaje;
    private javax.swing.JProgressBar jProgressBar2Enemigo;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    
}
