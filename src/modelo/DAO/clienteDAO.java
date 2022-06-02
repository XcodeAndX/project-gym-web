package modelo.DAO;

import modelo.dto.cliente;
import modelo.services.clienteService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class clienteDAO implements clienteService {

    public static final String SQL_CONSULTA = "SELECT id, nombre, apellidoo, email, edad, peso, estatura FROM clientes";

    public static final String SQL_INSERTAR = "INSERT INTO clientes VALUES (?,?,?,?,?,?,?)";

    public static final String SQL_ACTUALIZAR = "UPDATE clientes SET nombre = ?, apellido = ?, email = ?, edad = ?, peso = ?, estatura = ? WHERE id = ?";

    public static final String SQL_ELIMINAR = "DELETE FROM clientes WHERE id = ?";

    public static final String SQL_CONSULTAR_BY_ID = "SELECT nombre, apellido, email, edad, peso, estatura FROM clientes WHERE id = ?";

    @Override
    public List<cliente> consultar() {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        cliente cliente = null;
        List<cliente> mascotas = new ArrayList<>();
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_CONSULTA);
            res = stmt.executeQuery();
            while (res.next()) {
                String id = res.getString("id");
                String nombre = res.getString("nombre");
                String apellido = res.getString("apellido");
                String email = res.getString("email");
                String edad = res.getString("edad");
                String peso = res.getString("peso");
                String estatura = res.getString("estatura");
                cliente  = new cliente(nombre, apellido, email, edad, peso, estatura);
                mascotas.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ConexionBD.close(res);
                ConexionBD.close(stmt);
                ConexionBD.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return mascotas;
    }

    @Override
    public int crear(cliente mascota) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_INSERTAR);
            stmt.setString(1, mascota.getId());
            stmt.setString(2, mascota.getNombre());
            stmt.setString(3, mascota.getApellido());
            stmt.setString(4, mascota.getEmail());
            stmt.setString(5, mascota.getEdad());
            stmt.setDouble(6,mascota.getPeso());
            stmt.setDouble(7, mascota.getEstatura());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                ConexionBD.close(stmt);
                ConexionBD.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    @Override
    public int actualizar(cliente user) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_ACTUALIZAR);
            stmt.setString(1, user.getId());
            stmt.setString(2, user.getNombre());
            stmt.setString(3, user.getApellido());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getEdad());
            stmt.setDouble(6, user.getPeso());
            stmt.setDouble(7, user.getEstatura());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                ConexionBD.close(stmt);
                ConexionBD.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    @Override
    public int eliminar(cliente user) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_ELIMINAR);
            stmt.setString(1, user.getId());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                ConexionBD.close(stmt);
                ConexionBD.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public cliente encontrar(cliente m) {
        Connection con = null;
        PreparedStatement sen = null;
        ResultSet res = null;
        try {
            con = ConexionBD.getConnection();
            sen = con.prepareStatement(SQL_CONSULTAR_BY_ID, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            sen.setString(1, m.getId());
            res = sen.executeQuery();
            res.absolute(1);//primer registro devuelto
            String nombre = res.getString("nombre");
            String apellido = res.getString("apellido");
            String email = res.getString("email");
            String edad = res.getString("edad");
            
            m.setNombre(nombre);
            m.setApellido(apellido);
            m.setEmail(email);
            m.setEdad(edad);

        }
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            try {
                ConexionBD.close(res);
                ConexionBD.close(sen);
                ConexionBD.close(con);
            }
            catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return m;
    }
}
