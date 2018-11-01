package br.com.petshop.gerenciador.acoes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.modelo.Banco;
import br.com.petshop.gerenciador.modelo.Cliente;

public class NovoCliente implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();

		String nome = request.getParameter("nome");
		Cliente cliente = new Cliente();
		
		//simulação
		Banco banco = new Banco();
		cliente.setNome(nome);
		banco.adiciona(cliente);

		//jsp
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ListaClientes");
//		request.setAttribute("nome",cliente.getNome() );
//		requestDispatcher.forward(request, response);
		
		return "redirect:ControlaRequisicoes?acao=ListaClientes";
	}

}
