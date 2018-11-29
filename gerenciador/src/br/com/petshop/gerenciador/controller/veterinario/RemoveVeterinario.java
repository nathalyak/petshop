package br.com.petshop.gerenciador.controller.veterinario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.controller.Acao;
import br.com.petshop.gerenciador.modelo.VeterinarioDAO;;

public class RemoveVeterinario implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigoVeterinario= request.getParameter("id");
		VeterinarioDAO banco = new VeterinarioDAO();
		banco.removeVeterinario(Integer.parseInt(codigoVeterinario));
		
		return "redirect:paginas?acao=ListaVeterinarios&pacote=veterinario.";
	}
}
