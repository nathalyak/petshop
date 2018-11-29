package br.com.petshop.gerenciador.controller.agendamento;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.modelo.ClienteDAO;
import br.com.petshop.gerenciador.controller.Acao;
import br.com.petshop.gerenciador.modelo.Agendamento;
import br.com.petshop.gerenciador.modelo.AgendamentoDAO;;

public class NovoAgendamento implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();

		String idVeterinario = request.getParameter("idVeterinario");
		String idPet = request.getParameter("idPet");
		String idCliente = request.getParameter("idDono");
		String data = request.getParameter("data");
		String hora  = request.getParameter("hora");
		Agendamento agendamento = new Agendamento();
		
		//simulação
		AgendamentoDAO banco = new AgendamentoDAO();
		
		//simulação
		agendamento.setIdCliente(Integer.parseInt(idCliente));
		agendamento.setIdPet(Integer.parseInt(idPet));
		agendamento.setIdVeterinario(Integer.parseInt(idVeterinario));
		agendamento.setData(data);
		agendamento.setHora(hora);
		banco.adicionaAgendamento(agendamento);


		return "redirect:paginas?acao=ListaAgendamentos&pacote=agendamento.";
	}

}

