package com.agendaonline.sistema_agenda.controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.agendaonline.sistema_agenda.model.entidades.Usuario;
import com.agendaonline.sistema_agenda.model.repositorios.Repositorio;
import com.agendaonline.sistema_agenda.model.repositorios.RepositorioUsuario;

import jakarta.websocket.server.PathParam;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String HomeLogin() {

        return "index";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}

