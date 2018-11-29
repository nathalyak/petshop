package br.com.petshop.gerenciador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.petshop.gerenciador.modelo.ClienteDAO;
import br.com.petshop.gerenciador.modelo.Usuario;

public class Login implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("user");
		String password = request.getParameter("senha");
		
		ClienteDAO banco = new ClienteDAO();
		
		Usuario usuario = banco.existeUsuario(login,password);
		
		if(usuario!=null) {
		
		HttpSession sessao = request.getSession();
		sessao.setAttribute("usuarioLogado", usuario);
		
			return "redirect:paginas?acao=Index&pacote=home.";
		
		}else
			return "redirect:paginas?acao=InicioLogin";
	}

}
