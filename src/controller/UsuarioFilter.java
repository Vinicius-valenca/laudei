package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Pessoa;

//@WebFilter(urlPatterns = { "/*" })
public class UsuarioFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String path = ((HttpServletRequest) request).getRequestURI();
		
		if (path.matches(".*(css|jpg|png|gif|js)") || path.matches(".*(eot|svg|ttf|woff|woff2)") || path.matches(".*(bnk|ret|xml)")) {
			chain.doFilter(request, response);
			return;
		}

		else if (path.contains("/login.jsp") || path.contains("/Login")|| path.contains("/exames/") || path.contains("/validar")) {
			chain.doFilter(request, response);
			return;
		} else {

			HttpSession session = ((HttpServletRequest) request).getSession(true);
			
			Pessoa p = (Pessoa) session.getAttribute("user");
			if (p != null) {
				chain.doFilter(request, response);
				return;
			}
				
		}

		request.setAttribute("msg", "Voce precisa estar logado" );
		request.getRequestDispatcher("/login.jsp").forward(request, response);

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	

}