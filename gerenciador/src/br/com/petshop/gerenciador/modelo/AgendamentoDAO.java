package br.com.petshop.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AgendamentoDAO {
	private static List<Agendamento> agendamentos= new ArrayList<>();
	private static Integer idAgendamento=0;
	

	public void adicionaAgendamento(Agendamento agendamento) {
		// TODO Auto-generated method stub
		agendamento.setIdAgendamento(idAgendamento++);
		agendamentos.add(agendamento);
	}
	
	public void removeAgendamento(int index) {
		// TODO Auto-generated method stub
		Iterator<Agendamento> it = agendamentos.iterator();
		while(it.hasNext()) {
			Agendamento agendamento = it.next();
			if(agendamento.getIdAgendamento()==index) {
				it.remove();
			}
		}
	
	}
	
	public List<Agendamento> getAgendamento(){
		
		return AgendamentoDAO.agendamentos;
	}

	public Agendamento buscaAgendamentoPorId(int id) {
		
		for (Agendamento agendamento : agendamentos) {
			if(agendamento.getIdAgendamento()==id) {
				return agendamento;
			}
		}
		return null;
		// TODO Auto-generated method stub
		
	}

	public void alterarAgendamento(int idAgendamento, int idPet, int idVeterinario, int idCliente, String data, String hora) {
		// TODO Auto-generated method stub

		for (Agendamento agendamento : agendamentos) {
			if(agendamento.getIdAgendamento()==idAgendamento) {
				
				agendamento.setIdCliente(idCliente);
				agendamento.setIdPet(idPet);
				agendamento.setData(data);
				agendamento.setHora(hora);
				agendamento.setIdVeterinario(idVeterinario);
			}
		}

	}
	
}
