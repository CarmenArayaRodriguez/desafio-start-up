package cl.praxis.models.dao;

import cl.praxis.models.Usuario;

public interface UsuarioDAO {
    Usuario findByCorreo(String correo);
    void save(Usuario usuario);
}
