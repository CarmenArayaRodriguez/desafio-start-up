package cl.praxis.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.praxis.models.dto.UsuarioDTO;
import cl.praxis.models.services.UsuarioService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private UsuarioService usuarioService = new UsuarioService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	 request.setCharacterEncoding("UTF-8"); 
    	 response.setCharacterEncoding("UTF-8");
    	    
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");

        UsuarioDTO usuario = usuarioService.login(correo, password);

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            response.sendRedirect(request.getContextPath() + "/view/home.jsp");
        } else {
            request.setAttribute("error", "Credenciales inválidas");
            request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        }
    }
}
