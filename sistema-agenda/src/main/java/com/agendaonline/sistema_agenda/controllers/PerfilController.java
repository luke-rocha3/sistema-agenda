package com.agendaonline.sistema_agenda.controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.agendaonline.sistema_agenda.model.entidades.Usuario;
import com.agendaonline.sistema_agenda.model.repositorios.Repositorio;
import com.agendaonline.sistema_agenda.model.repositorios.RepositorioUsuario;

@Controller
public class PerfilController {
    @GetMapping("/editar-perfil") 
    public String editarPerfil() {

        return "perfilUsuario";
    }

    @PostMapping("/perfil") 
    public String salvarPerfil(
            @RequestParam("nome") String nome,
            @RequestParam("email") String email,
            @RequestParam("senha") String senha) throws SQLException {

        Repositorio<Usuario, Integer> rUsuario = new RepositorioUsuario();
        rUsuario.alterar(nome, email, senha);

        return "index";
    }
}