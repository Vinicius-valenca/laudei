package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pessoa;
import model.User;
import service.LoginService;
import service.RegisterService;

public class LoginServlet extends HttpServlet {

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
			
			System.out.println(url);
			
			
			if (url.equalsIgnoreCase("/Login")) {
				login(request, response);

			} else if (url.equalsIgnoreCase("/Logout")) {
				logout(request, response);

			} else if (url.equalsIgnoreCase("/Update")) {
				update(request, response);

			} else {
				response.sendRedirect("/");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");

		HttpSession session = request.getSession(true);

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		LoginService loginService = new LoginService();
		boolean result = loginService.authenticateUser(email, password);

		if (result) {
			Pessoa p = loginService.getPessoaByEmail(email);

			session.setAttribute("user", p);
			session.setAttribute("userId", p.getEmail());
			session.setAttribute("id", p.getId());
			response.getWriter().write("True");
		} else {
			response.getWriter().write("False");
		}
	}

	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		request.getSession().invalidate();
		response.getWriter().write("True");
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		User user = (User) session.getAttribute("user");
		Long id = Long.valueOf(request.getParameter("idUser"));
		String userId = request.getParameter("userId");
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");

		
		if (user.getId().equals(id)  && user.getPassword().equals(oldpassword)) {

			user.setPassword(newpassword);
			user.setUserId(userId);
			RegisterService registerService = new RegisterService();
			
			Boolean resposta = registerService.register(user);
			System.out.println("Salvou?" + resposta );
			session.setAttribute("user", user);
			session.setAttribute("userId", user.getUserId());
			response.getWriter().write("True");
		} else {
			response.getWriter().write("False");
		}
	}

}