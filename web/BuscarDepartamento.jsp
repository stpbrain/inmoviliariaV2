<%-- 
    Document   : BuscarDepartamento
    Created on : 24-11-2017, 2:30:54
    Author     : Chicos
--%>

<%@page import="Controlador.ControlArrendatario"%>
<%@page import="Modelo.Departamento"%>
<%@page import="Modelo.Edificio"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%HttpSession sesion = request.getSession(true);
    ArrayList<Departamento> dep = (ArrayList<Departamento>) sesion.getAttribute("comuna");
    ArrayList<Edificio> edif = (ArrayList<Edificio>) sesion.getAttribute("lista_edi");
 %>

<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <title>Buscar Departamento</title>
    </head>
    <body>
        
         <div class="container-fluid">
            <div style="background-image: url(img/banner.jpg); background-position: right; background-size: 100%; " class="jumbotron text-center">
                <h4 class="display-4" >Inmobiliaria <br> Adeudadito mas Feliz</h4>
            <h5 class="lead">El lugar donde su sueño se hace <h5 style="color: red">Realidad</h5></h5>
            </div>
        </div>
        
        <div class="container ">
            <form name="f2" method="POST" action="./ServletEdificio">
                <table class="text-center">
                <tr>
                    <td> Seleccione el edificio donde buscará su departamento </td>
                    <td>
                         <select name="id_edificio">
                               <%  
                               for (Edificio elem : edif) {
                               %>  <option  value="<%= elem.getId_edificio()%>" > <%= elem.getId_edificio() %> </option>                                   
                                   <% } %>                                    
                        </select>
                    </td>
                    <td><input type="submit" name="btn_buscar" value="Buscar"  class="btn btn-success" </td>
                </tr>
            </table>
        </form>
        </div>
<hr>
<div class="container ">
    <form method="POST" action="./ServletArrendatario" name="f3">   
                <table class="table container text-center table-striped table-bordered table-hover">
                    <tr>
                        
                        <th class="text-center">Codigo de Edificio </th>
                        <th class="text-center">Nombre del Edificio</th>
                        <th class="text-center">Número de Departamento</th>
                        <th class="text-center">Nombre del Residente</th>
                    </tr>
               <!-- </table> -->
            <% if(edif != null){for (Edificio e : edif) { %>
            <% if(dep != null){for (Departamento d: dep) { %>
            <!--<table class="table container text-center ">-->
                  
                    <tr class="info">
                         
                        <td><%=e.getId_edificio() %></td>
                    <input type="text" name="id_edificio" value="<%=e.getId_edificio() %>" style="display: none">
                        <td><%=e.getN_edifico()%></td>
                    <input type="text" name="nombre_edificio" value="<%=e.getN_edifico()%>" style="display: none">
                        <td><%=d.getNumero_d() %></td>
                    <input type="text" name="num_departamento" value="<%=d.getNumero_d() %>" style="display: none">                     
                        <td><%=d.getResidente()%></td>
                    <input type="text" name="residente" value="<%=d.getResidente()%>" style="display: none">
                     
                            <input type="submit" name="btn_editar" value="Editar" class="btn btn-warning">
                        </td>
                        </form>
                         </tr>
                   
                   
                
                         <%}}else {%> <%}%>
                </table>  

        </div>                                   
                                  
    </body>
</html>