
package AccesoADatos;

import java.sql.Connection;


public class MateriaData {
    private Connection con = null;
    
    public MateriaData (){
        con = Conexion.getConexion();
    }
}
