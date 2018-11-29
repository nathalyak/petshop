package br.com.petshop.gerenciador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub;
		
		HttpSession sessao = request.getSession();
		sessao.invalidate();
		
		return "redirect:paginas?acao=InicioLogin";
	}

}
