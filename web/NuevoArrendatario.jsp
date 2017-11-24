<%-- 
    Document   : CrearNuevoEdificio
    Created on : 20-nov-2017, 21:51:07
    Author     : Kathy
--%>

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
                
                <table class="table-active ">
                    <form action="./ServletArrendatario" method="POST" name="formArrendatario">
                    <th colspan="2" class="text-center">
                    <h3>Nuevo Arrendatario</h3><br>
                    <h4>Ingrese los datos necesarios para registrar el nuevo arrendatario</h4>
                        
                    </th>
                    
                    <tr>                        
                        <td><h5>Condominio:</h5></td>
                        <td>
                            <select name="id_edificio">
                               <%  
                               for (Edificio elem : dep) {
                               %>  <option  value="<%= elem.getId_edificio()%>" > <%= elem.getN_edifico() %> </option>                                   
                                   <% } %>                                    
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
        </form>
                    <form action="./ServletPrincipal" method="POST" name="arr">
                        
                            <input type="submit" name="btn_volver" value="Volver" class="btn btn-danger">
                       </form>
                        </td>
                        
                   
                    </tr>
                </table>
         </form>

            </div>
            
            
        </div>
        
        
    </body>
</html>