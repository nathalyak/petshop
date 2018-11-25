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

public class VeterinarioDAO {
	private static List<Veterinario> veterinarios= new ArrayList<>();
	private static List<Usuario> usuarios= new ArrayList<>();
	private static Integer idVeterinario=0;
	private Conexao con = new Conexao();

	public void adicionaVeterinario(Veterinario veterinario) {
		try {
			String sql="Insert into "
					+ "veterinario(nomeveterinario,dataNascimento,cep,numero,cpfCnpj,telefone,"
					+ "celular,registro,formacao)"
					+ "values(?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement  statement = con.conecta(sql);
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
			Date data = null;
			try {
				data = formatter.parse(veterinario.getDataNascimento());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			statement.setString(1, veterinario.getNomeVeterinario());
			statement.setDate(2,  java.sql.Date.valueOf(formatter.format(data)));
			statement.setString(3, veterinario.getCep());
			statement.setInt(4, veterinario.getNumero());
			statement.setString(5, veterinario.getCpfCnpj());
			statement.setString(6, veterinario.getTelefone());
			statement.setString(7, veterinario.getCelular());
			statement.setString(8, veterinario.getNumeroRegistro());
			statement.setString(9, veterinario.getFormacao());
			statement.executeUpdate();
			
			con.desconecta();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}
	
	public void removeVeterinario(int index) {
		// TODO Auto-generated method stub
		String sql="delete from "
				+ "veterinario where pkVeterinario="+index;
		
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
	
	public List<Veterinario> getVeterinario(){
		
		// TODO Auto-generated method stub
		
		String sql="Select * from "
				+ "veterinario";
		
		PreparedStatement statement;
		
		try {
			veterinarios.clear();
			statement = con.conecta(sql);
			statement.execute();
			ResultSet r = statement.getResultSet();
			
		while(r.next()) {
			Veterinario veterinario = new Veterinario();
			veterinario.setIdVeterinario(r.getInt("pkVeterinario"));
			veterinario.setNomeVeterinario(r.getString("nomeVeterinario"));
			veterinario.setDataNascimento(r.getString("dataNascimento"));
			veterinario.setCep(r.getString("cep"));
			veterinario.setNumero(r.getInt("numero"));
			veterinario.setCpfCnpj(r.getString("cpfCnpj"));
			veterinario.setTelefone(r.getString("telefone"));
			veterinario.setCelular(r.getString("celular"));
			veterinario.setNumeroRegistro(r.getString("registro"));
			veterinario.setFormacao(r.getString("formacao"));
			
			veterinarios.add(veterinario);
		}
			con.desconecta();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return VeterinarioDAO.veterinarios;
	}

	public Veterinario buscaVeterinarioPorId(int id) {
		
		String sql="Select * from "
				+ "veterinario where pkVeterinario='"+id+"'";
		
		PreparedStatement statement;
		
		try {
			veterinarios.clear();
			statement = con.conecta(sql);
			statement.execute();
			ResultSet r = statement.getResultSet();
			
		if(r.isBeforeFirst()) {
			r.next();
			Veterinario veterinario = new Veterinario();
			veterinario.setIdVeterinario(r.getInt("pkVeterinario"));
			veterinario.setNomeVeterinario(r.getString("nomeVeterinario"));
			veterinario.setDataNascimento(r.getString("dataNascimento"));
			veterinario.setCep(r.getString("cep"));
			veterinario.setNumero(r.getInt("numero"));
			veterinario.setCpfCnpj(r.getString("cpfCnpj"));
			veterinario.setTelefone(r.getString("telefone"));
			veterinario.setCelular(r.getString("celular"));
			veterinario.setNumeroRegistro(r.getString("registro"));
			veterinario.setFormacao(r.getString("formacao"));
			return veterinario;
		}
			con.desconecta();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public void alterarVeterinario(int id, String nome, String dataNascimento, int numero, String cep, String cpfCnpj, String telefone, String celular, String numeroRegistro, String formacao) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Date data = null;
		try {
			data = formatter.parse(dataNascimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql="UPDATE veterinario SET "
				+ "nomeVeterinario='"+nome+"',"
				+ "dataNascimento='"+java.sql.Date.valueOf(formatter.format(data))+"',"
				+ "cep='"+cep+"',"
				+ "numero='"+numero+"',"
				+ "cpfCnpj='"+cpfCnpj+"',"
				+ "telefone='"+telefone+"',"
				+ "celular='"+celular+"',"
				+ "formacao='"+formacao+"',"
				+ "registro='"+numeroRegistro+ "' where pkVeterinario like "+id;
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
