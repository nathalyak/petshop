package br.com.petshop.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.modelo.ClienteDAO;

public class RemoveCliente implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigoCliente= request.getParameter("id");
		ClienteDAO banco = new ClienteDAO();
		banco.removeCliente(Integer.parseInt(codigoCliente));
		
		return "redirect:paginas?acao=ListaClientes";
	}
}
