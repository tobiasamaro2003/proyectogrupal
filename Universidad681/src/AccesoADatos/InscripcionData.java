package AccesoADatos;

import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class InscripcionData {

    private Connection con = null;
    private MateriaData materiaData = new MateriaData();
    private AlumnoData alumnoData = new AlumnoData();

    public InscripcionData() {
        con = Conexion.getConexion();

    }

    public void guardarInscripcion(Inscripcion insc) {
        String sql = "INSERT INTO inscripcion (idAlumno,idMateria,nota) VALUES (?,?,?)";
        try {
            //  insc.getAlumno().getIdAlumno();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, insc.getAlumno().getIdAlumno());
            ps.setInt(2, insc.getMateria().getIdMateria());
            ps.setInt(3, insc.getNota());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se cargó exitosamente la inscripcion");
            } else {
                JOptionPane.showMessageDialog(null, "error al cargar el alumno");
            }

            ps.close();
        } catch (SQLException ex) {
            //Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "no se pudo ingresar a la tabla inscripción" + ex.getMessage());
        }

    }

    public List<Inscripcion> obtenerInscripciones() {
        List<Inscripcion> inscripcionList = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripto"));
                insc.setNota(rs.getInt("nota"));
                Alumno alumne = alumnoData.buscarAlumno(rs.getInt("idAlumno"));
                Materia materia = materiaData.buscarMateria(rs.getInt("idMateria"));
                insc.setAlumno(alumne);
                insc.setMateria(materia);
                insc.setNota(rs.getInt("nota"));
                inscripcionList.add(insc);

            }
            ps.close();

        } catch (SQLException ex) {
            //Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "no es posible ingresar a la tabla inscripcion" + ex);
        }

        return inscripcionList;

    }

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id) {
        List<Inscripcion> inscripcionList = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion where idAlumno=? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripto"));
                insc.setNota(rs.getInt("nota"));
                Alumno alumne = alumnoData.buscarAlumno(rs.getInt("idAlumno"));
                Materia materia = materiaData.buscarMateria(rs.getInt("idMateria"));
                insc.setAlumno(alumne);
                insc.setMateria(materia);
                insc.setNota(rs.getInt("nota"));
                inscripcionList.add(insc);

            }
            ps.close();
        } catch (SQLException ex) {
            //Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "no es posible ingresar a la tabla inscripcion" + ex);
        }
        return inscripcionList;
    }

    public List<Materia> obtenerMateriaCursada(int id) {
        List<Materia> MateriaList = new ArrayList<>();
        String sql = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion, materia WHERE inscripcion.idMateria=materia.idMateria AND inscripcion.idAlumno =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("año"));
                MateriaList.add(materia);

            }
            ps.close();
        } catch (SQLException ex) {
            //Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "no es posible ingresar a las tablas materia, inscripcion, alumno " + ex);
        }

        return MateriaList;

    }

}
