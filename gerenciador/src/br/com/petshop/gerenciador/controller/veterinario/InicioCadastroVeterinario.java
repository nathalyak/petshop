package br.com.petshop.gerenciador.controller.veterinario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.controller.Acao;;


public class InicioCadastroVeterinario implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return "forward:cadastraVeterinario.jsp";
	}

}
