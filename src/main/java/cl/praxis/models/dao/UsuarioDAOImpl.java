package cl.praxis.models.dao;

import cl.praxis.models.Usuario;
import cl.praxis.models.conexion.BDConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAOImpl implements UsuarioDAO {
    private Connection connection;

    public UsuarioDAOImpl() {
        this.connection = BDConexion.getConnection();
    }

    @Override
    public Usuario findByCorreo(String correo) {
        String query = "SELECT * FROM usuarios WHERE correo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, correo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario(
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("password"),
                        rs.getString("nick"),
                        rs.getInt("peso")
                    );
                    usuario.setId(rs.getInt("id"));
                    return usuario;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Usuario usuario) {
        String query = "INSERT INTO usuarios (nombre, correo, password, nick, peso) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getPassword());
            stmt.setString(4, usuario.getNick());
            stmt.setInt(5, usuario.getPeso());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    usuario.setId(generatedKeys.getInt(1));
                }
            }
            System.out.println("Usuario guardado exitosamente en la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
