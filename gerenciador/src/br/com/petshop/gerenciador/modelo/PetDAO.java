package br.com.petshop.gerenciador.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PetDAO {
	private static List<Pet> pets= new ArrayList<>();
	private static List<Usuario> usuarios= new ArrayList<>();
	private static Integer idPet=0;
	private Conexao con = new Conexao();
	

	public void adicionaPet(Pet pet) {
		String sql="Insert into "
				+ "pet(nomePet,raca,pkDono,especie,porte)"
				+ "values(?,?,?,?,?)";
		try {
		PreparedStatement  statement = con.conecta(sql);
		
		statement.setString(1, pet.getNomePet());
		statement.setString(2, pet.getRaca());
		statement.setInt(3, pet.getIdDono());
		statement.setString(4, pet.getEspecie());
		statement.setString(5, pet.getPorte());
;
		statement.executeUpdate();
		
		con.desconecta();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void removePet(int index) {
		// TODO Auto-generated method stub
		String sqlDeletaPet = "delete pet.* "
				+ " from pet where pkPet='"+index+"';";
		String sqlDeletaAgendamento="delete agendamento.* "
				+ " from agendamento where agendamento.fkPet='"+index+"';";
		
		PreparedStatement statement;
		
		try {
		
			statement = con.conecta(sqlDeletaAgendamento);
			statement.execute("SET FOREIGN_KEY_CHECKS=0;");
			statement.executeUpdate();
			statement.execute("SET FOREIGN_KEY_CHECKS=1;");
			
			statement = con.conecta(sqlDeletaPet);
			statement.execute("SET FOREIGN_KEY_CHECKS=0;");
			statement.executeUpdate();
			statement.execute("SET FOREIGN_KEY_CHECKS=1;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public List<Pet> getPet(){
		
		String sql="Select * from "
				+ "pet";
		
		PreparedStatement statement;
		
		try {
			pets.clear();
			statement = con.conecta(sql);
			statement.execute();
			ResultSet r = statement.getResultSet();
			
		while(r.next()) {
			Pet pet = new Pet();
			pet.setIdPet(r.getInt("pkPet"));
			pet.setNomePet(r.getString("nomePet"));
			pet.setRaca(r.getString("raca"));
			pet.setEspecie(r.getString("especie"));
			pet.setPorte(r.getString("porte"));
			
			pets.add(pet);
		}
			con.desconecta();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return PetDAO.pets;
	}

	public Pet buscaPetPorId(int id) {
		
		
		String sql="Select * from "
				+ "pet where pkPet='"+id+"'";
		
		PreparedStatement statement;
		
		try {
			pets.clear();
			statement = con.conecta(sql);
			statement.execute();
			ResultSet r = statement.getResultSet();
			
		if(r.isBeforeFirst()) {
			r.next();
			Pet pet = new Pet();
			pet.setIdPet(r.getInt("pkPet"));;
			pet.setNomePet(r.getString("nomePet"));
			pet.setRaca(r.getString("raca"));
			pet.setIdDono(r.getInt("pkDono"));
			pet.setEspecie(r.getString("especie"));
			pet.setPorte(r.getString("porte"));
			return pet;
		}
			con.desconecta();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public void alterarPet(int id, String nome, String raca, int idDono, String especie, String porte) {
		// TODO Auto-generated method stub
	
		String sql="UPDATE pet SET "
				+ "nomePet='"+nome+"',"
				+ "raca='"+raca+"',"
				+ "pkDono='"+idDono+"',"
				+ "especie='"+especie+"',"
				+ "porte='"+porte+ "' where pkPet like "+id;
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
