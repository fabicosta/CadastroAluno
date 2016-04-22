package br.com.fabianocosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabianocosta.dao.AlunoDAO;
import br.com.fabianocosta.dao.AlunoDAOImpl;
import br.com.fabianocosta.model.Aluno;

@WebServlet("/AlunoController")
public class AlunoController extends HttpServlet {
	private AlunoDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String lISTA_ALUNO = "/listaAluno.jsp";
	public static final String INCLUIR_OU_ALTERAR = "/aluno.jsp";
	
	public AlunoController() {
		dao = new AlunoDAOImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("excluir")) {
			forward = lISTA_ALUNO;
			int id = Integer.parseInt(request.getParameter("id"));
			dao.excluir(id);
			request.setAttribute("alunos", dao.getTodos());
		} else if (action.equalsIgnoreCase("alterar")) {
			forward = INCLUIR_OU_ALTERAR;
			int id = Integer.parseInt(request.getParameter("id"));
			Aluno aluno = dao.getPorId(id);
			request.setAttribute("aluno", aluno);
		} else if (action.equalsIgnoreCase("incluir")) {
			forward = INCLUIR_OU_ALTERAR;
		} else {
			forward = lISTA_ALUNO;
			request.setAttribute("alunos", dao.getTodos());
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		Aluno aluno = new Aluno();
		aluno.setPrimeiroNome(request.getParameter("primeiroNome"));
		aluno.setUltimoNome(request.getParameter("ultimoNome"));
		aluno.setCurso(request.getParameter("curso"));
		aluno.setIdade(Integer.parseInt(request.getParameter("idade")));
		String id = request.getParameter("id");
		
		if( id == null || id.isEmpty())
			dao.incluir(aluno);
		else {
			aluno.setId(Integer.parseInt(id));
			dao.alterar(aluno);
		}
		RequestDispatcher view = request.getRequestDispatcher(lISTA_ALUNO);
		request.setAttribute("alunos", dao.getTodos());
		view.forward(request, response);
	}
}
