package org.example;

import org.example.controller.UsuariosController;
import org.example.model.Usuarios;
import org.example.repository.UsuariosRepository;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        UsuariosRepository usuariosRepository = new UsuariosRepository();
        UsuariosController usrController = new UsuariosController(usuariosRepository);

        List<Usuarios> listaUsuarios = usrController.findAllUsers();
        for (Usuarios usuario : listaUsuarios) {
            System.out.println(usuario.getNombre());
        }
    }
}
