package br.com.fabianocosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fabianocosta.model.Aluno;
import br.com.fabianocosta.util.DBUtil;

public class AlunoDAOImpl implements AlunoDAO {

	private Connection conn;
	
	public AlunoDAOImpl() {
		conn = DBUtil.getConnection();
	}
	
	@Override
	public void incluir(Aluno aluno) {
		try {
			String query = "insert into aluno(primeiroNome, ultimoNome, curso, idade) values (?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString( 1, aluno.getPrimeiroNome() );
			preparedStatement.setString( 2, aluno.getUltimoNome() );
			preparedStatement.setString( 3, aluno.getCurso() );
			preparedStatement.setInt( 4, aluno.getIdade() );
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(int id) {
		try {
			String query = "delete from aluno where id=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Aluno aluno) {
		try {
			String query = "update aluno set primeiroNome=?, ultimoNome=?, curso=?, idade=? where id=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString( 1, aluno.getPrimeiroNome() );
			preparedStatement.setString( 2, aluno.getUltimoNome() );
			preparedStatement.setString( 3, aluno.getCurso() );
			preparedStatement.setInt( 4, aluno.getIdade() );
			preparedStatement.setInt(5, aluno.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Aluno> getTodos() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from aluno");
			while( resultSet.next() ) {
				Aluno aluno = new Aluno();
				aluno.setId( resultSet.getInt("Id"));
				aluno.setPrimeiroNome(resultSet.getString("primeiroNome"));
				aluno.setUltimoNome(resultSet.getString("ultimoNome"));
				aluno.setCurso(resultSet.getString("curso"));
				aluno.setIdade(resultSet.getInt("idade"));
				alunos.add(aluno);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alunos;
	}

	@Override
	public Aluno getPorId(int id) {
		Aluno aluno = new Aluno();
		try {
			String query = "select * from aluno where id=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				aluno.setId( resultSet.getInt("Id"));
				aluno.setPrimeiroNome(resultSet.getString("primeiroNome"));
				aluno.setUltimoNome(resultSet.getString("ultimoNome"));
				aluno.setCurso(resultSet.getString("curso"));
				aluno.setIdade(resultSet.getInt("idade"));
			}
			resultSet.close();
			preparedStatement.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aluno;
	}
}
