package br.com.petshop.gerenciador.acoes.agendamento;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.modelo.AgendamentoDAO;
import br.com.petshop.gerenciador.acoes.Acao;
import br.com.petshop.gerenciador.modelo.Agendamento;

public class MostraAgendamento implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String codigoAgendamento= request.getParameter("id");
		AgendamentoDAO banco = new AgendamentoDAO();
		
		Agendamento agendamento = banco.buscaAgendamentoPorId(Integer.parseInt(codigoAgendamento));
		
		 String tipo = request.getParameter("tipo");
		 request.setAttribute("agendamento", agendamento);
		 
		 if(tipo.equals("Exibe"))
			 return "forward:exibeAgendamento.jsp";
		 else
			 return "forward:alterarAgendamento.jsp";
	}
}
