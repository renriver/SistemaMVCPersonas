
package Datos;
import java.sql.*;
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
       // System.out.println("Datos que llegan de la vista "+nombre+apellid_Pat+
//                apellido_Mat+edad+sex);
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
     dp.numero();
    }
    
      //para obtner el numero total de dato
    public int numero()
     {
         int x=0;
         Statement st = c.getConexion();
         System.out.println(""+st);
         try{
             System.out.println("Conectando a la BDD..."+st);
            
        try {
            String sql="select max(idpersona) from personas;";
            ResultSet rs = st.executeQuery(sql);
            System.out.println("dasda");
            if(rs.next())
            {
                x=Integer.parseInt(rs.getString(1));
                x=x+1;
            }
            else
            {
                x=1;
            }
            
        } catch (SQLException ex) {
           // ex.printStackTrace();
        }
        }catch(Exception e)
        {
            x=1;
          System.err.println("Imposible conectar a la base de datos"+ e);
          //e.printStackTrace();
        }
         return x;
     }
  
}
