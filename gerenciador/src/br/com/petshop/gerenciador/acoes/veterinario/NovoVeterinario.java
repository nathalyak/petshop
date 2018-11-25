package br.com.petshop.gerenciador.acoes.veterinario;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.acoes.Acao;
import br.com.petshop.gerenciador.modelo.ClienteDAO;
import br.com.petshop.gerenciador.modelo.Veterinario;
import br.com.petshop.gerenciador.modelo.VeterinarioDAO;;

public class NovoVeterinario implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();

		String nomeVeterinario = request.getParameter("nomeVeterinario");
		String celular = request.getParameter("celular");
		String cep = request.getParameter("cep");
		String cpfCnpj= request.getParameter("cpfCnpj");
		String dataNascimento= request.getParameter("dataNascimento");
		String numero = request.getParameter("numero");
		String telefone= request.getParameter("telefone");
		String numeroRegistro = request.getParameter("numeroRegistro");
		String formacao = request.getParameter("formacao");
		Veterinario veterinario = new Veterinario();
		
		//simulação
		VeterinarioDAO banco = new VeterinarioDAO();
		
		//simulação
		veterinario.setNomeVeterinario(nomeVeterinario);
		veterinario.setCelular(celular);
		veterinario.setCep(cep);
		veterinario.setCpfCnpj(cpfCnpj);
		veterinario.setDataNascimento(dataNascimento);
		veterinario.setNumero(Integer.parseInt(numero));
		veterinario.setTelefone(telefone);
		veterinario.setNumeroRegistro(numeroRegistro);
		veterinario.setFormacao(formacao);
		
		banco.adicionaVeterinario(veterinario);


		return "redirect:paginas?acao=ListaVeterinarios&pacote=veterinario.";
	}

}

