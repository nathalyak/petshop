package br.com.petshop.gerenciador.controller.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.controller.Acao;

public class Index implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipo = request.getParameter("tipo");

			return "forward:index.jsp";
	}

}
