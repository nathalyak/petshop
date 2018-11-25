package br.com.petshop.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class VeterinarioDAO {
	private static List<Veterinario> veterinarios= new ArrayList<>();
	private static List<Usuario> usuarios= new ArrayList<>();
	private static Integer idVeterinario=0;
	

	public void adicionaVeterinario(Veterinario veterinario) {
		// TODO Auto-generated method stub
		veterinario.setIdVeterinario(idVeterinario++);
		veterinarios.add(veterinario);
	}
	
	public void removeVeterinario(int index) {
		// TODO Auto-generated method stub
		Iterator<Veterinario> it = veterinarios.iterator();
		while(it.hasNext()) {
			Veterinario veterinario = it.next();
			if(veterinario.getIdVeterinario()==index) {
				it.remove();
			}
		}
	
	}
	
	public List<Veterinario> getVeterinario(){
		
		return VeterinarioDAO.veterinarios;
	}

	public Veterinario buscaVeterinarioPorId(int id) {
		
		for (Veterinario veterinario : veterinarios) {
			if(veterinario.getIdVeterinario()==id) {
				return veterinario;
			}
		}
		return null;
		// TODO Auto-generated method stub
		
	}

	public void alterarVeterinario(int id, String nome, String dataNascimento, int numero, String cep, String cpfCnpj, String telefone, String celular, String numeroRegistro, String formacao) {
		// TODO Auto-generated method stub

		for (Veterinario veterinario : veterinarios) {
			if(veterinario.getIdVeterinario()==id) {
				veterinario.setNomeVeterinario(nome);
				veterinario.setCelular(celular);
				veterinario.setCep(cep);
				veterinario.setCpfCnpj(cpfCnpj);
				veterinario.setDataNascimento(dataNascimento);
				veterinario.setNumero(numero);
				veterinario.setTelefone(telefone);
				veterinario.setNumeroRegistro(numeroRegistro);
				veterinario.setFormacao(formacao);
				
			}
		}

	}
}
