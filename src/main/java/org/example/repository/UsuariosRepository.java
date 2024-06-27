package org.example.repository;
import org.example.model.Usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuariosRepository {
    public UsuariosRepository() {
    }

    public List<Usuarios> findAllUsers() throws SQLException {
        List<Usuarios> usuarios = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuarios")) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                //id_usuario, nombre, apellido, email, contrasenia, fecha_nac, nacionalidad
                int id_usuario = resultSet.getInt("id_usuario");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String email = resultSet.getString("email");
                String contrasenia = resultSet.getString("contrasenia");
                String fecha_nac = resultSet.getString("fecha_nac");
                String nacionalidad = resultSet.getString("nacionalidad");

                Usuarios usuario = new Usuarios(id_usuario, nombre, apellido, email, contrasenia, fecha_nac, nacionalidad);
                usuarios.add(usuario);
            }
        }

        return usuarios;
    }

    public void crearUsuario(Usuarios usuario) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO usuarios (nombre, apellido, email, contrasenia, fecha_nac, nacionalidad) VALUES (?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getApellido());
            statement.setString(3, usuario.getEmail());
            statement.setString(4, usuario.getContrasenia());
            statement.setString(5, usuario.getFecha_nac());
            statement.setString(6, usuario.getNacionalidad());

            statement.executeUpdate();
        }
    }

    public void actualizarUsuario(Usuarios usuario) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE usuarios SET nombre = ?, apellido = ?, email = ?, contrasenia = ?, fecha_nac = ?, nacionalidad = ? WHERE id_usuario = ?")) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getApellido());
            statement.setString(3, usuario.getEmail());
            statement.setString(4, usuario.getContrasenia());
            statement.setString(5, usuario.getFecha_nac());
            statement.setString(6, usuario.getNacionalidad());

            statement.setInt(7, usuario.getId_usuario());
            statement.executeUpdate();
        }
    }{
    }

    public void borrarUsuario(int usuarioId) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM usuarios WHERE Id_usuario = ?")) {
            statement.setInt(1, usuarioId);
            statement.executeUpdate();
        }
    }
}
