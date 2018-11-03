package br.com.petshop.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClienteDAO {
	private static List<Cliente> clientes= new ArrayList<>();
	private static List<Usuario> usuarios= new ArrayList<>();
	private static Integer idCliente=0;
	
	static {
		
		Usuario usuario1 = new Usuario();
		usuario1.setLogin("giovanne");
		usuario1.setSenha("senha1");
		usuarios.add(usuario1);
		Usuario usuario2 = new Usuario();
		usuario2.setLogin("giovanne2");
		usuario2.setSenha("senha2");
		usuarios.add(usuario2);
	}
	public void adicionaCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		cliente.setId(idCliente++);
		clientes.add(cliente);
	}
	
	public void removeCliente(int index) {
		// TODO Auto-generated method stub
		Iterator<Cliente> it = clientes.iterator();
		while(it.hasNext()) {
			Cliente cliente = it.next();
			if(cliente.getId()==index) {
				it.remove();
			}
		}
	
	}
	
	public List<Cliente> getCliente(){
		
		return ClienteDAO.clientes;
	}

	public Cliente buscaClientePorId(int id) {
		
		for (Cliente cliente : clientes) {
			if(cliente.getId()==id) {
				return cliente;
			}
		}
		return null;
		// TODO Auto-generated method stub
		
	}

	public void alterarCliente(int id, String nome, String dataNascimento, String cep, int numeroEndereco, String cpfCnpj, String telefone, String celular, String planoSaude) {
		// TODO Auto-generated method stub

		for (Cliente cliente : clientes) {
			if(cliente.getId()==id) {
				cliente.setNome(nome);
				cliente.setCelular(celular);
				cliente.setCep(cep);
				cliente.setTelefone(telefone);
				cliente.setNumeroEndereco(numeroEndereco);
				cliente.setCpfCnpj(cpfCnpj);
				cliente.setPlanoSaude(planoSaude);
				cliente.setDataNascimento(dataNascimento);
			}
		}

	}
	
	//USUARIO
	public Usuario existeUsuario(String login, String password) {
		// TODO Auto-generated method stub
		for (Usuario usuario : usuarios) {
			if(usuario.verifica(login, password)) {
				return usuario;
			}
		}
		return null;
	}

}
