<%-- 
    Document   : Usuarios
    Created on : 24-nov-2017, 2:47:53
    Author     : papalominos
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession(true);
    ArrayList<Usuario> luser = (ArrayList<Usuario>) sesion.getAttribute("listUsuario"); 
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
         
        <title>Listar Usuarios</title>
    </head>
    <body>
        <div class="container-fluid">
            <div style="background-image: url(img/banner.jpg); background-position: right; background-size: 100%; " class="jumbotron text-center">
                <h4 class="display-4" >Inmobiliaria <br> Adeudadito mas Feliz</h4>
            <h5 class="lead">El lugar donde su sueño se hace <h5 style="color: red">Realidad</h5></h5>
        </div>
        </div>
        
        <div class="container text-center row">
            <table class="table-active text-center ">
                <tr>
                    <th>RUT</th>
                    <th>Usuarios</th>
                </tr>
                <% if(luser != null){for (Usuario e : luser) { %>
                <tr>
                    <td><%= e.getRut() %></td>
                    <td><%= e.getN_usuario() %> </td>
                </tr>
                  <%}}else {%> <%}%>
                  <tr>
                  <form action="./ServletEdificio" method="POST" name="fr" >
                      <td><input type="submit" name="btn_volver" value="Volver" class="btn btn-danger"</td>
                  </form>
                  </tr>
            </table>
            
        </div>
    </body>
</html>
