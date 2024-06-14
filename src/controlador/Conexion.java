package controlador;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private Connection cone;

    public Conexion() {
        try {
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            String user = "ObjetosPerdidos";
            String password = "objetosperdidos";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            cone = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Error conexion: "+ e.getMessage());
        }
    }

    public Connection getCone() {
        return cone;
    }
    
    
    
    
    
}
