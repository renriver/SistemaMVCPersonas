
package Datos;
import java.sql.*;
import java.util.Arrays;
import javax.swing.JOptionPane;
/**
 * esta clase vamos a declarar nuestro atributos de la tabla persona
 * que esta en nuestra BD
 * @author rivera
 */
public class dato_Persona {
       Conexion c=new Conexion();
     Statement st=c.getConexion();
        //almancenar nuestra consulta
    private ResultSet rs=null;
     
    private int idpersona;
    private String nombre,appat,apmat,sexo,edad;

    public dato_Persona() {
    }

    public dato_Persona(int idpersona,String edad, String nombre, String appat, String apmat, String sexo) {
        this.idpersona = idpersona;
        this.edad = edad;
        this.nombre = nombre;
        this.appat = appat;
        this.apmat = apmat;
        this.sexo = sexo;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppat() {
        return appat;
    }

    public void setAppat(String appat) {
        this.appat = appat;
    }

    public String getApmat() {
        return apmat;
    }

    public void setApmat(String apmat) {
        this.apmat = apmat;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "dato_Persona{" + "idpersona=" + idpersona + ", edad=" + edad + ", nombre=" + nombre + ", appat=" + appat + ", apmat=" + apmat + ", sexo=" + sexo + '}';
    }
    //crear mis metodos de Insertar, consultar a la BD
    //consulta a bd para conocer los valore que ya existen
    //cuantos datos  
    
    public int idMaximo(){
        int i=0;//para controlar mis registros
        try{
            
             try{
//                 c=new Conexion();
//            st=c.getConexion();
                //sql
                System.out.println("antes de sql");
                rs=st.executeQuery("select max(idempleado) from empleados;");
                 System.out.println("sasa"+rs);
                 if(rs.next())
                 {
                      i=Integer.parseInt(rs.getString(1));
                     i++;
                     //System.out.println(" "rs.getString(1));
//                      JOptionPane.showMessageDialog(null,"Ingresando datos"+rs.getString(1));
                 }
                 else {
                    i=1;
                    
                 }
             }
             catch(SQLException exsql)
             {
                 
                      }
        }//try getconexion
        catch(Exception ex)
        {
            i=1;
            System.out.println("No pude ingresar! "+ex);
        }

        return i;
    }
    //crear un metodo para insert
    //CRUD Cread, Read Update,Delete
    public void GuardarEmpleado(String nombre,String apellid_Pat,
            String apellido_Mat,String edad,String sex)
    {
        int revisar=-1;
        int bandera=0;
       System.out.println("Datos que llegan de la vista "+nombre+apellid_Pat+
           apellido_Mat+edad+sex);
    // JOptionPane.showMessageDialog(null,"Ingresando datos");
     //si hay conexion 
     try{
             if(c.b==true){
         //instruccion sql para selecionar e insertar
                try{
                   
                    rs=st.executeQuery("select * from empleados;");
                   revisar=st.executeUpdate("insert into empleados (idempleado,nombre,appat,apmat,edad,sexo) \n" 
                                             +"VALUES"+ "("+idpersona+",\'"+nombre+"\',\'"+apellid_Pat+"\',\'"
                                                     +apellido_Mat+"\',"+edad+",\'"+sex+"\');");
                       
                   if(revisar==1)
                   {
                      bandera=1; 
                   }
                   st.close();
                   rs.close();
                }catch(SQLException sqlex){
                      JOptionPane.showMessageDialog(null,"Error en los datos");
                 
                }
            }
        }
          catch(Exception ex){
          JOptionPane.showMessageDialog(null,"No hay conexion"+ ex);
     
                  
          }
     }
//    
    public static void main(String s[]) throws SQLException
    {
     dato_Persona dp=new dato_Persona();
     //dp.numero();
     dp.Consulta();
    }
    
     
  //metodo para la consulta de datos
    public String [][] Consulta() throws SQLException{
              String datos[][]=new String[0][6];
              int cons=0;
              int renglon=0;
//               Statement st = c.createStatement();
               //ResultSet rs = st.executeQuery("SELECT * FROM empleados order by idempleado;");
         rs=st.executeQuery("select * from empleados;");
               while(rs.next()){
               cons++;
               }
               if(cons!=0){
                   datos=new String[cons][6];
                   
               
               ResultSet rs = st.executeQuery("SELECT idempleado,nombre,appat,apmat,edad,sexo"
                       + " FROM empleados order by idempleado;");
               
               while (rs.next()) {
                     // cons++;
                     System.out.print("Column 1 returned ");
                        System.out.println(rs.getString(1));
                        System.out.println(rs.getString(2));
                        System.out.println(rs.getString(3));
                        System.out.println(rs.getString(4));
                        System.out.println(rs.getString(5));
                      datos[renglon][0]=rs.getString(1);
                      datos[renglon][1]=rs.getString(2);
                      datos[renglon][2]=rs.getString(3);
                      datos[renglon][3]=rs.getString(4);
                      datos[renglon][4]=rs.getString(5);
                      datos[renglon][5]=rs.getString(6);
//                  
//         System.out.println("datpss---"+  datos[renglon][1]);
                      renglon ++;    
                     //return datos;
               }
             }//if
         
           return datos;
    }
}
