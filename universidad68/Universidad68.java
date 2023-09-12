
package universidad68;

import java.sql.Connection;
import java.time.LocalDate;
import universidad68.AccesoADatos.AlumnoData;
import universidad68.AccesoADatos.Conexion;
import universidad68.Entidades.Alumno;

public class Universidad68 {

    public static void main(String[] args) {
       Connection con = Conexion.getConexion();
       Alumno alumno1 = new Alumno(22309874, "Fara", "Guillermina", LocalDate.of(1994,07,23), true);
       AlumnoData alu=new AlumnoData();
       alu.guardarAlumno(alumno1);
    }
    
}
