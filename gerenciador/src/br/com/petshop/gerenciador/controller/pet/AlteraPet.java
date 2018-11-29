package br.com.petshop.gerenciador.controller.pet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.controller.Acao;
import br.com.petshop.gerenciador.modelo.PetDAO;

public class AlteraPet implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idPet = request.getParameter("idPet");
		String nomePet = request.getParameter("nomePet");
		String raca = request.getParameter("raca");
		String idDono = request.getParameter("idDono");
		String especie = request.getParameter("especie");
		String porte = request.getParameter("porte");

		PetDAO banco = new PetDAO();
		banco.alterarPet(Integer.parseInt(idPet), nomePet, raca, Integer.parseInt(idDono), especie, porte);

		return "redirect:paginas?acao=ListaPets&pacote=pet.";
	}
}
