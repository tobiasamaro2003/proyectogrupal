package AccesoADatos;

import Entidades.Inscripcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class InscripcionData {

    private Connection con = null;
    //private MateriaData mateData;
    //private AlumnoData alumData;

    public InscripcionData() {
        con = Conexion.getConexion();
    }

    public void guardarInscripcion(Inscripcion insc) {
        String sql = "INSERT INTO inscripcion (idAlumno,idMateria,nota) VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, insc.getAlumno().getIdAlumno());
            ps.setInt(2, insc.getMateria().getIdMateria());
            ps.setInt(3, insc.getNota());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se cargó exitosamente la inscripcion");
            }else{
                JOptionPane.showMessageDialog(null, "error al cargar el alumno");
            }

            ps.close();
        } catch (SQLException ex) {
            //Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "no se pudo ingresar a la tabla inscripción"+ ex.getMessage());
        }
        

    }

}
