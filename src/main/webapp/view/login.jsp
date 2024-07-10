<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-3">Login de usuario</h1>
        <form action="${pageContext.request.contextPath}/LoginServlet" method="post" class="needs-validation" novalidate>
            <div class="form-group">
                Correo: <input type="email" name="correo" class="form-control" required />
            </div>
            <div class="form-group">
                Contraseña: <input type="password" name="password" class="form-control" required />
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
        </form>
        <%
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
            <div class="alert alert-danger mt-3"><%= error %></div>
        <%
            }
        %>
    </div>
</body>
</html>
