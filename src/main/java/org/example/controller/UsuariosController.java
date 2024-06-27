package org.example.controller;

import org.example.model.Usuarios;
import org.example.repository.UsuariosRepository;

import java.sql.SQLException;
import java.util.List;

public class UsuariosController {
    private final UsuariosRepository usuariosRepository;

    public UsuariosController(UsuariosRepository usrService) {
        this.usuariosRepository = usrService;
    }

    public Usuarios crearUsuario(Usuarios usuario) {
        try {
            usuariosRepository.crearUsuario(usuario);
            return usuario;
        } catch (SQLException e) {
            // Manejar excepción adecuadamente
            e.printStackTrace();
            return null;
        }
    }

    public List<Usuarios> findAllUsers() {
        try {
            return usuariosRepository.findAllUsers();
        } catch (SQLException e) {
            // Manejar excepción adecuadamente
            System.out.println("e = " + e);
            e.printStackTrace();
            return null;
        }
    }

    public Usuarios actualizarUsuario(int id, Usuarios usuario) {
        try {
            usuario.setId_usuario(id);

            usuariosRepository.actualizarUsuario(usuario);
            return usuario;
        } catch (SQLException e) {
            // Manejar excepción adecuadamente
            e.printStackTrace();
            return null;
        }
    }

    public void borrarUsuario(int id) {
        try {
            usuariosRepository.borrarUsuario(id);
        } catch (SQLException e) {
            // Manejar excepción adecuadamente
            e.printStackTrace();
        }
    }
}
