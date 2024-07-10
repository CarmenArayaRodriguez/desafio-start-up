<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="cl.praxis.models.dto.UsuarioDTO" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bienvenido</title>
</head>
<body>
    <%
       
        UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
        if (usuario != null) {
    %>
        <h1>Bienvenido, <%= usuario.getNombre() %>!</h1>
        <p>Has accedido al sistema con el correo <%= usuario.getCorreo() %>.</p>
    <%
        } else {
            response.sendRedirect(request.getContextPath() + "/view/login.jsp");
        }
    %>
</body>
</html>
