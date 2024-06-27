package org.example.service;

import org.example.model.Usuarios;
import org.example.repository.UsuariosRepository;

import java.sql.SQLException;
import java.util.List;

public class UsuariosService {
    private final UsuariosRepository usuarioRepository;

    public UsuariosService(UsuariosRepository userRepository) {
        this.usuarioRepository = userRepository;
    }

    public List<Usuarios> findAllUsers() throws SQLException {
        return usuarioRepository.findAllUsers();
    }

    public void crearUsuario(Usuarios usuario) throws SQLException {
        usuarioRepository.crearUsuario(usuario);
    }

    public void actualizarUsuario(Usuarios usuario) throws SQLException {
        usuarioRepository.actualizarUsuario(usuario);
    }

    public void borrarUsuario(int usuarioId) throws SQLException {
        usuarioRepository.borrarUsuario(usuarioId);
    }
}
