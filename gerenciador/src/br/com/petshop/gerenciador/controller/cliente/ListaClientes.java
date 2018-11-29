package br.com.petshop.gerenciador.controller.cliente;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.modelo.ClienteDAO;
import br.com.petshop.gerenciador.controller.Acao;
import br.com.petshop.gerenciador.modelo.Cliente;

public class ListaClientes  implements Acao{
	public String executa(HttpServletRequest request,HttpServletResponse response ) throws ServletException,IOException{

		ClienteDAO banco = new ClienteDAO();
		
		List<Cliente> clientes = banco.getCliente();
		
		request.setAttribute("listaNome",clientes);

		return "forward:listarClientes.jsp";
	}
}
