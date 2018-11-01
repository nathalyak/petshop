package br.com.petshop.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.modelo.Banco;

public class AlteraCliente implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String codigoCliente= request.getParameter("id");
		String nomeCliente= request.getParameter("nome");
		Banco banco = new Banco();
		banco.alterarCliente(Integer.parseInt(codigoCliente),nomeCliente);
		
		return "redirect:ControlaRequisicoes?acao=ListaClientes";
	}
}
