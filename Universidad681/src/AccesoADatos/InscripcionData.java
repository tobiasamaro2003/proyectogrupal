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

            List<Inscripcion> ListaInscripciones = new ArrayList<>();
            ListaInscripciones = obtenerInscripciones();
            int bandera = 0;//INVESTIGAR
            for (Inscripcion inscripcion : ListaInscripciones) {
                if (insc.getAlumno().getIdAlumno() == inscripcion.getAlumno().getIdAlumno() && insc.getMateria().getIdMateria() == inscripcion.getMateria().getIdMateria()) {
                    bandera = 1;
                }

            }
            if (bandera == 0) {//solo se va a actualizar si la bandera es igual a 0. PARA QUE NO SE REPITA LA INSCRIPCION DE UN ALUMNO EN UNA MISMA MATERIA
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    insc.setIdInscripcion(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Se cargó exitosamente la inscripcion");
                } else {
                    JOptionPane.showMessageDialog(null, "error al cargar el alumno");
                }
            }else{
                JOptionPane.showMessageDialog(null,"No se puede inscribir 2 veces en una misma materia");
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

    public List<Materia> obtenerMateriasNoCursadas(int id) {

        List<Materia> MateriaList = new ArrayList<>();
        String sql = "SELECT * FROM materia WHERE estado=1 AND idMateria not in (SELECT idMateria FROM inscripcion WHERE idAlumno=?)";//nos devuelve las materias n las que el alumno no está inscrpto

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

    public void borrarInscripcionMateriaAlumno(int idMateria, int idAlumno) {
        String sql = "DELETE FROM inscripcion WHERE idMateria =? AND idAlumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ps.setInt(2, idAlumno);
            int modificado = ps.executeUpdate();

            if (modificado > 0) {
                JOptionPane.showMessageDialog(null, "Se ha borrado la inscripcion");
            } else {
                JOptionPane.showMessageDialog(null, "No hay materias para eliminar");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro al ingresar a la tabla" + ex.getMessage());

            //Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void actualizarNota(int idAlumno, int idMateria, int nota) {
        String sql = "UPDATE inscripcion SET nota=? WHERE idAlumno=? AND idMateria=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int actualizado = ps.executeUpdate();

            if (actualizado > 0) {//si es 0 es porque está vacío o NULL. Si es mayor a 0 es porque está lleno/true(si fuese boolean)
                JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente la nota");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido actualizar la nota");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido ingresr a la tabla");
            //Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
