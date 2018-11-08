package br.com.petshop.gerenciador.acoes.pet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.modelo.PetDAO;
import br.com.petshop.gerenciador.acoes.Acao;
import br.com.petshop.gerenciador.modelo.Pet;

public class MostraPet implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String codigoPet= request.getParameter("id");
		PetDAO banco = new PetDAO();
		
		Pet pet = banco.buscaPetPorId(Integer.parseInt(codigoPet));
		
		 String tipo = request.getParameter("tipo");
		 request.setAttribute("pet", pet);
		 
		 if(tipo.equals("Exibe"))
			 return "forward:exibePet.jsp";
		 else
			 return "forward:alterarPet.jsp";
	}
}
