package universidad68;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    private static String url = "jdbc:mysql://localhost/universidad68";
    private static String usuario = "root";
    private static String password = "";
    private static Conexion conec = null;

    private Conexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error al cargar driver" + ex.getMessage());
        }

    }

    public static Connection getConexion() {
        Connection conectar = null;
        // si no hay conexiones previas..
        if (conec == null) { // ...entonces crea la unica conexion
            conec = new Conexion();
        }
        try {
            conectar = DriverManager.getConnection(url, usuario, password); //crea una conexion y la almacena en una variable de tipo Connection
        } catch (SQLException ex) {
            // Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error de conexion " + ex);
        }
        return conectar;
    }

}
