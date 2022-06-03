package modelo.DAO;

import modelo.dto.cliente;

import modelo.dto.entrenador;
import modelo.services.entrenadorService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class entrenadorDAO implements entrenadorService {
    public static final String SQL_CONSULTA = "SELECT id, nombre, apellido, email, password FROM entrenador";

    public static final String SQL_INSERTAR = "INSERT INTO entrenador VALUES (?,?,?,?,?)";

    public static final String SQL_ACTUALIZAR = "UPDATE entrenador SET nombre = ?, apellido = ?, email = ?, password = ?WHERE id = ?";

    public static final String SQL_ELIMINAR = "DELETE FROM entrenador WHERE id = ?";

    public static final String SQL_CONSULTAR_BY_ID = "SELECT nombre, apellido, email FROM entrenador WHERE id = ?";

    @Override
    public List<entrenador> consultar() {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        entrenador userEntrenador = null;
        List<entrenador> usuarioEntrenador = new ArrayList<>();
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_CONSULTA);
            res = stmt.executeQuery();
            while (res.next()) {
                String id = res.getString("id");
                String nombre = res.getString("nombre");
                String apellido = res.getString("apellido");
                String email = res.getString("email");
                String password = res.getString("password");

                entrenador ent = new entrenador(nombre, apellido, email, password);
                usuarioEntrenador.add(ent);
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
        return usuarioEntrenador;
    }



    @Override
    public int crear(entrenador entrenador) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_INSERTAR);
            stmt.setInt(1, entrenador.getId());
            stmt.setString(2, entrenador.getNombre());
            stmt.setString(3, entrenador.getApellido());
            stmt.setString(4, entrenador.getEmail());
            stmt.setString(5, entrenador.getPassword());


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
    public int actualizar(entrenador userEntrenador) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_ACTUALIZAR);
            stmt.setInt(1, userEntrenador.getId());
            stmt.setString(2, userEntrenador.getNombre());
            stmt.setString(3, userEntrenador.getApellido());
            stmt.setString(4, userEntrenador.getEmail());
            stmt.setString(5, userEntrenador.getPassword());

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
    public int eliminar(entrenador user) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_ELIMINAR);
            stmt.setInt(1, user.getId());
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

    public entrenador encontrar(entrenador m) {
        Connection con = null;
        PreparedStatement sen = null;
        ResultSet res = null;
        try {
            con = ConexionBD.getConnection();
            sen = con.prepareStatement(SQL_CONSULTAR_BY_ID, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            sen.setInt(1, m.getId());
            res = sen.executeQuery();
            res.absolute(1);//primer registro devuelto
            String nombre = res.getString("nombre");
            String apellido = res.getString("apellido");
            String email = res.getString("email");


            m.setNombre(nombre);
            m.setApellido(apellido);
            m.setEmail(email);


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
