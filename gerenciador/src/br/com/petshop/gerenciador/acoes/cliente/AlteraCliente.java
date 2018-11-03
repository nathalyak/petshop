package br.com.petshop.gerenciador.acoes.cliente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.acoes.Acao;
import br.com.petshop.gerenciador.modelo.ClienteDAO;

public class AlteraCliente implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String codigoCliente = request.getParameter("id");
		String nomeCliente = request.getParameter("nome");
		String dataNascimento = request.getParameter("dataNascimento");
		String cep = request.getParameter("cep");
		int numeroEndereco = Integer.parseInt(request.getParameter("numeroEndereco"));
		String cpfCnpj = request.getParameter("cpfCnpj");
		String telefone = request.getParameter("telefone");
		String celular = request.getParameter("celular");
		String planoSaude = request.getParameter("planoSaude");

		ClienteDAO banco = new ClienteDAO();
		banco.alterarCliente(Integer.parseInt(codigoCliente), nomeCliente, dataNascimento, cep, numeroEndereco, cpfCnpj,
				telefone, celular, planoSaude);

		return "redirect:paginas?acao=ListaClientes&pacote=cliente.";
	}
}
