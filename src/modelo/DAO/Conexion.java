package modelo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/Gym-web";
    private String USER ="root";
    private String PASSWORD ="root";
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";

    public Connection getConexion(){
        Connection con = null;
        try{
            Class.forName(DRIVER);
            con = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }

}
