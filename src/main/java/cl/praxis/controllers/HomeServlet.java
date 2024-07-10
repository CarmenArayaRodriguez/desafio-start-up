package cl.praxis.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// Obtiene la sesión sin crear una nueva
		HttpSession session = request.getSession(false); 
		if (session != null && session.getAttribute("usuario") != null) {
			request.getRequestDispatcher("/view/home.jsp").forward(request, response);
		} else {
			// Redirige a login si no hay sesión
			response.sendRedirect(request.getContextPath() + "/view/login.jsp"); 
		}
	}
}
