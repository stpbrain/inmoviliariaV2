<%-- 
    Document   : AdminCentral
    Created on : 20-nov-2017, 20:04:55
    Author     : papalominos
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="Servlet.ServletUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <title>Administracion</title>
    </head>
    <body>
        <div class="container-fluid">
            <div style="background-image: url(img/banner.jpg); background-position: right; background-size: 100%; " class="jumbotron text-center">
              <h4 class="display-4">Inmobiliaria <br> Adeudadito mas Feliz</h4>
            <h5 class="lead">El lugar donde su sueño se hace <h5 style="color: white">Realidad</h5></h5>
        </div>
        </div>
        <div class="container">
            
            <nav class="navbar navbar-toggleable-md navbar-light bg-faded navbar-inverse bg-primary">
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
                </button>
                    <%
                        if(session.getAttribute(ServletUsuario.USUARIO_ACTUAL) != null) {
                            Usuario actual = (Usuario) session.getAttribute(ServletUsuario.USUARIO_ACTUAL);
                    %>
                        <a class="navbar-brand" href="usuario?action=logout"><%=actual.getN_usuario()%> (Cerrar)</a>
                    <%
                        } else {
                    %>  
                        <script>location.href="usuario?action=logout";</script>
                    <%        
                        }
                    %>
                
                <a class="navbar-brand" href="#">Navbar</a>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                  <div class="navbar-nav">
                    <a class="nav-item nav-link active" href="#">Home <span class="sr-only">(current)</span></a>
               
                  </div>
                </div>
              </nav>
            <form action="./ServletPrincipal" name="fom1" method="POST">
            <table class="table text-center">
                <tr>
                    <td> <img src="img/nuevoEdificio.jpg" width="120" height="120"> </td>
                    <td><img src="img/BuscarEdificio.jpg" width="120" height="120"></td>
                    <td><img src="img/arriendo.jpg" width="120" height="120"></td>
                    <td><img src="img/buscar_departamentos.jpg" width="120" height="120"></td>
                    <td><img src="img/user.jpg" width="120" height="120"></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="btn_nEdificio"  value="Crear nuevo Edificio" class="btn btn-info">
                    </td>
                    <td>
                        <input type="submit" name="btn_buscarEdi"  value="Buscar Edificio" class="btn btn-success">
                    </td>
                    <td>
                        <input type="submit" name="btn_Ingresa_Departamento"  value="Ingresar Departamento" class="btn btn-danger">
                    </td>
                    <td>
                        <input type="submit" name="btn_Buscar_Departamento"  value="Buscar Departamento" class="btn btn-primary">
                    </td>
                    <td>
                        <input type="submit" name="btn_usuarios"  value="Usuarios" class="btn btn-warning">
                    </td>
                    </form>
                    
                </tr>
                
            </table>
            </form>
        </div>
        
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/moment.min.js"></script>
    </body>
</html>
