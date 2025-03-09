package com.agendaonline.sistema_agenda.model.repositorios;

import java.sql.SQLException;
import java.util.List;

import com.agendaonline.sistema_agenda.model.entidades.Contato;
import com.agendaonline.sistema_agenda.model.entidades.Usuario;

public interface Repositorio <CLAZZ,KEY> {
	public void inserir(String nome, String email, String logradouro, int numero, String bairro, String cidade, String estado, String cep, int usuarioId, String telefone1, String telefone2 ) throws SQLException;
	public void alterar(CLAZZ z) throws SQLException;
	public void delete(KEY k) throws SQLException;
	public Usuario ler(String email, String senha) throws SQLException;
	public void inserir(String nome, String email, String senha) throws SQLException;
	public void alterar(String nome, String email, String senha) throws SQLException;
	List<Contato> ler(int usuarioId) throws SQLException;
	void inserir(String nome, String email, String logradouro, int numero, String bairro, String cidade, String estado,
			String cep, int usuarioId) throws SQLException;
	public void excluir(String email) throws SQLException;
}
