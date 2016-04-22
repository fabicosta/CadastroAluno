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

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private AlunoDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String LOGIN = "/login.jsp";
	public static final String LISTA_ALUNO = "AlunoController?action=listaAluno";
	
	public LoginController() {
		dao = new AlunoDAOImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		RequestDispatcher view = request.getRequestDispatcher(LOGIN) ;
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String forward = "";
		
		if ((!login.isEmpty() && !senha.isEmpty()) && login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("123")) {
			forward = LISTA_ALUNO;
			request.setAttribute("alunos", dao.getTodos());
		} else {
			forward = LOGIN;
			request.setAttribute("mensagem", "Usuário e senha inválido!");
		}
				
		response.sendRedirect(forward);
	}
}
