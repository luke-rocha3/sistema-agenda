package com.agendaonline.sistema_agenda.model.repositorios;



import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agendaonline.sistema_agenda.model.entidades.Contato;
import com.agendaonline.sistema_agenda.model.entidades.Usuario;

public class RepositorioContato implements Repositorio<com.agendaonline.sistema_agenda.model.entidades.Contato, Integer>{
    @Override
    public void inserir(String nome, String email, String logradouro, int numero, String bairro, String cidade, String estado, String cep, int usuarioId, String telefone1, String telefone2) throws SQLException {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Logradouro: " + logradouro);
        System.out.println("Número: " + numero);
        System.out.println("Bairro: " + bairro);
        System.out.println("Cidade: " + cidade);
        System.out.println("Estado: " + estado);
        System.out.println("CEP: " + cep);
        System.out.println("Id: " + usuarioId);
        System.out.println("Telefone1: " + telefone1);
        System.out.println("Telefone2: " + telefone2);

    String sql = "INSERT INTO CONTATOS(nome, email, logradouro, numero, bairro, cidade, estado, cep, usuario_id, telefone1, telefone2)" +
       "VALUES ('" + nome +"' , '" + email +"' , '" + logradouro + "' , " + numero + ", '" + bairro + "', '"
            + cidade + "' , '" + estado + "' , '" + cep + "', " + usuarioId + " , '" + telefone1 + "' , '" + telefone2 + "' )";
        int result = ConnectionManager.getCurrentConnection().prepareStatement(sql).executeUpdate();

        System.out.println("sql: " + sql);

    }
	@Override
	public List<Contato> ler(int usuarioId) throws SQLException {
		String sql = "SELECT * FROM CONTATOS WHERE usuario_id = " + usuarioId;
		System.out.println("usuarioId: " + usuarioId);

		ResultSet result = ConnectionManager.getCurrentConnection().prepareStatement(sql).executeQuery();
		List<Contato> listaContato = new ArrayList<>();

		while (result.next()) {
			listaContato.add(new Contato(
					result.getString("nome"),
					result.getString("email"),
					result.getString("logradouro"),
					result.getInt("numero"),
					result.getString("bairro"),
					result.getString("cidade"),
					result.getString("estado"),
					result.getString("cep"),
					result.getString("telefone1"),
					result.getString("telefone2")
			));
		}

		for (Contato contato : listaContato) {
			System.out.println(contato.getNome() + " - " + contato.getEmail());
		}

		return listaContato;
	}

	@Override
	public void excluir(String email) throws SQLException {
		String sql = "DELETE FROM CONTATOS WHERE email = '" + email + "'";
		System.out.println("usuario deletado: " + email);

		int result = ConnectionManager.getCurrentConnection().prepareStatement(sql).executeUpdate();
	}


	@Override
	public void alterar(Contato z) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario ler(String email, String senha) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(String nome, String email, String senha) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(String nome, String email, String senha) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void inserir(String nome, String email, String logradouro, int numero, String bairro, String cidade,
			String estado, String cep, int usuarioId) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Integer k) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}