package br.com.petshop.gerenciador.acoes.agendamento;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.acoes.Acao;
import br.com.petshop.gerenciador.modelo.AgendamentoDAO;;

public class RemoveAgendamento implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigoAgendamento= request.getParameter("id");
		AgendamentoDAO banco = new AgendamentoDAO();
		banco.removeAgendamento(Integer.parseInt(codigoAgendamento));
		
		return "redirect:paginas?acao=ListaAgendamentos&pacote=agendamento.";
	}
}
