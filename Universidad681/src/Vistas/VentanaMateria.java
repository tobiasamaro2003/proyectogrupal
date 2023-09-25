/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoADatos.MateriaData;
import Entidades.Materia;
import javax.swing.JOptionPane;

/**
 *
 * @author Zona
 */
public class VentanaMateria extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaMateria
     */
    public VentanaMateria() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtCodigoMateria = new javax.swing.JTextField();
        jtNombreMateria = new javax.swing.JTextField();
        jtAnioMateria = new javax.swing.JTextField();
        jrbEstadoMateria = new javax.swing.JRadioButton();
        jbNuevoMateria = new javax.swing.JButton();
        jbEliminarMateria = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jLabel1.setText("Materia");

        jLabel2.setText("Código");

        jLabel3.setText("Nombre");

        jLabel4.setText("Año");

        jLabel5.setText("Estado");

        jtNombreMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNombreMateriaActionPerformed(evt);
            }
        });

        jbNuevoMateria.setText("Nuevo");
        jbNuevoMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoMateriaActionPerformed(evt);
            }
        });

        jbEliminarMateria.setText("Eliminar");
        jbEliminarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarMateriaActionPerformed(evt);
            }
        });

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");

        jButton5.setText("Buscar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbNuevoMateria)
                                .addGap(18, 18, 18)
                                .addComponent(jbEliminarMateria)
                                .addGap(18, 18, 18)
                                .addComponent(jbGuardar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtNombreMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtCodigoMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtAnioMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jrbEstadoMateria))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(jbSalir)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabel1)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtCodigoMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtNombreMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtAnioMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jrbEstadoMateria))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevoMateria)
                    .addComponent(jbEliminarMateria)
                    .addComponent(jbGuardar)
                    .addComponent(jbSalir))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtNombreMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreMateriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombreMateriaActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Materia materia = new Materia();
        MateriaData materiaData = new MateriaData();
        try {
            if (jtCodigoMateria.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "no debe haber campos vacios");
                return;
            }
            materia = materiaData.buscarMateria(Integer.parseInt(jtCodigoMateria.getText()));
            jtNombreMateria.setText(materia.getNombre());
            jrbEstadoMateria.setSelected(materia.isEstado());
            jtAnioMateria.setText(Integer.toString(materia.getAnio()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "SOLO INGRESE NÚMEROS");
        } catch (NullPointerException e) {

            JOptionPane.showMessageDialog(null, "INGRESA UN CÓDIGO VALIDO");

        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jbNuevoMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoMateriaActionPerformed
        // TODO add your handling code here:

        jtCodigoMateria.setText("");
        jtNombreMateria.setText("");
        jrbEstadoMateria.setSelected(false);
        jtAnioMateria.setText("");
    }//GEN-LAST:event_jbNuevoMateriaActionPerformed

    private void jbEliminarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarMateriaActionPerformed
        // TODO add your handling code here:

        MateriaData materiaData = new MateriaData();
        Materia materia = new Materia();
        try {

            if (jtCodigoMateria.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "no debe haber campos vacios");
                return;
            }
            materia = materiaData.buscarMateria(Integer.parseInt(jtCodigoMateria.getText()));
            materiaData.eliminarMateria(materia.getIdMateria());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "SOLO INGRESE NÚMEROS");

        } catch (NullPointerException e) {

            JOptionPane.showMessageDialog(null, "INGRESA UN CÓDIGO VALIDO");

        }

    }//GEN-LAST:event_jbEliminarMateriaActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // TODO add your handling code here:
        MateriaData materiaData = new MateriaData();

        if (jtCodigoMateria.getText().isEmpty()) {
            
            Materia nuevaMateria = new Materia(jtNombreMateria.getText(), Integer.parseInt(jtAnioMateria.getText()), jrbEstadoMateria.isSelected());

            materiaData.guardarMateria(nuevaMateria);

        } else {
            Materia materiaModificada = new Materia(Integer.parseInt(jtCodigoMateria.getText()), jtNombreMateria.getText(), Integer.parseInt(jtAnioMateria.getText()), jrbEstadoMateria.isSelected());
           
            materiaData.buscarMateria(materiaModificada.getIdMateria());
            
            materiaData.modificarMateria(materiaModificada);
        }
    }//GEN-LAST:event_jbGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbEliminarMateria;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevoMateria;
    private javax.swing.JButton jbSalir;
    private javax.swing.JRadioButton jrbEstadoMateria;
    private javax.swing.JTextField jtAnioMateria;
    private javax.swing.JTextField jtCodigoMateria;
    private javax.swing.JTextField jtNombreMateria;
    // End of variables declaration//GEN-END:variables
}
