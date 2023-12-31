package Vistas;

import AccesoADatos.AlumnoData;
import AccesoADatos.InscripcionData;
import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VentanaInscripciones extends javax.swing.JInternalFrame {
    
    private DefaultTableModel modelo = new DefaultTableModel();//Importación del DefaultTableModel

    public VentanaInscripciones() {
        initComponents();
        cargarCabecera();
        cargarCombo();
        //seleccionBoton();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbBuscarAlumno = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        JRBInscriptas = new javax.swing.JRadioButton();
        JRBNOInscriptas = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTablaInscripciones = new javax.swing.JTable();
        JBInscribir = new javax.swing.JButton();
        JBAnular = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Formulario de Inscripcion");

        jLabel2.setText("Seleccione un alumno");

        jcbBuscarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBuscarAlumnoActionPerformed(evt);
            }
        });

        jLabel3.setText("Listado de Materias");

        JRBInscriptas.setText("Materias Inscriptas");
        JRBInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBInscriptasActionPerformed(evt);
            }
        });

        JRBNOInscriptas.setText("Materias no inscriptas");
        JRBNOInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBNOInscriptasActionPerformed(evt);
            }
        });

        jtTablaInscripciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtTablaInscripciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTablaInscripcionesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtTablaInscripciones);

        JBInscribir.setText("Inscribir");
        JBInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBInscribirActionPerformed(evt);
            }
        });

        JBAnular.setText("Anular inscripcion");
        JBAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAnularActionPerformed(evt);
            }
        });

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JBInscribir)
                        .addGap(18, 18, 18)
                        .addComponent(JBAnular)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JRBInscriptas)
                        .addGap(49, 49, 49)
                        .addComponent(JRBNOInscriptas)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcbBuscarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbBuscarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JRBNOInscriptas)
                    .addComponent(JRBInscriptas))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(JBAnular)
                    .addComponent(JBInscribir))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jcbBuscarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBuscarAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbBuscarAlumnoActionPerformed

    private void JBInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBInscribirActionPerformed
        // TODO add your handling code here:                                                BOTÓN INSCRIPCIÓN
        InscripcionData inscripcionData = new InscripcionData();
        int filaSeleccionada = jtTablaInscripciones.getSelectedRow();
        Alumno alumno = new Alumno();
        alumno = (Alumno) jcbBuscarAlumno.getSelectedItem();
        Inscripcion inscripcion = new Inscripcion();
        Materia materia = new Materia();

        //inscripcionData.guardarInscripcion(insc);
        if (filaSeleccionada >= 0) {
            materia.setIdMateria((int) jtTablaInscripciones.getValueAt(filaSeleccionada, 0));
            materia.setNombre((String) jtTablaInscripciones.getValueAt(filaSeleccionada, 1));
            materia.setAnio((int) jtTablaInscripciones.getValueAt(filaSeleccionada, 2));
        }
        inscripcion.setNota(0);
        inscripcion.setAlumno(alumno);
        inscripcion.setMateria(materia);
        inscripcionData.guardarInscripcion(inscripcion);
        modelo.removeRow(jtTablaInscripciones.getSelectedRow());
        

    }//GEN-LAST:event_JBInscribirActionPerformed
//
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ComboBoxAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ComboBoxAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ComboBoxAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ComboBoxAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VentanaInscripciones().setVisible(true);
//            }
//        });
// }
    private void JRBNOInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBNOInscriptasActionPerformed
        // TODO add your handling code here:
        //seleccionBoton();
        if (JRBNOInscriptas.isSelected()) {
            JRBInscriptas.setSelected(false);
            modelo.setRowCount(0);
            InscripcionData inscripcionData = new InscripcionData();
            modelo.setRowCount(0);
            List<Materia> materiaList = new ArrayList<>();
            Alumno alumnoSeleccionado = (Alumno) jcbBuscarAlumno.getSelectedItem();
            materiaList = inscripcionData.obtenerMateriasNoCursadas(alumnoSeleccionado.getIdAlumno());
            for (Materia materia : materiaList) {
                cargarMateria(materia);
            }
        } else {
            modelo.setRowCount(0);
            

    }//GEN-LAST:event_JRBNOInscriptasActionPerformed
    }
    private void JRBInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBInscriptasActionPerformed
        // TODO add your handling code here:
        // seleccionBoton();                                                    MATERIA INSCRIPTAS
        if (JRBInscriptas.isSelected()) { // boton materia inscripta esta seleccionado
            JRBNOInscriptas.setSelected(false);
            modelo.setRowCount(0);
            
            InscripcionData inscripcionData = new InscripcionData();
            //modelo.setRowCount(0);
            List<Materia> materiaList = new ArrayList<>();
            Alumno alumnoSeleccionado = (Alumno) jcbBuscarAlumno.getSelectedItem();
            materiaList = inscripcionData.obtenerMateriaCursada(alumnoSeleccionado.getIdAlumno());
            for (Materia materia : materiaList) {
                cargarMateria(materia);
                
            }
            
        } else {
            modelo.setRowCount(0);
        }

    }//GEN-LAST:event_JRBInscriptasActionPerformed

    private void jtTablaInscripcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTablaInscripcionesMouseClicked
        // TODO add your handling code here:                                                CLICK EN TABLA


    }//GEN-LAST:event_jtTablaInscripcionesMouseClicked

    private void JBAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAnularActionPerformed
        // TODO add your handling code here:                                    ANULAR INSCRIPCIÓN
        InscripcionData inscripcionData = new InscripcionData();
        int filaSeleccionada = jtTablaInscripciones.getSelectedRow();
        Alumno alumno = new Alumno();
        alumno = (Alumno) jcbBuscarAlumno.getSelectedItem();
        Inscripcion inscripcion = new Inscripcion();
        Materia materia = new Materia();

        //inscripcionData.guardarInscripcion(insc);
        if (filaSeleccionada >= 0) {
            materia.setIdMateria((int) jtTablaInscripciones.getValueAt(filaSeleccionada, 0));
            materia.setNombre((String) jtTablaInscripciones.getValueAt(filaSeleccionada, 1));
            materia.setAnio((int) jtTablaInscripciones.getValueAt(filaSeleccionada, 2));
        }
        inscripcionData.borrarInscripcionMateriaAlumno(materia.getIdMateria(), alumno.getIdAlumno());
        
        modelo.setRowCount(jtTablaInscripciones.getSelectedRow()); // borramos la materia de la fila seleccionada

    }//GEN-LAST:event_JBAnularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAnular;
    private javax.swing.JButton JBInscribir;
    private javax.swing.JRadioButton JRBInscriptas;
    private javax.swing.JRadioButton JRBNOInscriptas;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<Alumno> jcbBuscarAlumno;
    private javax.swing.JTable jtTablaInscripciones;
    // End of variables declaration//GEN-END:variables

    private void cargarCabecera() { //Coloca los nombres de la cabecera de la tabla
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");
        jtTablaInscripciones.setModel(modelo);
    }
    
    private void cargarCombo() { //para que este metodo sea ejecutado al inicio tenemos que ponerlo en el constructor
//
        List<Alumno> alumnoList = new ArrayList<>();
        AlumnoData alumnoData = new AlumnoData();
        alumnoList = alumnoData.listarAlumnos();
        
        for (Alumno alumno : alumnoList) {
            // jcbBuscarAlumno.addItem(alumno.getApellido().concat(", " + alumno.getNombre()));
            //jcbBuscarAlumno.addItem(alumnito.);
            jcbBuscarAlumno.addItem(alumno); //modificamos las propiedades del ComBox en CODE para que este pueda recibir informacion distinta de String

        }
    }
    
    private void cargarMateria(Materia materia) {
        modelo.addRow(new Object[]{materia.getIdMateria(), materia.getNombre(), materia.getAnio()});
        
    }
    /*
    private void seleccionBoton(){
        if (JRBInscriptas.isSelected()){
            JRBNOInscriptas.setSelected(false);
            modelo.setRowCount(0);
        }else if(JRBNOInscriptas.isSelected()){
            JRBInscriptas.setSelected(false);
            modelo.setRowCount(0);
        }
    }*/
}
