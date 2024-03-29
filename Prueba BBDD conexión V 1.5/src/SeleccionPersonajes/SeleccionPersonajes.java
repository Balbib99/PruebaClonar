package SeleccionPersonajes;

import Combates.Combate1;
import Bienvenida.NivelEspecial;
import Bienvenida.Personajes;
import clasesproyecto.Movimientos;
import clasesproyecto.Personaje;
import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author balbi
 */
public class SeleccionPersonajes extends javax.swing.JFrame {

    public static Icon pjElegido;  //SELECCIONAR ICONO
    public static String nombrePj; //SELECCIONAR NOMBRE PJ
    Personajes personaje;   //CREACION PJ      
    /**
     * Creates new form NewJFrame
     */
    public SeleccionPersonajes() {
        initComponents();
        Movimientos.obtenerMovimientoDebil();
    }

    //MOSTRAR GIFS DIBUJOS
    Personaje elegir = new Personaje("");
    Icon mario = new ImageIcon(getClass().getResource("Xysh.gif"));
    Icon goku = new ImageIcon(getClass().getResource("Goku.gif"));
    Icon naruto = new ImageIcon(getClass().getResource("Naruto.gif"));
    Icon ezio = new ImageIcon(getClass().getResource("ezzio.gif"));
    Icon kratos = new ImageIcon(getClass().getResource("krathos.gif"));
    Icon luffy = new ImageIcon(getClass().getResource("luffy.gif"));
    Icon luigi = new ImageIcon(getClass().getResource("Louigi.gif"));
    Icon ryu = new ImageIcon(getClass().getResource("Ryu.gif"));

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupSeleccionPersonajes = new javax.swing.ButtonGroup();
        jLabel1Ezio = new javax.swing.JLabel();
        jLabel4Luigi = new javax.swing.JLabel();
        jLabel6Mario = new javax.swing.JLabel();
        jLabel2Naruto = new javax.swing.JLabel();
        jLabel5Goku = new javax.swing.JLabel();
        jLabel7Ryu = new javax.swing.JLabel();
        jLabel8Kratos = new javax.swing.JLabel();
        jLabel9Luffy = new javax.swing.JLabel();
        jRadioButtonLouigi = new javax.swing.JRadioButton();
        jRadioButtonMario = new javax.swing.JRadioButton();
        jRadioButtonGoku = new javax.swing.JRadioButton();
        jRadioButtonLuffy = new javax.swing.JRadioButton();
        jRadioButtonKratos = new javax.swing.JRadioButton();
        jRadioButtonNaruto = new javax.swing.JRadioButton();
        jRadioButtonEzzio = new javax.swing.JRadioButton();
        jRadioButtonRyu = new javax.swing.JRadioButton();
        jTextField1Usuario = new javax.swing.JTextField();
        jTextField1Error = new javax.swing.JTextField();
        jButton2Combate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1Ezio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SeleccionPersonajes/ezzio.gif"))); // NOI18N

        jLabel4Luigi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SeleccionPersonajes/Louigi.gif"))); // NOI18N
        jLabel4Luigi.setPreferredSize(new java.awt.Dimension(85, 85));

        jLabel6Mario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SeleccionPersonajes/Xysh.gif"))); // NOI18N

        jLabel2Naruto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SeleccionPersonajes/Naruto.gif"))); // NOI18N
        jLabel2Naruto.setPreferredSize(new java.awt.Dimension(85, 85));

        jLabel5Goku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SeleccionPersonajes/Goku.gif"))); // NOI18N

        jLabel7Ryu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SeleccionPersonajes/Ryu.gif"))); // NOI18N
        jLabel7Ryu.setPreferredSize(new java.awt.Dimension(85, 85));

        jLabel8Kratos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SeleccionPersonajes/krathos.gif"))); // NOI18N
        jLabel8Kratos.setPreferredSize(new java.awt.Dimension(85, 85));

        jLabel9Luffy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SeleccionPersonajes/luffy.gif"))); // NOI18N
        jLabel9Luffy.setPreferredSize(new java.awt.Dimension(85, 85));

        buttonGroupSeleccionPersonajes.add(jRadioButtonLouigi);
        jRadioButtonLouigi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonLouigiActionPerformed(evt);
            }
        });

        buttonGroupSeleccionPersonajes.add(jRadioButtonMario);
        jRadioButtonMario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMarioActionPerformed(evt);
            }
        });

        buttonGroupSeleccionPersonajes.add(jRadioButtonGoku);
        jRadioButtonGoku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonGokuActionPerformed(evt);
            }
        });

        buttonGroupSeleccionPersonajes.add(jRadioButtonLuffy);
        jRadioButtonLuffy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonLuffyActionPerformed(evt);
            }
        });

        buttonGroupSeleccionPersonajes.add(jRadioButtonKratos);
        jRadioButtonKratos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonKratosActionPerformed(evt);
            }
        });

        buttonGroupSeleccionPersonajes.add(jRadioButtonNaruto);
        jRadioButtonNaruto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNarutoActionPerformed(evt);
            }
        });

        buttonGroupSeleccionPersonajes.add(jRadioButtonEzzio);
        jRadioButtonEzzio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEzzioActionPerformed(evt);
            }
        });

        buttonGroupSeleccionPersonajes.add(jRadioButtonRyu);
        jRadioButtonRyu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonRyuActionPerformed(evt);
            }
        });

        jButton2Combate.setText("Combate1");
        jButton2Combate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2CombateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8Kratos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButtonKratos)
                        .addGap(184, 184, 184)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2Naruto, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButtonNaruto)
                                .addGap(166, 166, 166)
                                .addComponent(jRadioButtonEzzio)
                                .addGap(187, 187, 187)
                                .addComponent(jRadioButtonRyu))))
                    .addComponent(jTextField1Error, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonLouigi)
                            .addComponent(jLabel4Luigi, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(131, 131, 131)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonMario)
                            .addComponent(jLabel6Mario))
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5Goku)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9Luffy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButtonGoku)
                                    .addComponent(jLabel1Ezio, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(101, 101, 101)
                                        .addComponent(jLabel7Ryu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(96, 96, 96)
                                        .addComponent(jRadioButtonLuffy)))))))
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2Combate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9Luffy, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4Luigi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5Goku, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6Mario))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jRadioButtonLuffy)
                                    .addComponent(jRadioButtonLouigi)
                                    .addComponent(jRadioButtonMario)
                                    .addComponent(jRadioButtonGoku))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1Ezio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7Ryu, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2Naruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8Kratos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonEzzio)
                            .addComponent(jRadioButtonRyu)
                            .addComponent(jRadioButtonNaruto)
                            .addComponent(jRadioButtonKratos))
                        .addGap(98, 98, 98)
                        .addComponent(jTextField1Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jTextField1Error, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)))
                .addComponent(jButton2Combate, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Icon getPjElegido() {
        return pjElegido;
    }

    public String getNombrePj() {
        return nombrePj;
    }
    
    //METODO CONEXION BBDD
    

    //METODO PARA SELECCIONAR PERSONAJE
    private void seleccionarPersonaje() {
        if (jRadioButtonEzzio.isSelected()) {
            this.pjElegido = ezio;
            this.nombrePj = "ezzio";
        } else if (jRadioButtonGoku.isSelected()) {
            this.pjElegido = goku;
            this.nombrePj = "goku";
        } else if (jRadioButtonKratos.isSelected()) {
            this.pjElegido = kratos;
            this.nombrePj = "kratos";
        } else if (jRadioButtonLouigi.isSelected()) {
            this.pjElegido = luigi;
            this.nombrePj = "luigi";
        } else if (jRadioButtonLuffy.isSelected()) {
            this.pjElegido = luffy;
            this.nombrePj = "luffy";
        } else if (jRadioButtonMario.isSelected()) {
            this.pjElegido = mario;
            this.nombrePj = "mario";
        } else if (jRadioButtonNaruto.isSelected()) {
            this.pjElegido = naruto;
            this.nombrePj = "naruto";
        } else if (jRadioButtonRyu.isSelected()) {
            this.pjElegido = ryu;
            this.nombrePj = "ryu";
        }
    }

    private void jRadioButtonMarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMarioActionPerformed
        if (jRadioButtonMario.isSelected()) {
            JOptionPane.showMessageDialog(null, " Mario tendrá que luchar contra la bruja para salvar a la princesa ", null, JOptionPane.PLAIN_MESSAGE, mario);
        }
    }//GEN-LAST:event_jRadioButtonMarioActionPerformed

    private void jRadioButtonLouigiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonLouigiActionPerformed
        if (jRadioButtonLouigi.isSelected()) {
            JOptionPane.showMessageDialog(null, " Mario tendrá que luchar contra la bruja para salvar a la princesa ", null, JOptionPane.PLAIN_MESSAGE, luigi);
        }
    }//GEN-LAST:event_jRadioButtonLouigiActionPerformed

    private void jRadioButtonGokuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonGokuActionPerformed
        if (jRadioButtonGoku.isSelected()) {
            JOptionPane.showMessageDialog(null, " El universo 7 está en manos de Goku. Será capaz de derotarlos a todos? ", null, JOptionPane.PLAIN_MESSAGE, goku);
        }
    }//GEN-LAST:event_jRadioButtonGokuActionPerformed

    private void jRadioButtonLuffyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonLuffyActionPerformed
        if (jRadioButtonLuffy.isSelected()) {
            JOptionPane.showMessageDialog(null, " Acompañame y observa con tus propios ojos, como me convierto en el rey de los piratas!! jejeee ", null, JOptionPane.PLAIN_MESSAGE, luffy);
        }
    }//GEN-LAST:event_jRadioButtonLuffyActionPerformed

    private void jRadioButtonKratosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonKratosActionPerformed
        if (jRadioButtonKratos.isSelected()) {
            JOptionPane.showMessageDialog(null, " Si todos en el olimpo me niegan mi venganza, entonces todos en el olimpo morirán ", null, JOptionPane.PLAIN_MESSAGE, kratos);
        }
    }//GEN-LAST:event_jRadioButtonKratosActionPerformed

    private void jRadioButtonNarutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNarutoActionPerformed
        if (jRadioButtonNaruto.isSelected()) {
            JOptionPane.showMessageDialog(null, " La Villa oculta de la Hoja está en peligro! Naruto ayudanos! ", null, JOptionPane.PLAIN_MESSAGE, naruto);
        }
    }//GEN-LAST:event_jRadioButtonNarutoActionPerformed

    private void jRadioButtonEzzioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEzzioActionPerformed
        if (jRadioButtonEzzio.isSelected()) {
            JOptionPane.showMessageDialog(null, " La Villa oculta de la Hoja está en peligro! Naruto ayudanos! ", null, JOptionPane.PLAIN_MESSAGE, ezio);
        }
    }//GEN-LAST:event_jRadioButtonEzzioActionPerformed

    private void jRadioButtonRyuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonRyuActionPerformed
        if (jRadioButtonRyu.isSelected()) {
            JOptionPane.showMessageDialog(null, " El viaje que me llevará a ser el guerrero definitivo acaba de comenzar! ", null, JOptionPane.PLAIN_MESSAGE, ryu);
        }
    }//GEN-LAST:event_jRadioButtonRyuActionPerformed

    private void jButton2CombateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2CombateActionPerformed

        seleccionarPersonaje();
        Combate1 abrir = new Combate1();
        abrir.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jButton2CombateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SeleccionPersonajes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupSeleccionPersonajes;
    private javax.swing.JButton jButton2Combate;
    private javax.swing.JLabel jLabel1Ezio;
    private javax.swing.JLabel jLabel2Naruto;
    private javax.swing.JLabel jLabel4Luigi;
    private javax.swing.JLabel jLabel5Goku;
    private javax.swing.JLabel jLabel6Mario;
    private javax.swing.JLabel jLabel7Ryu;
    private javax.swing.JLabel jLabel8Kratos;
    private javax.swing.JLabel jLabel9Luffy;
    private javax.swing.JRadioButton jRadioButtonEzzio;
    private javax.swing.JRadioButton jRadioButtonGoku;
    private javax.swing.JRadioButton jRadioButtonKratos;
    private javax.swing.JRadioButton jRadioButtonLouigi;
    private javax.swing.JRadioButton jRadioButtonLuffy;
    private javax.swing.JRadioButton jRadioButtonMario;
    private javax.swing.JRadioButton jRadioButtonNaruto;
    private javax.swing.JRadioButton jRadioButtonRyu;
    private javax.swing.JTextField jTextField1Error;
    private javax.swing.JTextField jTextField1Usuario;
    // End of variables declaration//GEN-END:variables
}
