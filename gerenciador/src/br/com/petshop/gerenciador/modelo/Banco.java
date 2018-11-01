package br.com.petshop.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
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
	public void adiciona(Cliente cliente) {
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
	
	public void Altera(int index) {
		// TODO Auto-generated method stub
		clientes.remove(index);
	}
	public List<Cliente> getCliente(){
		
		return Banco.clientes;
	}

	public Cliente buscaEmpresaPorId(int id) {
		
		for (Cliente cliente : clientes) {
			if(cliente.getId()==id) {
				return cliente;
			}
		}
		return null;
		// TODO Auto-generated method stub
		
	}

	public void alterarCliente(int id, String nome) {
		// TODO Auto-generated method stub

		for (Cliente cliente : clientes) {
			if(cliente.getId()==id) {
				cliente.setNome(nome);
			}
		}

	}

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
