package br.com.petshop.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.modelo.Banco;
import br.com.petshop.gerenciador.modelo.Cliente;

public class MostraCliente implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String codigoCliente= request.getParameter("id");
		Banco banco = new Banco();
		
		Cliente cliente = banco.buscaEmpresaPorId(Integer.parseInt(codigoCliente));
		
		 request.setAttribute("cliente", cliente);

		 
		 return "forward:alterarCliente.jsp";
	}
}
