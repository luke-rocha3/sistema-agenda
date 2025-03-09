package com.agendaonline.sistema_agenda.controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.agendaonline.sistema_agenda.model.entidades.Usuario;
import com.agendaonline.sistema_agenda.model.repositorios.Repositorio;
import com.agendaonline.sistema_agenda.model.repositorios.RepositorioUsuario;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String PaginaLogin() {
        return "index"; 
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("senha") String senha, Model model) throws SQLException {
        Repositorio<Usuario, Integer> rUsuario = new RepositorioUsuario();
        
        Usuario usuario = (Usuario) rUsuario.ler(email, senha);

        System.out.println("Usuario logado: " + usuario.getId());

        model.addAttribute("usuarioId", usuario.getId());


        return "home";
    }
}
