package br.com.petshop.gerenciador.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class ClienteDAO {
	private Conexao con = new Conexao();
	private static Integer idCliente=0;
	
	private static List<Cliente> clientes= new ArrayList<>();


	public void adicionaCliente(Cliente cliente) {
		try {
			String sql="Insert into "
					+ "cliente(nomeCliente,dataNascimento,cep,numero,cpfCnpj,telefone,celular,planoSaude)"
					+ "values(?,?,?,?,?,?,?,?)";
			
			PreparedStatement  statement = con.conecta(sql);
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
			Date data = null;
			try {
				data = formatter.parse(cliente.getDataNascimento());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			statement.setString(1, cliente.getNome());
			statement.setDate(2,  java.sql.Date.valueOf(formatter.format(data)));
			statement.setString(3, cliente.getCep());
			statement.setInt(4, cliente.getNumeroEndereco());
			statement.setString(5, cliente.getCpfCnpj());
			statement.setString(6, cliente.getTelefone());
			statement.setString(7, cliente.getCelular());
			statement.setString(8, cliente.getPlanoSaude());
			statement.executeUpdate();
			
			con.desconecta();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}
	
	public void removeCliente(int index) {
		// TODO Auto-generated method stub
		String sql="delete from "
				+ "cliente where pkCliente="+index;
		
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
	
	public List<Cliente> getCliente(){
		// TODO Auto-generated method stub
				
				String sql="Select * from "
						+ "cliente";
				
				PreparedStatement statement;
				
				try {
					clientes.clear();
					statement = con.conecta(sql);
					statement.execute();
					ResultSet r = statement.getResultSet();
					
				while(r.next()) {
					Cliente cliente = new Cliente();
					cliente.setId(r.getInt("pkCliente"));
					cliente.setNome(r.getString("nomeCliente"));
					cliente.setDataNascimento(r.getString("dataNascimento"));
					cliente.setCep(r.getString("cep"));
					cliente.setNumeroEndereco(r.getInt("numero"));
					cliente.setCpfCnpj(r.getString("cpfCnpj"));
					cliente.setTelefone(r.getString("telefone"));
					cliente.setCelular(r.getString("celular"));
					cliente.setPlanoSaude(r.getString("planoSaude"));
					clientes.add(cliente);
				}
					con.desconecta();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return ClienteDAO.clientes;
	}

	public Cliente buscaClientePorId(int id) {
		
		String sql="Select * from "
				+ "cliente where pkCliente='"+id+"'";
		
		PreparedStatement statement;
		
		try {
			clientes.clear();
			statement = con.conecta(sql);
			statement.execute();
			ResultSet r = statement.getResultSet();
			
		if(r.isBeforeFirst()) {
			r.next();
			Cliente cliente = new Cliente();
			cliente.setId(r.getInt("pkCliente"));
			cliente.setNome(r.getString("nomeCliente"));
			cliente.setDataNascimento(r.getString("dataNascimento"));
			cliente.setCep(r.getString("cep"));
			cliente.setNumeroEndereco(r.getInt("numero"));
			cliente.setCpfCnpj(r.getString("cpfCnpj"));
			cliente.setTelefone(r.getString("telefone"));
			cliente.setCelular(r.getString("celular"));
			cliente.setPlanoSaude(r.getString("planoSaude"));
			return cliente;
		}
			con.desconecta();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public void alterarCliente(int id, String nome, String dataNascimento, String cep, int numeroEndereco, String cpfCnpj, String telefone, String celular, String planoSaude) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Date data = null;
		try {
			data = formatter.parse(dataNascimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql="UPDATE cliente SET "
				+ "nomeCliente='"+nome+"',"
				+ "dataNascimento='"+java.sql.Date.valueOf(formatter.format(data))+"',"
				+ "cep='"+cep+"',"
				+ "numero='"+numeroEndereco+"',"
				+ "cpfCnpj='"+cpfCnpj+"',"
				+ "telefone='"+telefone+"',"
				+ "celular='"+celular+"',"
				+ "planoSaude='"+planoSaude+ "' where pkCliente like "+id;
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
	
	//USUARIO
	public Usuario existeUsuario(String login, String password) {
		// TODO Auto-generated method stub
		
		String sql="Select * from "
				+ "usuario where usuario='"+login+"' "
				+ "AND senha ='"+password+"'";
		
		PreparedStatement statement;
		
		try {
			statement = con.conecta(sql);
			statement.execute();
			Usuario user = new Usuario();
			ResultSet r = statement.getResultSet();
			if(r.isBeforeFirst() ) {
				r.next();
				user.setLogin(r.getString("usuario"));
				user.setSenha(r.getString("senha"));
				return user;
			}else {
				System.out.println("usuário não existe");
			}
			con.desconecta();
			
		
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
