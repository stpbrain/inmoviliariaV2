<%-- 
    Document   : BuscaEdificio
    Created on : 22-nov-2017, 2:44:51
    Author     : papalominos
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="Servlet.ServletUsuario"%>
<%@page import="Servlet.ServletUsuario"%>
<%@page import="Controlador.ControlEdificio"%>
<%@page import="Modelo.Edificio"%>
<%@page import="Modelo.Comuna"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%HttpSession sesion = request.getSession(true);
    ArrayList<Comuna> com = (ArrayList<Comuna>) sesion.getAttribute("comuna");
    ArrayList<Edificio> lEdi = (ArrayList<Edificio>) sesion.getAttribute("lista_edi");
String control = "display:none";
 %>

<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <title>Buscar Edificios</title>
    </head>
    <body>
        
         <div class="container-fluid">
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
            <div style="background-image: url(img/banner.jpg); background-position: right; background-size: 100%; " class="jumbotron text-center">
                <h4 class="display-4"  >Inmobiliaria <br> Adeudadito mas Feliz</h4>
            <h5  class="lead">El lugar donde su sueño se hace <h5 style="color: white">Realidad</h5></h5>
            </div>
        </div>
        
        <div class="container ">
            <form name="f2" method="POST" action="./ServletEdificio">
                <table class="text-center">
                <tr>
                    <td> Ingrese comuna a Buscar </td>
                    <td>
                         <select name="comuna">
                               <%  
                               for (Comuna elem : com) {
                               %>  <option  value="<%= elem.getId() %>" > <%= elem.getN_comuna() %> </option>
                                   
                                   <% } %>
                                    
                                </select>
                    </td>
                    <td><input type="submit" name="btn_buscarA" value="Buscar"  class="btn btn-success" </td>
                    <td><input type="submit" name="btn_volver" value="Volver" class="btn btn-danger"</td>
                </tr>
            </table>
        </form>
        </div>
<hr>
<div class="container ">
    <form method="POST" action="./ServletEdificio" name="f3">   
                <table class="table container text-center table-striped table-bordered table-hover">
                    <tr>
                        
                        <th class="text-center"> Codigo de Edificio </th>
                        <th class="text-center">Nombre del Edificio</th>
                        <th class="text-center">Direccion del Edificio</th>
                        <th class="text-center">Comuna</th>
                        <th class="text-center">Posee Permiso</th>
                        <th class="text-center">Habilitar Permisos</th>
                        <th class="text-center">Editar Edificio</th>
                        
                    </tr>
               <!-- </table> -->
            <% if(lEdi != null){for (Edificio e : lEdi) { %>
            <!--<table class="table container text-center ">-->
                  
                    <tr class="info">
                         
                        <td><%=e.getId_edificio() %></td>
                    <input type="text" name="id" value="<%=e.getId_edificio() %>" style="display: none">
                        <td><%=e.getN_edifico()%></td>
                    <input type="text" name="nombre_l" value="<%=e.getN_edifico()%>" style="display: none">
                        <td><%=e.getDireccion() %></td>
                    <input type="text" name="direccion" value="<%=e.getDireccion() %>" style="display: none">    
                        <td><% ControlEdificio c = new ControlEdificio();
                        String comuna =c.TraeComuna(e.getId_comuna());
                        %><h6 style="color : blue"><%= comuna %></h6></td>
                    <input type="text" name="comuna" value="<%=e.getId_comuna() %>" style="display: none"> 
                      
                    <td><% if(e.getPosee_permiso() == 0)     
                        { control = "  "; %><h6 style="color: red ">No posee Permisos</h6> <%}
                          else {%><h6 style="color: green">Posee Permisos</h6> <% }
                        %></td>
                    <input type="text" name="permiso" value="<%=e.getPosee_permiso() %>" style="display: none">
                        <td> <input type="submit" name="btn_habilitar" value="Habilitar Permisos" class="btn btn-danger" style="<%= control %>" ></td>
                        <td>
                            <input type="submit" name="btn_editar" value="Editar" class="btn btn-warning">
                        </td>
                        </form>
                         </tr>
                   
                   
                
                         <%}}else {%> <%}%>
                </table>  

        </div>                                   
                                  
    </body>
</html>
