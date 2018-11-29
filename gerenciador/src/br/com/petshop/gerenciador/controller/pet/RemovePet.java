package br.com.petshop.gerenciador.controller.pet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.controller.Acao;
import br.com.petshop.gerenciador.modelo.PetDAO;

public class RemovePet implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigoPet= request.getParameter("id");
		PetDAO banco = new PetDAO();
		banco.removePet(Integer.parseInt(codigoPet));
		
		return "redirect:paginas?acao=ListaPets&pacote=pet.";
	}
}
