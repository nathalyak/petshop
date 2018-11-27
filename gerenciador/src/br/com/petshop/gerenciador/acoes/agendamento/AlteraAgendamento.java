package br.com.petshop.gerenciador.acoes.agendamento;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.acoes.Acao;
import br.com.petshop.gerenciador.modelo.AgendamentoDAO;

public class AlteraAgendamento implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idAgendamento = request.getParameter("idAgendamento");
		String idVeterinario = request.getParameter("idVeterinario");
		String idPet = request.getParameter("idPet");
		String idCliente = request.getParameter("idDono");
		String data = request.getParameter("data");
		String hora  = request.getParameter("hora");
		AgendamentoDAO banco = new AgendamentoDAO();
		
		banco.alterarAgendamento(Integer.parseInt(idAgendamento),Integer.parseInt(idVeterinario),Integer.parseInt(idPet),Integer.parseInt(idCliente),data,hora);

		return "redirect:paginas?acao=ListaAgendamentos&pacote=agendamento.";
	}
}
