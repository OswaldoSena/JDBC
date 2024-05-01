//importacion de librerias o paquetes

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//Nombramiento del proyecto
public class AgendaMain {
 
    //Nombramiento de Método
    public static void main(String args[]) {

        //Nombramiento de variables
        String usuario = "root";
        String password ="oswal";
        String url = "jdbc:mysql://localhost:3306/agenda_cita";
        Connection conexion;
        Statement statement;
        ResultSet rs;        

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AgendaMain.class.getName()).log(Level.SEVERE,null, ex);
        }

        try {
            //Coneccion a la base de datos
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            statement.executeUpdate("INSERT INTO persona(nombre, apellido,identificacion) VALUE('Wil', 'Rami', 123456)");
            rs = statement.executeQuery("SELECT * FROM persona");
            statement.executeUpdate("delete from persona where id_persona = 4");
           
            rs.next();
            //Ciclos de las filas 
            do{
                System.out.println(rs.getInt("id_persona")+" : "+ rs.getString("nombre")+" "+rs.getString("apellido"));
            }while(rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(AgendaMain.class.getName()).log(Level.SEVERE,null, ex);
        }

    }
}


