package br.com.petshop.gerenciador.acoes.veterinario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.acoes.Acao;
import br.com.petshop.gerenciador.modelo.VeterinarioDAO;

public class AlteraVeterinario implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idVeterinario = request.getParameter("idVeterinario");
		String nomeVeterinario = request.getParameter("nomeVeterinario");
		String celular = request.getParameter("celular");
		String cep = request.getParameter("cep");
		String cpfCnpj= request.getParameter("cpfCnpj");
		String dataNascimento= request.getParameter("dataNascimento");
		String numero = request.getParameter("numero");
		String telefone= request.getParameter("telefone");
		String numeroRegistro = request.getParameter("numeroRegistro");
		String formacao = request.getParameter("formacao");
		VeterinarioDAO banco = new VeterinarioDAO();
		
		banco.alterarVeterinario(Integer.parseInt(idVeterinario),  nomeVeterinario,  dataNascimento,  Integer.parseInt(numero),  cep,  cpfCnpj,  telefone,  celular,  numeroRegistro,  formacao);

		return "redirect:paginas?acao=ListaVeterinarios&pacote=veterinario.";
	}
}
