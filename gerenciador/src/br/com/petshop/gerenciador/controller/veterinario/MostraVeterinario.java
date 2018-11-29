package br.com.petshop.gerenciador.controller.veterinario;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.modelo.VeterinarioDAO;
import br.com.petshop.gerenciador.controller.Acao;
import br.com.petshop.gerenciador.modelo.Veterinario;

public class MostraVeterinario implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String codigoVeterinario= request.getParameter("id");
		VeterinarioDAO banco = new VeterinarioDAO();
		
		Veterinario veterinario = banco.buscaVeterinarioPorId(Integer.parseInt(codigoVeterinario));
		
		 String tipo = request.getParameter("tipo");
		 request.setAttribute("veterinario", veterinario);
		 
		 if(tipo.equals("Exibe"))
			 return "forward:exibeVeterinario.jsp";
		 else
			 return "forward:alterarVeterinario.jsp";
	}
}
