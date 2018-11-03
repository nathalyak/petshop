package br.com.petshop.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest filterRequest, ServletResponse filterResponse, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("filtroLogin");
		//converte o request e response para uma impl. HttpServletRequest
		HttpServletRequest request = (HttpServletRequest) filterRequest;
		HttpServletResponse response = (HttpServletResponse) filterResponse;
		
		//verifica ação
		String acao = request.getParameter("acao");
		
		//verifica login
		HttpSession sessao = request.getSession();
		boolean acaoLogin = !(acao.equals("InicioLogin")||acao.equals("Login"));
		boolean usuarioDeslogado = sessao.getAttribute("usuarioLogado")==null;
		
		if(acaoLogin&&usuarioDeslogado){
			response.sendRedirect("paginas?acao=InicioLogin");
			System.out.println("Usuário não logado");
			return;
		}else
			System.out.println("usuario:"+sessao.getAttribute("usuarioLogado"));
		
		chain.doFilter(request, response);
	}

}
