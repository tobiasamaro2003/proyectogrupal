
package universidad68;

import java.sql.Connection;
import java.time.LocalDate;
import AccesoADatos.AlumnoData;
import AccesoADatos.Conexion;
import Entidades.Alumno;

public class Universidad68 {

    public static void main(String[] args) {
       Connection con = Conexion.getConexion();
       Alumno alumno1 = new Alumno(22309873, "Fara", "Guillermina", LocalDate.of(1994,07,23), true);
       Alumno alumno2 = new Alumno(22309875, "guerrieri", "Jesica", LocalDate.of(1982,07,2), true);
       AlumnoData alu=new AlumnoData();
       alu.guardarAlumno(alumno1);
       alu.guardarAlumno(alumno2);
       alu.eliminarAlumno(8);
    }
    
}
