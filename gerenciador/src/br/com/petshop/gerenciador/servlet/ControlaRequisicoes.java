package br.com.petshop.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.petshop.gerenciador.acoes.Acao;

/**
 * Servlet implementation class ControlaRequisições
 */
@WebServlet(name = "ControlaRequisiçõesServlet", urlPatterns = { "/ControlaRequisicoes" })
public class ControlaRequisicoes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//getParameter para a ação que deve ser tomada
		String acao = request.getParameter("acao");
		String nomeClasse ="br.com.petshop.gerenciador.acoes." +acao;
		String nomePagina=null;

		try {
			
			Class classe = Class.forName(nomeClasse);
			Acao acaoObj = (Acao)classe.newInstance();
			//variável que vai armazenar o nome da página de redirecionamento
			nomePagina=acaoObj.executa(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
	
		//verifica login
				HttpSession sessao = request.getSession();
				if(sessao.getAttribute("usuarioLogado")==null
					&&!acao.equals("InicioLogin")) {
					
					response.sendRedirect("ControlaRequisicoes?acao=InicioLogin");
					System.out.println("Usuário não logado");
					return;
				}
		//Armazena caminho e tipo
		String[] tipoEndereco =nomePagina.split(":");
		
		
		
		System.out.println("usuario:"+sessao.getAttribute("usuarioLogado"));
		//seleciona o tipo de redirecionamento
		if(tipoEndereco[0].equals("forward")){
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/"+tipoEndereco[1]);
			requestDispatcher.forward(request, response);
			
		}else if(tipoEndereco[0].equals("redirect")){
			response.sendRedirect(tipoEndereco[1]);
		}
		
	}

}
