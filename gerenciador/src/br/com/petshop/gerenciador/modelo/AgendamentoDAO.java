package br.com.petshop.gerenciador.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AgendamentoDAO {
	private static List<Agendamento> agendamentos= new ArrayList<>();

	private Conexao con = new Conexao();

	public void adicionaAgendamento(Agendamento agendamento) {
		String sql="Insert into "
				+ "agendamento(fkVeterinario,fkPet,fkCliente,dataAgendamento,horaAgendamento)"
				+ "values(?,?,?,?,?)";
		try {
		PreparedStatement  statement = con.conecta(sql);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		SimpleDateFormat form = new SimpleDateFormat("HH:mm");
		Date data = null;
		java.sql.Time hora = null;
		
		try {
			data = formatter.parse(agendamento.getData());
			hora = new java.sql.Time(form.parse(agendamento.getHora()).getTime());
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		statement.setInt(1, agendamento.getIdVeterinario());
		statement.setInt(2, agendamento.getIdPet());
		statement.setInt(3, agendamento.getIdCliente());
		statement.setDate(4, java.sql.Date.valueOf(formatter.format(data)));
		statement.setTime(5 ,hora);
		statement.executeUpdate();
		
		con.desconecta();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void removeAgendamento(int index) {
		// TODO Auto-generated method stub
		String sql="delete from "
				+ "agendamento where pkAgendamento="+index;
		
		PreparedStatement statement;
		
		try {
			statement = con.conecta(sql);
			statement.executeUpdate();
			con.desconecta();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public List<Agendamento> getAgendamento(){
		
		String sql="Select agendamento.*, cliente.nomeCliente from "
				+ "agendamento,cliente "
				+ "where agendamento.fkCliente = cliente.pkCliente";
		
		PreparedStatement statement;
		
		try {
			agendamentos.clear();
			statement = con.conecta(sql);
			statement.execute();
			ResultSet r = statement.getResultSet();
			
		while(r.next()) {
			Agendamento agendamento = new Agendamento();
			agendamento.setNomeCliente(r.getString("nomeCliente"));
			agendamento.setIdAgendamento(r.getInt("pkAgendamento"));
			agendamento.setIdCliente(r.getInt("fkCliente"));
			agendamento.setIdPet(r.getInt("fkPet"));
			agendamento.setIdVeterinario(r.getInt("fkVeterinario"));
			agendamento.setData(r.getString("dataAgendamento"));
			agendamento.setHora(r.getString("horaAgendamento"));
			agendamentos.add(agendamento);
		}
			con.desconecta();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return AgendamentoDAO.agendamentos;
	}

	public Agendamento buscaAgendamentoPorId(int id) {
		
		String sql="Select agendamento.*,"
				+ "cliente.nomeCliente,"
				+ "veterinario.nomeVeterinario,"
				+ "pet.nomePet from "
				+ "agendamento,cliente,pet,veterinario "
				+ "where "
				+ "agendamento.fkCliente = cliente.pkCliente AND "
				+ "agendamento.fkPet = pet.pkPet AND "
				+ "agendamento.fkVeterinario = veterinario.pkVeterinario"
				;
		
		PreparedStatement statement;
		
		try {
			agendamentos.clear();
			statement = con.conecta(sql);
			statement.execute();
			ResultSet r = statement.getResultSet();
			
		if(r.isBeforeFirst()) {
			r.next();
			Agendamento agendamento = new Agendamento();
			
			agendamento.setIdAgendamento(r.getInt("pkAgendamento"));
			agendamento.setIdCliente(r.getInt("fkCliente"));
			agendamento.setIdPet(r.getInt("fkPet"));
			agendamento.setIdVeterinario(r.getInt("fkVeterinario"));
			agendamento.setData(r.getString("dataAgendamento"));
			agendamento.setHora(r.getString("horaAgendamento"));
			
			agendamento.setNomeCliente(r.getString("nomeCliente"));
			agendamento.setNomePet(r.getString("nomePet"));
			agendamento.setNomeVeterinario(r.getString("nomeVeterinario"));
			
			return agendamento;
		}
			con.desconecta();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public void alterarAgendamento(int idAgendamento, int idPet, int idVeterinario, int idCliente, String data, String hora) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		SimpleDateFormat form = new SimpleDateFormat("HH:mm");
		Date dataC = null;
		Date horaC =null;
		try {
			dataC = formatter.parse(data);
			horaC = new java.sql.Time(form.parse(hora).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql="UPDATE agendamento SET "
				+ "fkVeterinario='"+idVeterinario+"',"
				+ "fkPet='"+idPet+"',"
				+ "fkCliente='"+idCliente+"',"
				+ "dataAgendamento='"+ java.sql.Date.valueOf(formatter.format(dataC)) +"',"
				+ "horaAgendamento='"+ horaC +"' where pkAgendamento like "+idAgendamento;
		PreparedStatement statement;
		try {

			statement = con.conecta(sql);

			statement.executeUpdate();
			con.desconecta();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
