package br.com.petshop.gerenciador.acoes.pet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.acoes.Acao;
import br.com.petshop.gerenciador.modelo.ClienteDAO;
import br.com.petshop.gerenciador.modelo.Pet;
import br.com.petshop.gerenciador.modelo.PetDAO;

public class NovoPet implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();

		String nomePet = request.getParameter("nomePet");
		String raca = request.getParameter("raca");
		String idDono = request.getParameter("idDono");
		String especie = request.getParameter("especie");
		String porte = request.getParameter("porte");
		Pet pet = new Pet();
		
		//simulação
		PetDAO banco = new PetDAO();
		pet.setNomePet(nomePet);
		pet.setRaca(raca);
		pet.setIdDono(Integer.parseInt(idDono));
		pet.setEspecie(especie);
		pet.setPorte(porte);
		
		
		banco.adicionaPet(pet);


		return "redirect:paginas?acao=ListaPets&pacote=pet.";
	}

}

