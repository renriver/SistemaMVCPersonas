package Datos;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *implementar metodos y cargar los driver de JDBC para establecer la conexion
 * a nuestra BD universidad
 * url
 *   direccion /ip:puerto/bd
 *   usuario bd
 *   contraseña bd
 * @author rivera
 */
public class Conexion {
  Connection conex;
  Statement stmt = null;
  public boolean b;
  

    public  Conexion() { 
        try {
// Creando un objeto para el driver JDBC
            Class.forName("org.postgresql.Driver");
// Efectuando la conexion: donde estÃ¡ la BD NombreBD Usuario Password
            conex = DriverManager.getConnection("jdbc:postgresql://localhost/escuela",
                    "postgres","root");
            System.out.println("Conectando a la BDD...");
            stmt = conex.createStatement();
            b = true;
        } catch (ClassNotFoundException | SQLException e ){
            System.out.println("Error al Conectarse  :-(" + e.getMessage() );
            b = false;
        }finally{
            System.out.println("BDD Conectada  ;-)");
        }
    }

    public Statement getConexion(){
        return stmt;
    }
    public static void main(String a[])  {
        new Conexion();
    }
}
