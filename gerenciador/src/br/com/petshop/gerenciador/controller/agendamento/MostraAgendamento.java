package br.com.petshop.gerenciador.controller.agendamento;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.modelo.AgendamentoDAO;
import br.com.petshop.gerenciador.modelo.Cliente;
import br.com.petshop.gerenciador.modelo.ClienteDAO;
import br.com.petshop.gerenciador.modelo.Pet;
import br.com.petshop.gerenciador.modelo.PetDAO;
import br.com.petshop.gerenciador.modelo.Veterinario;
import br.com.petshop.gerenciador.modelo.VeterinarioDAO;
import br.com.petshop.gerenciador.controller.Acao;
import br.com.petshop.gerenciador.modelo.Agendamento;

public class MostraAgendamento implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String codigoAgendamento= request.getParameter("id");
		AgendamentoDAO banco = new AgendamentoDAO();
		
		Agendamento agendamento = banco.buscaAgendamentoPorId(Integer.parseInt(codigoAgendamento));
		
		 String tipo = request.getParameter("tipo");
		 request.setAttribute("agendamento", agendamento);
		 
			ClienteDAO bancoC = new ClienteDAO();
			
			List<Cliente> clientes = bancoC.getCliente();
			
			request.setAttribute("listaNomeC",clientes);
			
		VeterinarioDAO bancoV = new VeterinarioDAO();
			
			List<Veterinario> veterinarios = bancoV.getVeterinario();
			
			request.setAttribute("listaNomeV",veterinarios);
			
		PetDAO bancoP = new PetDAO();
			
			List<Pet> pets = bancoP.getPet();
			
			request.setAttribute("listaNomeP",pets);
			
		 
		 if(tipo.equals("Exibe"))
			 return "forward:exibeAgendamento.jsp";
		 else
			 return "forward:alterarAgendamento.jsp";
	}
}
