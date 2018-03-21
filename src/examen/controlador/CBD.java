/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.controlador;

import examen.modelo.Profesor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yulissa T
 */
public class CBD {

    private final String URL = "jdbc:derby://localhost:1527/PROFESORES";
    private final String USUARIO = "administrador";
    private final String CLAVE = "admin";
    private Connection conexion;
    private PreparedStatement seleccionarProfesores;
    private PreparedStatement seleccionarProfesoresPorApellido;
    private PreparedStatement insertarNuevoProfesor;
    private PreparedStatement modificarProfesor;

    public CBD() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            //System.out.println("Driver JAVA DB cargado !!!");
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR: No se encuentra el Driver" + ex);
            Logger.getLogger(CBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexion establecida a la base de datos");
        } catch (SQLException ex) {
            System.out.println("ERROR: No se pudo establecer conexion a la base de datos" + ex);
            Logger.getLogger(CBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Profesor> getProfesores() {
        List<Profesor> listaProfesor = new ArrayList<>();
        try {
            seleccionarProfesores = conexion.prepareStatement("Select * from PROFESOR");
            ResultSet resultado = seleccionarProfesores.executeQuery();

            while (resultado.next()) {
                int cedula = resultado.getInt("cedula");
                String nombres = resultado.getString("nombres");
                String apellidos = resultado.getString("apellidos");
                String carrera = resultado.getString("carrera");
                String tipoProfesor = resultado.getString("tipo_profesor");
                int horasClase = resultado.getInt("horas_clase");
                int horasComplementarias = resultado.getInt("horas_Complementarias");
                int horasSemanales = resultado.getInt("horas_semanales");
                listaProfesor.add(new Profesor(carrera, nombres, apellidos, horasClase, carrera, horasSemanales, horasComplementarias, tipoProfesor));
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la consulta" + ex);
            Logger.getLogger(CBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProfesor;
    }

//   
//        public int agregarProfesor( String cedula, String nombres, String apellidos, String carrera, String tipoProfesor, int horasClase,int horasSemanales, int horasComplementarias) {
//            int p =0;
//            boolean aux = true;
//        try { 
//            Statement sentencia = conexion.createStatement();
//            ResultSet registros = sentencia.executeQuery("select * FROM PROFESOR");
//            
//            
//            String insert = String.format("insert into profesor values('%s', '%s','%s','%s','%s','%d','%d')",
//                    
//                    cedula,
//                    nombres,
//                    apellidos,
//                    carrera,
//                    tipoProfesor,
//                    horasClase,
//                    horasComplementarias);
//            p = sentencia.executeUpdate(insert);
//            sentencia.close();
//            registros.close();
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(CBD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        if(aux= true)
//    }
    public int agregarProfesor(String cedula, String nombres, String apellidos, String carrera, String tipoProfesor, int horasClase, int horasSemanales, int horasComplementarias) {
        try {
            insertarNuevoProfesor = conexion.prepareStatement("insert into PROFESOR values("
                    + cedula + ", '"
                    + nombres + "', '"
                    + apellidos + "', '"
                    + carrera + "', '"
                    + tipoProfesor + "', "
                    + horasClase + ", "
                    + horasSemanales + ", "
                    + horasComplementarias + ")");
            return insertarNuevoProfesor.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }
     public List<Profesor> getPersonasPorApellidos(String apellidob) {
        List<Profesor> listaProfesor = new ArrayList<>();
        try {
            seleccionarProfesoresPorApellido = conexion.prepareStatement("Select * from PERSONA where Apellido = '"+apellidob+"'"); 
            ResultSet resultado = seleccionarProfesoresPorApellido.executeQuery();

            while (resultado.next()) {
                int cedula = resultado.getInt("cedula");
                String nombres = resultado.getString("nombres");
                String apellidos = resultado.getString("apellidos");
                String carrera = resultado.getString("carrera");
                String tipoProfesor = resultado.getString("tipo_profesor");
                int horasClase = resultado.getInt("horas_clase");
                int horasComplementarias = resultado.getInt("horas_Complementarias");
                int horasSemanales = resultado.getInt("horas_semanales");
               
                Profesor p = new Profesor(carrera, nombres, apellidos, horasClase, carrera, horasSemanales, horasComplementarias, tipoProfesor);
                System.out.println(p);
                listaProfesor.add(p);
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la consulta" + ex);
        }
        return listaProfesor;
    }

}
