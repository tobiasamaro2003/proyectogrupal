/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoADatos.AlumnoData;
import AccesoADatos.InscripcionData;
import AccesoADatos.MateriaData;
import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zona
 */
public class ManipulacionDeNotas extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel();//Importación del DefaultTableModel

    public boolean isCellEditable(int row, int column) {
        return column == 2;
    }

    public ManipulacionDeNotas() {
        initComponents();
        cargarCabecera();
        cargarCombo();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLCargaNotas = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JCBSeleccionAlumno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTAlumno = new javax.swing.JTable();
        JBGuardar = new javax.swing.JButton();
        JBSalir = new javax.swing.JButton();

        JLCargaNotas.setText("Carga de Notas");

        jLabel2.setText("Seleccione un alumno: ");

        JCBSeleccionAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBSeleccionAlumnoActionPerformed(evt);
            }
        });

        JTAlumno.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(JTAlumno);

        JBGuardar.setText("Guardar");
        JBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBGuardarActionPerformed(evt);
            }
        });

        JBSalir.setText("Salir");
        JBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JCBSeleccionAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(JLCargaNotas))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBGuardar)
                .addGap(40, 40, 40)
                .addComponent(JBSalir)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLCargaNotas)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JCBSeleccionAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBGuardar)
                    .addComponent(JBSalir))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JCBSeleccionAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBSeleccionAlumnoActionPerformed
        // TODO add your handling code here:                                            COMBO BOX
        modelo.setRowCount(0);
        Inscripcion inscripcion = new Inscripcion();
        InscripcionData inscripcionData = new InscripcionData();
        Alumno alumno = new Alumno();
        List<Inscripcion> listaInscripcion = new ArrayList<>();
        alumno = (Alumno) JCBSeleccionAlumno.getSelectedItem();
        listaInscripcion = inscripcionData.obtenerInscripcionesPorAlumno(alumno.getIdAlumno());
        for (Inscripcion lista : listaInscripcion) {
            cargarMateria(lista);
        }


    }//GEN-LAST:event_JCBSeleccionAlumnoActionPerformed

    private void JBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGuardarActionPerformed
        //BOTÓN GUARDAR                                  
        try {
            InscripcionData inscripcionData = new InscripcionData();
            Inscripcion inscripcion = new Inscripcion();
            int filaSeleccionada = JTAlumno.getSelectedRow();//guardando el numero seleccionado de la tabla
            Alumno alumno = (Alumno) JCBSeleccionAlumno.getSelectedItem();

            List<Materia> materiaList = new ArrayList<>();
            MateriaData materiaData = new MateriaData();
            materiaList = materiaData.listarMaterias();//materias listadas base
////            for (Materia materias : materiaList) {
////                if(inscripcion.getMateria().getNombre()== materias.getNombre()){
////                    
////                }
////            }

            int idMateria = 0;
            int nota = 0;
            if (filaSeleccionada >= 0) {
                idMateria = (int) (JTAlumno.getValueAt(filaSeleccionada, 0));
                nota = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nota que desea cambiar"));

                //nota = Integer.parseInt((String) JTAlumno.getValueAt(filaSeleccionada, 2));
                System.out.println(alumno.getIdAlumno());
                System.out.println(idMateria);
                System.out.println(nota);

                inscripcionData.actualizarNota(alumno.getIdAlumno(), idMateria, nota);
                JTAlumno.getSelectedRow();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al actualizar la nota: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBGuardarActionPerformed

    private void JBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSalirActionPerformed
        // TODO add your handling code here:
        dispose();

    }//GEN-LAST:event_JBSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBGuardar;
    private javax.swing.JButton JBSalir;
    private javax.swing.JComboBox<Alumno> JCBSeleccionAlumno;
    private javax.swing.JLabel JLCargaNotas;
    private javax.swing.JTable JTAlumno;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
private void cargarCabecera() { //Coloca los nombres de la cabecera de la tabla
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Nota");
        JTAlumno.setModel(modelo);
    }

    private void cargarCombo() { //para que este metodo sea ejecutado al inicio tenemos que ponerlo en el constructor
//Alumno alumno = new Alumno();
        List<Alumno> alumnoList = new ArrayList<>();
        AlumnoData alumnoData = new AlumnoData();
        alumnoList = alumnoData.listarAlumnos();

        for (Alumno alumno : alumnoList) {
            JCBSeleccionAlumno.addItem(alumno);

        }
    }

    private void cargarMateria(Inscripcion inscripcion) {
        modelo.addRow(new Object[]{inscripcion.getIdInscripcion(), inscripcion.getMateria().getNombre(), inscripcion.getNota()});

    }

}
