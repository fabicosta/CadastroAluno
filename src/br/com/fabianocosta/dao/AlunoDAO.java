package br.com.fabianocosta.dao;

import java.util.List;

import br.com.fabianocosta.model.Aluno;

public interface AlunoDAO {
	public void incluir(Aluno aluno);
	public void excluir(int id);
	public void alterar(Aluno aluno);
	public List<Aluno> getTodos();
	public Aluno getPorId(int id);
}