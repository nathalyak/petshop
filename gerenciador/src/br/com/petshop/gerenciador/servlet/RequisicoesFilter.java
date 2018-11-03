package br.com.petshop.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petshop.gerenciador.acoes.Acao;

/**
 * Servlet Filter implementation class RequisicoesFilter
 */

public class RequisicoesFilter implements Filter {

	public void doFilter(ServletRequest filterRequest, ServletResponse filterResponse, FilterChain chain) throws IOException, ServletException {
		System.out.println("filtroRequisicoes");
		HttpServletRequest request = (HttpServletRequest) filterRequest;
		HttpServletResponse response = (HttpServletResponse) filterResponse;
		//getParameter para a ação que deve ser tomada
		String acao = request.getParameter("acao");
		String pacote = request.getParameter("pacote");
		if(pacote==null)pacote="";
		String nomeClasse ="br.com.petshop.gerenciador.acoes."+pacote+acao;
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
	
		//Armazena caminho e tipo
		String[] tipoEndereco =nomePagina.split(":");
		String caminhoPagina=pacote.replace( "." , "");
		//seleciona o tipo de redirecionamento
		if(tipoEndereco[0].equals("forward")){
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/"+caminhoPagina+"/"+tipoEndereco[1]);
			requestDispatcher.forward(request, response);
			
		}else if(tipoEndereco[0].equals("redirect")){
			response.sendRedirect(tipoEndereco[1]);
		}
		
	
	}


}
