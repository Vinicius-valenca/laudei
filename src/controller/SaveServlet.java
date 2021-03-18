package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.google.gson.Gson;

import model.Pessoa;
import service.RegisterService;



public class SaveServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		option(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		option(request, response);

	}

	protected void option(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String url = request.getServletPath();

			if (url.equalsIgnoreCase("/SaveServlet")) {
				save(request, response);

			} else if (url.equalsIgnoreCase("/DeleteServlet")) {
				delete(request, response);

			}else {
				response.sendRedirect("/");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean resposta = false;
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		
		try {
			 
			 
			
			//LoginService loginService = new LoginService();
			//List<Pessoa> list =  loginService.getListOfPessoa();
			//System.out.println(list);
			System.out.println("id"+request.getParameter("id"));
			String id = request.getParameter("id");
			 Pessoa p = new Pessoa();
			 if(id!="") {
			 p.setId(Long.valueOf(id));
			 }
			 p.setNome_completo(request.getParameter("nome_completo"));
				p.setEmail(request.getParameter("email").toLowerCase());
				
				p.setCpf(request.getParameter("cpfcnpj"));
				
				
			
				
				
				
				
				
				p.setAnotacao(request.getParameter("anotacao"));
				

				
				p.setTelefone(request.getParameter("telefone"));

				p.setCelular(request.getParameter("celular"));

				
				p.setEndereco(request.getParameter("endereco"));
				p.setCep(request.getParameter("cep"));
				p.setNumero(request.getParameter("numero"));
				p.setBairro(request.getParameter("bairro"));
				p.setCidade(request.getParameter("cidade"));
				p.setEstado(request.getParameter("estado"));
				p.setComplemento(request.getParameter("complemento"));
				
				RegisterService registerService = new RegisterService();
				
				resposta = registerService.register(p);
				System.out.println("Salvou?" + resposta );
				
				
			out.print(gson.toJson(resposta));
			
			
			out.flush();
			out.close();

		} catch (Exception ex) {
			
			//ex.printStackTrace();
			out.print(gson.toJson(resposta));
			out.flush();
			out.close();
			
		}
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean resposta = false;
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		
		try {
			 
			 
			
			//LoginService loginService = new LoginService();
			//List<Pessoa> list =  loginService.getListOfPessoa();
			//System.out.println(list);
			System.out.println("id"+request.getParameter("id"));
			String id = request.getParameter("id");
			 Pessoa p = new Pessoa();
			 
			 p.setId(Long.valueOf(id));
			 
			 
				
				RegisterService registerService = new RegisterService();
				
				resposta = registerService.delete(p);
				
				System.out.println("Deletou?" + resposta );
				
				
			out.print(gson.toJson(resposta));
			
			
			out.flush();
			out.close();

		} catch (Exception ex) {
			
			//ex.printStackTrace();
			out.print(gson.toJson(resposta));
			out.flush();
			out.close();
			
		}
	}
	
	
	
}