package br.com.fabianocosta.model;

public class Aluno {
	private int id;
	private String primeiroNome;
	private String ultimoNome;
	private String curso;
	private int idade;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrimeiroNome() {
		return primeiroNome;
	}
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	public String getUltimoNome() {
		return ultimoNome;
	}
	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	@Override
	public String toString() {
		return "Aluno [id=" + id + ", primeiroNome=" + primeiroNome
				+ ", ultimoNome=" + ultimoNome + ", curso=" + curso
				+ ", idade=" + idade + "]";
	}
}
