package AccesoADatos;

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

public class MateriaData {

    private Connection con = null;

    public MateriaData() {
        con = Conexion.getConexion();
    }

    public void guardarMateria(Materia materia) {
        String sql = "INSERT INTO materia(nombre,año,estado) VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // creamos el id 

            ps.setString(1, materia.getNombre()); //1 refiere al lugar que va a ocupar en el INSERT INTO
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado()); // le asignamos el estado is = esta o no esta

            List<Materia> listaMateria = new ArrayList<>();
            listaMateria = this.listarMaterias();
            boolean bandera = true;
            for (Materia lista : listaMateria) {
                if (materia.getNombre() == lista.getNombre() && materia.getAnio() == lista.getAnio()) {
                    bandera = false;
                }
            }
            if (bandera) {
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {

                    materia.setIdMateria(rs.getInt(1)); //asignamos el numero de la columna que vamos a usar REFIERE A LA BASE DE DATOS 
                    JOptionPane.showMessageDialog(null, "Se cargó exitosamente el materia");

                }
            }

            ps.close();
        } catch (SQLException ex) {
            //Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error al cargar la materia");
        }

    }

    public Materia buscarMateria(int id) {
        Materia mate = null;
        String sql = "SELECT nombre, año FROM materia WHERE idMateria=? AND estado =1";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                mate = new Materia();
                mate.setIdMateria(id);
                mate.setNombre(rs.getString("nombre"));
                mate.setAnio(rs.getInt("año"));
                mate.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "no existe la materia loco");
            }
            ps.close();

        } catch (SQLException ex) {
            //Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "la materia ha sido modificada ( ˘ ³˘)♥");

        }

        return mate;

    }

    public void modificarMateria(Materia materia) {
        String sql = "UPDATE materia SET nombre=?, año=? WHERE idMateria=? AND estado=1 ";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setInt(3, materia.getIdMateria());
            int succes = ps.executeUpdate();
            if (succes == 1) {
                JOptionPane.showMessageDialog(null, "la materia ha sido modificada ( ˘ ³˘)♥");
            }

        } catch (SQLException ex) {
            // Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "EEEEEerror al acceder a la tabla materia ( ˘ ³˘)♥" + ex.getMessage());
        }

    }

    public void eliminarMateria(int id) {
        String sql = "UPDATE materia SET estado=0 WHERE idMateria=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            if (ps.executeUpdate() == 1) { //Si la tabla se modificó entonces...
                JOptionPane.showMessageDialog(null, "La materia fue eliminada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "materia no encontrada");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla materia");
        }

    }

    public List<Materia> listarMaterias() {

        List<Materia> materiaList = new ArrayList<>();

        String sql = "SELECT * FROM materia WHERE estado = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(); //query se usa para traer la información de la tabla al netbeans. 

            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));//Es rs porque es la que tiene la tabla
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("año")); //lo que está entre comillas siempre es igual al nombe de la base de datos
                materia.setEstado(rs.getBoolean("estado"));
                materiaList.add(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla materia");
        }
        return materiaList;
    }

}
