package org.example;

import org.example.controller.UsuariosController;
import org.example.model.Usuarios;
import org.example.repository.UsuariosRepository;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Usuarios> listaUsuarios = obtenerTodosLosUsuarios(); // Lógica para obtener la lista de usuarios
        request.setAttribute("usuarios", listaUsuarios);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private List<Usuarios> obtenerTodosLosUsuarios() {
        UsuariosRepository usuariosRepository = new UsuariosRepository();
        UsuariosController usrController = new UsuariosController(usuariosRepository);

        List<Usuarios> listaUsuarios = usrController.findAllUsers();
        return listaUsuarios;
    }
}