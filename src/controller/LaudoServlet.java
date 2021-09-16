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

import model.Exame;
import model.Pessoa;
import service.ExameService;
import service.RegisterService;

public class LaudoServlet extends HttpServlet {

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

			if (url.equalsIgnoreCase("/salvarLaudo")) {
				salvarLaudo(request, response);

			} else if (url.equalsIgnoreCase("/validarLaudo")) {
				validarLaudo(request, response);

			}else if (url.equalsIgnoreCase("/validar")) {
				validar(request, response);

			}else {
				response.sendRedirect("/");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void salvarLaudo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean resposta = false;
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		RegisterService registerService = new RegisterService();
		ExameService exameService = new ExameService();

		try {

			
			System.out.println("idPessoa" + request.getParameter("idPessoa"));
			System.out.println("id" + request.getParameter("id"));
			String idExame = request.getParameter("id");
			String id = request.getParameter("idPessoa");
			String laudo = request.getParameter("laudo");
			String obs = request.getParameter("obs");
			Pessoa p = null;
			
			
			p = registerService.isUserExists(Long.valueOf(id));
			
		
			Exame exame = null;
			exame = exameService.isExameExists(Long.valueOf(idExame));
			System.out.println(exame);
			System.out.println("laudo "+laudo);
			if(p.getTpPerfil().equals("2")){
				exame.setObs(obs);
				System.out.println("obs "+obs);
			}else{
				exame.setLaudo(laudo);
				exame.setDtLaudo(new java.sql.Date(System.currentTimeMillis()));
				exame.setObs(obs);
				System.out.println("obs "+obs);

				exame.setNomeMedico(p);
			}
			

			resposta = exameService.register(exame);

			System.out.println("Salvou?" + resposta);

			out.print(gson.toJson(resposta));

			out.flush();
			out.close();

		} catch (Exception ex) {

			// ex.printStackTrace();
			out.print(gson.toJson(resposta));
			out.flush();
			out.close();

		}
	}
	
	public void validarLaudo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8,application/json");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		ExameService exameService = new ExameService();

		try {

			
			System.out.println("code" + request.getParameter("code"));
			
			String code = request.getParameter("code");
			
		
			Exame exame = null;
			exame = exameService.isExameExists(code);
			

			System.out.println("exame " + exame);
			
			
			out.print(gson.toJson(exame));
			out.flush();
			out.close();

			
		} catch (Exception ex) {

			// ex.printStackTrace();
			out.print(gson.toJson(null));
			out.flush();
			out.close();

		}
	}
	
	public void validar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	try {

		request.getRequestDispatcher("validar.jsp").forward(request, response);

	} catch (Exception ex) {
		ex.printStackTrace();
	}
	}

}