package br.com.petshop.gerenciador.acoes.veterinario;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.modelo.VeterinarioDAO;
import br.com.petshop.gerenciador.acoes.Acao;
import br.com.petshop.gerenciador.modelo.Veterinario;

public class ListaVeterinarios  implements Acao{
	public String executa(HttpServletRequest request,HttpServletResponse response ) throws ServletException,IOException{

		VeterinarioDAO banco = new VeterinarioDAO();
		
		List<Veterinario> veterinarios = banco.getVeterinario();
		
		request.setAttribute("listaNome",veterinarios);

		return "forward:listarVeterinario.jsp";
	}
}
