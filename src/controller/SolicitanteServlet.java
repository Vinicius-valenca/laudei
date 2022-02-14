package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Paciente;
import model.Pessoa;
import model.Solicitante;
import service.LoginService;
import service.SolicitanteService;


public class SolicitanteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			 
			 
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			SolicitanteService solicitanteService = new SolicitanteService();
			List<Solicitante> list =  solicitanteService.getListOfSolicitantes();
			
			System.out.println(list);
			

			out.print(gson.toJson(list));
			out.flush();
			out.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	
	
	
}