package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;


public class ConexionBD {

    public static final String JDBC_URL = "jdbc:mysql://52.91.148.152:3306/gym-web?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String BD_USUARIO = "Gym";
    public static final String BD_CLAVE = "Gym";

    public static DataSource getDataSource(){
        BasicDataSource bs = new BasicDataSource();
        bs.setUrl(JDBC_URL);
        bs.setUsername(BD_USUARIO);
        bs.setPassword(BD_CLAVE);
        bs.setInitialSize(5);
        return bs;
    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getDataSource().getConnection();
    }

    public static void close(Connection con) throws SQLException {
        con.close();

    }

    public static void close(ResultSet res) throws SQLException {
        res.close();
    }

    public static void close(Statement sen) throws SQLException {
        sen.close();
    }

    public static void close(PreparedStatement psen) throws SQLException {
        psen.close();
    }
}