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

    public static final String SQL_CONSULTA = "SELECT id, nombre, fechaNacimiento, raza, color, propietario_numerodocumento FROM mascotas";

    public static final String SQL_INSERTAR = "INSERT INTO mascotas VALUES (?,?,?,?,?,?)";

    public static final String SQL_ACTUALIZAR = "UPDATE mascotas SET nombre = ?, fechaNacimiento = ?, raza = ?, color = ?, propietario_numerodocumento = ? WHERE id = ?";

    public static final String SQL_ELIMINAR = "DELETE FROM mascotas WHERE id = ?";

    public static final String SQL_CONSULTAR_BY_ID = "SELECT nombre, fechanacimiento, raza, color, propietario_numerodocumento FROM mascotas WHERE id = ?";

    @Override
    public List<cliente> consultar() {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        cliente mascota = null;
        List<cliente> mascotas = new ArrayList<>();
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_CONSULTA);
            res = stmt.executeQuery();
            while (res.next()) {
                String id = res.getString("id");
                String nombre = res.getString("nombre");
                String fechaNacimiento = res.getString("fechanacimiento");
                String raza = res.getString("raza");
                String color = res.getString("color");
                String documentoPropietario = res.getString("propietario_numerodocumento");
                mascota = new cliente(id, nombre, fechaNacimiento, raza, color, documentoPropietario);
                mascotas.add(mascota);
            }
        } catch (SQLException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ConexionBD.close(res);
                ConexionBD.close(stmt);
                ConexionBD.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(PropietarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            stmt.setString(3, mascota.getFechaNacimiento());
            stmt.setString(4, mascota.getRaza());
            stmt.setString(5, mascota.getColor());
            stmt.setString(6, mascota.getDocumentoPropietario());
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
    public int actualizar(cliente mascota) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_ACTUALIZAR);
            stmt.setString(1, mascota.getNombre());
            stmt.setString(2, mascota.getFechaNacimiento());
            stmt.setString(3, mascota.getRaza());
            stmt.setString(4, mascota.getColor());
            stmt.setString(5, mascota.getDocumentoPropietario());
            stmt.setString(6, mascota.getId());
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
    public int eliminar(cliente mascota) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_ELIMINAR);
            stmt.setString(1, mascota.getId());
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
            String fechaNacimiento = res.getString("fechanacimiento");
            String raza = res.getString("raza");
            String color = res.getString("color");
            String documentoPropietario = res.getString("propietario_numerodocumento");
            m.setNombre(nombre);
            m.setFechaNacimiento(fechaNacimiento);
            m.setRaza(raza);
            m.setColor(color);
            m.setDocumentoPropietario(documentoPropietario);
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
