package universidad68;

import java.sql.Connection;
import java.time.LocalDate;
import AccesoADatos.AlumnoData;
import AccesoADatos.Conexion;
import AccesoADatos.MateriaData;
import Entidades.Alumno;
import Entidades.Materia;

public class Universidad68 {

    public static void main(String[] args) {
        Connection con = Conexion.getConexion();
        Alumno alumno1 = new Alumno(22309873, "Fara", "Guillermina", LocalDate.of(1994, 07, 23), true);
        Alumno alumno2 = new Alumno(22309875, "guerrieri", "Jesica", LocalDate.of(1982, 07, 2), true);
        AlumnoData alu = new AlumnoData();
//       alu.guardarAlumno(alumno1);
//       alu.guardarAlumno(alumno2);
//       alu.eliminarAlumno(2);
        //probando si se guardan los cambios :D XDDD

        //System.out.println(alu.buscarAlumno(1));
      //  System.out.println(alu.buscarAlumnoPorDni(22309875));
        //System.out.println(alu.buscarAlumnoPorDni(22309873));
        
        Materia materia = new Materia(1,"lengua",3 , true);
        MateriaData mate= new MateriaData();
        
       // mate.guardarMateria(materia);
       // System.out.println(mate.buscarMateria(1));
       mate.modificarMateria(materia); // para modificarla le tenemos que pasar la materia con datos nuevos para reemplazar
        
    }

}
