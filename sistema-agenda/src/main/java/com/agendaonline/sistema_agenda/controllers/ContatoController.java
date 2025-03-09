package com.agendaonline.sistema_agenda.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.agendaonline.sistema_agenda.model.entidades.Contato;
import com.agendaonline.sistema_agenda.model.repositorios.Repositorio;
import com.agendaonline.sistema_agenda.model.repositorios.RepositorioContato;

import jakarta.websocket.server.PathParam;

@Controller
public class ContatoController {

    @GetMapping("/Contato")
    public String HomeLogin(@RequestParam("usuarioId") Integer usuarioId, Model model) {
        System.out.println("ID do usuário: " + usuarioId);
        model.addAttribute("usuarioId", usuarioId);
        return "CadastroContato";
    }

    @GetMapping("/exibirContatos")
    public String exibirContato(@RequestParam("usuarioId") Integer usuarioId, Model model) throws SQLException {
        Repositorio<Contato, Integer> rContato = new RepositorioContato();
        List<Contato> listaContato = rContato.ler(usuarioId);
        model.addAttribute("listaContato", listaContato);
        model.addAttribute("usuarioId", usuarioId);
        return "ExibirContatos";
    }

    @PostMapping("/cadastrarContato")
    public String cadastrarContato(
            @RequestParam("nome") String nome,
            @RequestParam("email") String email,
            @RequestParam("logradouro") String logradouro,
            @RequestParam("numero") int numero,
            @RequestParam("bairro") String bairro,
            @RequestParam("cidade") String cidade,
            @RequestParam("estado") String estado,
            @RequestParam("usuarioId") Integer usuarioId,
            @RequestParam("telefone1") String telefone1,
            @RequestParam("telefone2") String telefone2,
            @RequestParam("cep") String cep, Model model) throws SQLException {

        Repositorio<Contato, Integer> rContato = new RepositorioContato();

        rContato.inserir(nome, email, logradouro, numero, bairro, cidade, estado, cep, usuarioId, telefone1, telefone2);
        List<Contato> listaContato = rContato.ler(usuarioId);
        model.addAttribute("listaContato", listaContato);
        return "ExibirContatos";

      }
    @PostMapping("/excluirContato")
    public String excluirContato(@RequestParam("email") String email, Model model,@RequestParam("usuarioId") int usuarioId ) throws SQLException {
        Repositorio<Contato, Integer> rContato = new RepositorioContato();
        System.out.println("UsuarioID: "+ usuarioId);

        rContato.excluir(email);
        List<Contato> listaContato = (List<Contato>) rContato.ler(usuarioId);
        model.addAttribute("listaContato", listaContato);
        return "ExibirContatos";
    }

}




