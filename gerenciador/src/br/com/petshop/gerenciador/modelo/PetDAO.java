package br.com.petshop.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PetDAO {
	private static List<Pet> pets= new ArrayList<>();
	private static List<Usuario> usuarios= new ArrayList<>();
	private static Integer idPet=0;
	

	public void adicionaPet(Pet pet) {
		// TODO Auto-generated method stub
		pet.setIdPet(idPet++);
		pets.add(pet);
	}
	
	public void removePet(int index) {
		// TODO Auto-generated method stub
		Iterator<Pet> it = pets.iterator();
		while(it.hasNext()) {
			Pet pet = it.next();
			if(pet.getIdPet()==index) {
				it.remove();
			}
		}
	
	}
	
	public List<Pet> getPet(){
		
		return PetDAO.pets;
	}

	public Pet buscaPetPorId(int id) {
		
		for (Pet pet : pets) {
			if(pet.getIdPet()==id) {
				return pet;
			}
		}
		return null;
		// TODO Auto-generated method stub
		
	}

	public void alterarPet(int id, String nome, String raca, int idDono, String especie, String porte) {
		// TODO Auto-generated method stub

		for (Pet pet : pets) {
			if(pet.getIdPet()==id) {
				pet.setNomePet(nome);
				pet.setRaca(raca);
				pet.setIdDono(idDono);
				pet.setEspecie(especie);
				pet.setPorte(porte);
				
			}
		}

	}
	

}
