package br.com.petshop.gerenciador.acoes.cliente;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.modelo.ClienteDAO;
import br.com.petshop.gerenciador.acoes.Acao;
import br.com.petshop.gerenciador.modelo.Cliente;

public class NovoCliente implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();

		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String celular = request.getParameter("celular");
		String dataNascimento = request.getParameter("dataNascimento");
		String cpfCnpj = request.getParameter("cpfCnpj");
		String cep = request.getParameter("cep");
		String numeroEndereco= request.getParameter("numeroEndereco");
		String planoSaude = request.getParameter("planoSaude");
		
		Cliente cliente = new Cliente();
		
		//simulação
		ClienteDAO banco = new ClienteDAO();
		cliente.setNome(nome);
		cliente.setCelular(celular);
		cliente.setCep(cep);
		cliente.setCpfCnpj(cpfCnpj);
		cliente.setDataNascimento(dataNascimento);
		cliente.setNumeroEndereco(Integer.parseInt(numeroEndereco));
		cliente.setPlanoSaude(planoSaude);
		cliente.setTelefone(telefone);
		
		banco.adicionaCliente(cliente);


		return "redirect:paginas?acao=ListaClientes&pacote=cliente.";
	}

}
