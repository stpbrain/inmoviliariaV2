<%-- 
    Document   : CrearNuevoEdificio
    Created on : 20-nov-2017, 21:51:07
    Author     : papalominos
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Comuna"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%HttpSession sesion = request.getSession(true);
    ArrayList<Comuna> com = (ArrayList<Comuna>) sesion.getAttribute("comuna");  
 %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <title>Nuevo Edificio</title>
        
        
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
                <form action="./ServletEdificio" name="formedi" method="POST">
                <table class="table-active ">
                    <th colspan="2" class="text-center">
                        <h3>Ingrese los datos para un nuevo Edificio</h3>
                    </th>
                    <tr>
                        
                        <td><h5>Ingrese ID del Edificio :</h5></td>
                        <td><input type="text" name="id_edificio" class="form-control" maxlength="4" placeholder="Ingrese Codigo de 4 digitos" </td>
                    </tr>
                    <tr>   
                        <td>
                            <h5>Ingrese Nombre del Edificio :</h5>
                        </td>
                        <td>
                            <input type="text" name="n_edificio" class="form-control"
                        </td>
                        
                    </tr>
                    <tr>
                        <td>
                            <h5>Ingrese Direccion del Edificio :</h5>
                        </td>
                        <td>
                            <input type="text" name="direccion" class="form-control"
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h5> Ingrese comuna del Edificio:</h5>
                        </td>
                        <td>
                             <select name="comuna">
                               <%  
                               for (Comuna elem : com) {
                               %>  <option  value="<%= elem.getId() %>" > <%= elem.getN_comuna() %> </option>
                                   
                                   <% } %>
                                    
                                </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                          <h5>  Posee Permiso Municipal :</h5>
                        </td>
                        <td>
                            <select name="permiso">
                                <option value="0"> No posee Permiso</option>
                                <option value="1"> Si posee Permiso</option>
                            </select>
                        </td>
                        
                    </tr>
                    <tr>
                        <td colspan="2" class="text-center">
                            <input type="submit" name="btn_guardar" value="Guardar Edificio" class="btn btn-success">
                         <form action="./ServletEdificio" method="POST" name="f3">
                              </form>
                        
                            <input type="submit" name="btn_volver" value="Volver" class="btn btn-danger">
                       
                        </td>
                        
                   
                    </form>
                    </tr>
                </table>
               
            </div>
            
            
        </div>
        
        
    </body>
</html>

