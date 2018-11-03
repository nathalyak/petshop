package br.com.petshop.gerenciador.acoes.cliente;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.modelo.ClienteDAO;
import br.com.petshop.gerenciador.acoes.Acao;
import br.com.petshop.gerenciador.modelo.Cliente;

public class MostraCliente implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String codigoCliente= request.getParameter("id");
		ClienteDAO banco = new ClienteDAO();
		
		Cliente cliente = banco.buscaClientePorId(Integer.parseInt(codigoCliente));
		
		 String tipo = request.getParameter("tipo");
		 request.setAttribute("cliente", cliente);
		 
		 if(tipo.equals("Exibe"))
			 return "forward:exibeCliente.jsp";
		 else
			 return "forward:alterarCliente.jsp";
	}
}
