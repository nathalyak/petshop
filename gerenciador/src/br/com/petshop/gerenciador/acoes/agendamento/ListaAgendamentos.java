package br.com.petshop.gerenciador.acoes.agendamento;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.modelo.AgendamentoDAO;
import br.com.petshop.gerenciador.acoes.Acao;
import br.com.petshop.gerenciador.modelo.Agendamento;

public class ListaAgendamentos  implements Acao{
	public String executa(HttpServletRequest request,HttpServletResponse response ) throws ServletException,IOException{

		AgendamentoDAO banco = new AgendamentoDAO();
		
		List<Agendamento> agendamentos = banco.getAgendamento();
		
		request.setAttribute("listaNome",agendamentos);

		return "forward:listarAgendamento.jsp";
	}
}
