<%-- 
    Document   : BuscarDepartamento
    Created on : 24-11-2017, 2:30:54
    Author     : Chicos
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="Servlet.ServletUsuario"%>
<%@page import="Servlet.ServletEdificio"%>
<%@page import="Servlet.ServletPrincipal"%>
<%@page import="java.util.List"%>
<%@page import="Controlador.ControlArrendatario"%>
<%@page import="Modelo.Departamento"%>
<%@page import="Modelo.Edificio"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Departamento> listaDepartamentos = (ArrayList<Departamento>) session.getAttribute(ServletEdificio.LISTA_DEPARTAMENTOS);
    List<Edificio> listaEdificios = (ArrayList<Edificio>) session.getAttribute(ServletPrincipal.LISTA_EDIFICIOS);
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
        <nav class="navbar navbar-toggleable-md navbar-light bg-faded navbar-inverse bg-primary">
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <%
                if (session.getAttribute(ServletUsuario.USUARIO_ACTUAL) != null) {
                    Usuario actual = (Usuario) session.getAttribute(ServletUsuario.USUARIO_ACTUAL);
            %>
            <div style="position: absolute; right: 20px " >
                <a class="navbar-brand" href="usuario?action=logout">Adios <%=actual.getN_usuario()%> (Cerrar)</a>
            </div>   
            <a class="navbar-brand" href="#">Bienvenido <%=actual.getN_usuario()%> </a>
            <%
            } else {
            %>  
            <script>location.href = "usuario?action=logout";</script>
            <%
                }
            %>


            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">


                </div>
            </div>
        </nav>
        <div class="container ">
            <form method="POST" action="./ServletEdificio">
                <table class="text-center">
                    <tr>
                        <td> Seleccione el edificio donde buscará su departamento </td>
                        <td>
                            <select class="form-control" name="id_edificio">
                                <%
                                    for (Edificio elem : listaEdificios) {
                                %>  
                                <option value="<%=elem.getId_edificio()%>"><%=elem.getN_edifico()%></option>                                   
                                <%
                                    }
                                %>                                    
                            </select>
                        </td>
                        <td><input type="submit" name="btn_buscar" value="Buscar"  class="btn btn-success" </td>
                    </tr>
                </table>
            </form>
        </div>
        <hr>
        <div class="container ">
            <form method="POST" action="./ServletArrendatario" id="form1">  
                <input type="hidden" id="hdIdDepartamento" name="idDepartamento" value="">
                <input type="hidden" id="hdResidente" name="residente" value="">
                <input type="hidden" name="btn_editar" value="editar!">  
                <%
                    if (listaDepartamentos != null) {
                %>
                <table class="table container text-center table-striped table-bordered table-hover">
                    <tr>

                        <th class="text-center">Codigo de Edificio </th>
                        <th class="text-center">Nombre del Edificio</th>
                        <th class="text-center">Número de Departamento</th>
                        <th class="text-center">Nombre del Residente</th>
                        <th class="text-center">Editar</th>
                    </tr>
                    <!-- </table> -->
                    <%
                        for (Departamento d : listaDepartamentos) {
                    %>
                    <tr>

                        <td><%=d.getId_edificio()%></td>
                        <td>
                            <%
                                String nombreEdificio = "";
                                for (Edificio elem : listaEdificios) {
                                    if (elem.getId_edificio().equals(d.getId_edificio())) {
                                        nombreEdificio = elem.getN_edifico();
                                    }
                                }
                            %>
                            <%=nombreEdificio%>
                        </td>
                        <td><%=d.getNumero_d()%></td>                     
                        <td><input type="text" id="txtResidente<%=d.getId_departamento()%>" value="<%=d.getResidente()%>"></td>
                        <td>
                            <input type="button" value="Editar" class="btn btn-primary" 
                                   onclick="enviar(txtResidente<%=d.getId_departamento()%>, <%=d.getId_departamento()%>)">
                        </td>
                    </tr>        
                    <%
                        }
                    %>        
                </table>  
                <%
                    }
                %>  
            </form>
            <%
                if (session.getAttribute(ServletUsuario.MENSAJE) != null) {
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
        </div>        
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/moment.min.js"></script>
        <script type='text/javascript'>

                               //option A
                               function enviar(residente, idDepartamento) {

                                   console.log(idDepartamento);
                                   console.log(residente.value);
                                   $("#hdResidente").val(residente.value);
                                   $("#hdIdDepartamento").val(idDepartamento);
                                   $("#form1").submit();
                               }
        </script>                            
    </body>
</html>