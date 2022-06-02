package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.DTO.Cliente;

public class CLienteDao {

    private static final String INSERT = "INSERT INTO cliente(nombre, apellido, email, edad, peso, estatura, imc) VALUES(?,?,?,?,?,?,?)";
    private static final String SELECT = "SELECT * FROM cliente";
    private static final String UPDATE = "UPDATE cliente SET nombre=?, apellido=?, email=?, edad=?, peso=?, estatura=?, imc=? WHERE id=?";
    private static final String DELETE = "DELETE FROM cliente WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM cliente WHERE id=?";
    private static final String FIND_BY_EMAIL = "SELECT * FROM cliente WHERE email=?";

    public boolean add(Cliente cliente) {
        boolean registro = false;
        Conexion conexion = new Conexion();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = conexion.getConexion();
            stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setInt(4, cliente.getEdad());
            stmt.setDouble(5, cliente.getPeso());
            stmt.setDouble(6, cliente.getEstatura());
            stmt.setDouble(7, cliente.getImc());

            registro = stmt.execute();

            if(conn != null){
                conn.close();
            }
            if(stmt != null){
                stmt.close();
            }

        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            return registro;
        }
    }

    public List<Cliente> get() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        Conexion conexion = new Conexion();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = conexion.getConexion();
            stmt = conn.prepareStatement(SELECT);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setEmail(rs.getString("email"));
                cliente.setEdad(rs.getInt("edad"));
                cliente.setEstatura(rs.getDouble("estatura"));
                cliente.setPeso(rs.getDouble("peso"));
                cliente.setImc(rs.getDouble("imc"));

                clientes.add(cliente);
            }

            if(conn != null){
                conn.close();
            }
            if(stmt != null){
                stmt.close();
            }

        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            return clientes;
        }

    }

    public Cliente getById(int id) {
        Cliente cliente = new Cliente();
        Conexion conexion = new Conexion();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = conexion.getConexion();
            stmt = conn.prepareStatement(FIND_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setEmail(rs.getString("email"));
                cliente.setEdad(rs.getInt("edad"));
                cliente.setEstatura(rs.getDouble("estatura"));
                cliente.setPeso(rs.getDouble("peso"));
                cliente.setImc(rs.getDouble("imc"));
            }else{
                cliente = null;
            }

            if(conn != null){
                conn.close();
            }
            if(stmt != null){
                stmt.close();
            }

        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            return cliente;
        }

    }

    public Cliente getByEmail(String email) {
        Cliente cliente = new Cliente();
        Conexion conexion = new Conexion();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = conexion.getConexion();
            stmt = conn.prepareStatement(FIND_BY_EMAIL);
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setEmail(rs.getString("email"));
                cliente.setEdad(rs.getInt("edad"));
                cliente.setEstatura(rs.getDouble("estatura"));
                cliente.setPeso(rs.getDouble("peso"));
                cliente.setImc(rs.getDouble("imc"));
            }else{
                cliente = null;
            }

            if(conn != null){
                conn.close();
            }
            if(stmt != null){
                stmt.close();
            }

        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            return cliente;
        }

    }

    public boolean update(Cliente cliente) {
        boolean update = false;
        Conexion conexion = new Conexion();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = conexion.getConexion();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setInt(4, cliente.getEdad());
            stmt.setDouble(5, cliente.getPeso());
            stmt.setDouble(6, cliente.getEstatura());
            stmt.setDouble(7, cliente.getImc());
            stmt.setInt(8, cliente.getId());

            update = stmt.execute();

            if(conn != null){
                conn.close();
            }
            if(stmt != null){
                stmt.close();
            }

        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            return update;
        }
    }

    public boolean delete(int id){
        boolean delete = false;
        Conexion conexion = new Conexion();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = conexion.getConexion();
            stmt = conn.prepareStatement(DELETE);
            stmt.setInt(1, id);

            delete = stmt.execute();

            if(conn != null){
                conn.close();
            }
            if(stmt != null){
                stmt.close();
            }

        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            return delete;
        }
    }
}
