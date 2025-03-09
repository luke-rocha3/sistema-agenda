package com.agendaonline.sistema_agenda.model.repositorios;



import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agendaonline.sistema_agenda.model.entidades.Contato;
import com.agendaonline.sistema_agenda.model.entidades.Usuario;

public class RepositorioUsuario implements Repositorio<com.agendaonline.sistema_agenda.model.entidades.Usuario, Integer>{

    @Override
    public Usuario ler(String email, String senha) throws SQLException {
        String  sql = "select * from usuarios where email = '" + email + "' and senha = '" + senha + "'";

        ResultSet result = ConnectionManager.getCurrentConnection().prepareStatement(sql).executeQuery();
        
        Usuario usuario = null;
		if (result.next()) {
            usuario = new Usuario(result.getString("nome"), result.getString("email"), result.getString("senha"));  // Criando um novo usuário com os dados do ResultSet
            usuario.setId(result.getInt("id"));
        }
        
        return usuario;
    }
  

    @Override
    public void inserir(String nome, String email, String senha) throws SQLException {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Senha: " + senha);
        
        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES ('" + nome + "','" + email + "','" + senha + "')";

        int result = ConnectionManager.getCurrentConnection().prepareStatement(sql).executeUpdate();

        System.out.println("sql: " + sql);
    }

	@Override
	public void alterar(String nome, String email, String senha) throws SQLException {
        System.out.println("Nome alterado: " + nome);
        System.out.println("Email alterado: " + email);
        System.out.println("Senha alterada: " + senha);

        String sql = "UPDATE usuarios SET nome = '" + nome + "', email = '" + email + "', senha = '" + senha + "' WHERE email = '" + email + "'";
       
        
        int result = ConnectionManager.getCurrentConnection().prepareStatement(sql).executeUpdate();
        
        System.out.println("sql: " + sql);
	}

	@Override
	public void delete(Integer k) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void alterar(Usuario z) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void inserir(String nome, String email, String logradouro, int numero, String bairro, String cidade,
			String estado, String cep, int usuarioId, String telefone1, String telefone2) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Contato> ler(int usuarioId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void inserir(String nome, String email, String logradouro, int numero, String bairro, String cidade,
			String estado, String cep, int usuarioId) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(String email) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
