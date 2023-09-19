package universidad68;

import java.sql.Connection;
import java.time.LocalDate;
import AccesoADatos.AlumnoData;
import AccesoADatos.Conexion;
import AccesoADatos.InscripcionData;
import AccesoADatos.MateriaData;
import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;

public class Universidad68 {

    public static void main(String[] args) {
        Connection con = Conexion.getConexion();
        // Alumno alumno1 = new Alumno(1, 22309873, "Fara", "Guillermina", LocalDate.of(1994, 07, 23), true);
        //Alumno alumno2 = new Alumno(3,22309875, "guerrieri", "Jesica", LocalDate.of(1982, 07, 2), true);
        // Alumno alumno3 = new Alumno(22309865, "Gutierrez", "Jonathan", LocalDate.of(1986, 05, 10), true);

        AlumnoData alu = new AlumnoData();
        //alu.guardarAlumno(alumno3);
        //alu.guardarAlumno(alumno2);
//       alu.eliminarAlumno(2);
        //probando si se guardan los cambios :D XDDD
        //System.out.println(alu.buscarAlumno(1));
        //  System.out.println(alu.buscarAlumnoPorDni(22309875));
        //System.out.println(alu.buscarAlumnoPorDni(22309873));
        //System.out.println(alu.listarAlumnos());
        Materia materia = new Materia(1, "lengua", 3, true);
        MateriaData mate = new MateriaData();

        // mate.guardarMateria(materia);
        //System.out.println(mate.buscarMateria(1));
        //mate.modificarMateria(materia); // para modificarla le tenemos que pasar la materia con datos nuevos para reemplazar
        //mate.eliminarMateria(1);
        //System.out.println(mate.listarMaterias());
        // Materia lengua = mate.buscarMateria(1);
        //Alumno joni = alu.buscarAlumno(7);
        //Inscripcion inscripcion = new Inscripcion(joni, lengua, 9);
        InscripcionData insc = new InscripcionData();

        //insc.guardarInscripcion(inscripcion);
        /*
        
        for(Inscripcion inscrip: insc.obtenerInscripciones()){
            System.out.println("id Inscripcion: "+ inscrip.getIdInscripcion());
            System.out.println("Apellido: "+ inscrip.getAlumno().getApellido());
            System.out.println("Materia: "+ inscrip.getMateria().getNombre());
            //System.out.println("Nota: "+ inscrip.getNota());
        }
         */
        /*
        
        for (Inscripcion inscri : insc.obtenerInscripcionesPorAlumno(7)) {
            System.out.println("id Inscripcion: " + inscri.getIdInscripcion());
            System.out.println("Apellido: " + inscri.getAlumno().getApellido());
            System.out.println("Materia: " + inscri.getMateria().getNombre());
        }
        */
        System.out.println(insc.obtenerMateriaCursada(7));

    }

}
