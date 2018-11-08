package br.com.petshop.gerenciador.acoes.pet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.modelo.PetDAO;
import br.com.petshop.gerenciador.acoes.Acao;
import br.com.petshop.gerenciador.modelo.Pet;

public class ListaPets  implements Acao{
	public String executa(HttpServletRequest request,HttpServletResponse response ) throws ServletException,IOException{

		PetDAO banco = new PetDAO();
		
		List<Pet> pets = banco.getPet();
		
		request.setAttribute("listaNome",pets);

		return "forward:listarPet.jsp";
	}
}
