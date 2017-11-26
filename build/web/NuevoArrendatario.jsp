<%-- 
    Document   : CrearNuevoEdificio
    Created on : 20-nov-2017, 21:51:07
    Author     : Kathy
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="Servlet.ServletUsuario"%>
<%@page import="Modelo.Departamento"%>
<%@page import="Modelo.Edificio"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%HttpSession sesion = request.getSession(true);
    ArrayList<Edificio> dep = (ArrayList<Edificio>) sesion.getAttribute("id_edificio");  
 %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <title>Nuevo Arrendatario</title>      
        
    </head>
    <body>
        <div>

            <div class="container-fluid">
                <div style="background-image: url(img/banner.jpg); background-position: right; background-size: 100%; " class="jumbotron text-center">
                    <h4 class="display-4" >Inmobiliaria <br> Adeudadito mas Feliz</h4>
                    <h5 class="lead">El lugar donde su sueño se hace <h5 style="color: red">Realidad</h5></h5>
                </div>
            </div>
            <div class=" container text-center " > 
                <nav class="navbar navbar-toggleable-md navbar-light bg-faded navbar-inverse bg-primary">
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
                </button>
                    <%
                        if(session.getAttribute(ServletUsuario.USUARIO_ACTUAL) != null) {
                            Usuario actual = (Usuario) session.getAttribute(ServletUsuario.USUARIO_ACTUAL);
                    %>
                    <div style="position: absolute; right: 20px " >
                        <a class="navbar-brand" href="usuario?action=logout">Adios <%=actual.getN_usuario()%> (Cerrar)</a>
                    </div>   
                    <a class="navbar-brand" href="#">Bienvenido <%=actual.getN_usuario()%> </a>
                    <%
                        } else {
                    %>  
                        <script>location.href="usuario?action=logout";</script>
                    <%        
                        }
                    %>
                
                
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                  <div class="navbar-nav">
                    
               
                  </div>
                </div>
              </nav>
                <form action="./ServletArrendatario" method="POST" >
                    <table class="table-active ">
                        <th colspan="2" class="text-center">
                            <h3>Nuevo Arrendatario</h3><br>
                            <h4>Ingrese los datos necesarios para registrar el nuevo arrendatario</h4>
                        </th>
                        <tr>                        
                            <td><h5>Condominio:</h5></td>
                            <td>
                                <select class="form-control" name="id_edificio">
                                    <%
                                        for (Edificio elem : dep) {
                                    %>  <option  value="<%= elem.getId_edificio()%>" > <%= elem.getN_edifico()%> </option>                                   
                                    <% }%>                                    
                                </select>
                            </td>
                        </tr>
                        <tr>   
                            <td>
                                <h5>Número de departamento:</h5>
                            </td>
                            <td>
                                <input type="text" name="num_dpto" class="form-control"
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <h5>Nombre del residente:</h5>
                            </td>
                            <td>
                                <input type="text" name="txtResidente" class="form-control"
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" class="text-center">
                                <input type="submit" name="btn_guardar" value="Confirmar arrendatario" class="btn btn-success">
                            </td>
                        </tr>
                    </table>
                </form>
                <%
                    if(session.getAttribute(ServletUsuario.MENSAJE) != null) {
                %>
                <div class="row">
                     <div class="col-sm-12 col-md-10 col-md-offset-1">
                        <div class='alert alert-info'><strong>Atención!</strong> <%=session.getAttribute(ServletUsuario.MENSAJE)%></div>
                     </div>
                </div>
                <%
                    } else {
                %><!-- NO HAY MENSAJES EN SESSION --><%        
                    }
                    session.setAttribute(ServletUsuario.MENSAJE, null);
                %>
                <br/>
                <form action="./ServletPrincipal" method="POST" name="arr">
                    <input type="submit" name="btn_volver" value="Volver" class="btn btn-danger">
                </form>
            </div>
        </div>
    </body>
</html>