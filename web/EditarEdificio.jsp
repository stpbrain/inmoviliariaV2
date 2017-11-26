<%-- 
    Document   : EditarEdificio
    Created on : 22-nov-2017, 10:02:40
    Author     : papalominos
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="Servlet.ServletUsuario"%>
<%@page import="Modelo.Edificio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
HttpSession sesion = request.getSession(true);
Edificio edi = (Edificio) sesion.getAttribute("mod_edi_ori");




%>
<!DOCTYPE html>
<html>
    <head>
         <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <div class="container-fluid">
            <div style="background-image: url(img/banner.jpg); background-position: right; background-size: 100%; " class="jumbotron text-center">
                <h4 class="display-4" >Inmobiliaria <br> Adeudadito mas Feliz</h4>
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
            
            <form action="./ServletEdificio" method="POST" name="f4">
            <table class="table container text-center table-striped table-bordered table-hover">
                <tr>
                    <td colspan="2"><h3>Portal de Modificacion </h3></td>
                </tr>
                <tr>
                    <td>El codigo del edificio es : </td>
                    <td><input type="text" name="codigo" value="<%= edi.getId_edificio()%>" class="form-control" readonly="readonly"> </td>
                </tr>
                <tr>
                    <td>Ingrese nuevo nombre de Edificio:</td>
                    <td><input type="text" name="nombre_n" placeholder="el nombre actual es : <%=edi.getN_edifico()%>" class="form-control" ></td>
                </tr>
                <tr>
                    <td>Ingrese nueva Direccion :</td>
                    <td><input type="text" name="direccion" placeholder="La direccion es : <%=edi.getDireccion()%>"class="form-control"> </td>
                    
                </tr>
                <tr>
                    <td>Estado actual del permiso : <% if(edi.getPosee_permiso() == 0)     
                        { %><h6 style="color: red ">No posee Permisos</h6> <%}
                          else {%><h6 style="color: green">Posee Permisos</h6> <% }
                        %></td>
                    
                     <td>
                            <select name="permiso">
                                <option value="2">Cambiar a ...</option>
                                <option value="0"> No posee Permiso</option>
                                <option value="1"> Si posee Permiso</option>
                            </select>
                        </td>
                </tr>
                <tr>
                    <td colspan="2" >
                        <input type="submit" name="btn_guardar_editado" value="Guardar" class="btn btn-success">
                        <input type="submit" name="btn_volver" value="Volver" class="btn btn-danger">
                    </td>
                </tr>
            </table>
        </form>
        </div>
        
    </body>
</html>
