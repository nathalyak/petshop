package br.com.petshop.gerenciador.controller.agendamento;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.controller.Acao;
import br.com.petshop.gerenciador.modelo.Cliente;
import br.com.petshop.gerenciador.modelo.ClienteDAO;
import br.com.petshop.gerenciador.modelo.Pet;
import br.com.petshop.gerenciador.modelo.PetDAO;
import br.com.petshop.gerenciador.modelo.Veterinario;
import br.com.petshop.gerenciador.modelo.VeterinarioDAO;;


public class InicioCadastroAgendamento implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	ClienteDAO bancoC = new ClienteDAO();
		
		List<Cliente> clientes = bancoC.getCliente();
		
		request.setAttribute("listaNomeC",clientes);
		
	VeterinarioDAO bancoV = new VeterinarioDAO();
		
		List<Veterinario> veterinarios = bancoV.getVeterinario();
		
		request.setAttribute("listaNomeV",veterinarios);
		
	PetDAO bancoP = new PetDAO();
		
		List<Pet> pets = bancoP.getPet();
		
		request.setAttribute("listaNomeP",pets);
		
		
		return "forward:cadastraAgendamento.jsp";
	}

}
