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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pessoa;

//@WebFilter(urlPatterns = { "/*" })
public class UsuarioFilter implements Filter {
	
	private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
	  private static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
	  private static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
	  private static final String ACCESS_CONTROL_EXPOSE_HEADERS = "Access-Control-Expose-Headers";
	  private static final String ALL = "*";
	  private static final String ALLOWED_METHODS = "GET, POST";
	  private static final String ALLOWED_HEADERS =
	      "origin, content-type, accept, Authorization, x-requested-with";
	  private static final String EXPOSE_HEADERS = "TEST";

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		 HttpServletResponse sresponse = (HttpServletResponse) response;
		    sresponse.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, ALL);
		    sresponse.setHeader(ACCESS_CONTROL_ALLOW_METHODS, ALLOWED_METHODS);
		    sresponse.setHeader(ACCESS_CONTROL_ALLOW_HEADERS, ALLOWED_HEADERS);
		    sresponse.setHeader(ACCESS_CONTROL_EXPOSE_HEADERS, EXPOSE_HEADERS);
		    

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