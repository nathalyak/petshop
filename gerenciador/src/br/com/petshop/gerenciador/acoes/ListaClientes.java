package br.com.petshop.gerenciador.acoes;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.modelo.Banco;
import br.com.petshop.gerenciador.modelo.Cliente;

public class ListaClientes  implements Acao{
	public String executa(HttpServletRequest request,HttpServletResponse response ) throws ServletException,IOException{

		Banco banco = new Banco();
		
		List<Cliente> clientes = banco.getCliente();
		
		request.setAttribute("listaNome",clientes);

		return "forward:listarClientes.jsp";
	}
}
