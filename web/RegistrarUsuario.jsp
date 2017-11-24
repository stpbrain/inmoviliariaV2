<%-- 
    Document   : RegistrarUsuario
    Created on : 23-11-2017, 1:59:49
    Author     : pc-ccarreno
--%>

<%@page import="Servlet.ServletUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Usuario</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="css/font-awesome.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <br/>
            <h1>Registrar Usuario!</h1>
            <hr/>
            <br/>
            <br/>
            <br/>
            <div class="row">
              <div class="Absolute-Center is-Responsive">
                <div id="logo-container"></div>
                <div class="col-sm-12 col-md-10 col-md-offset-1">
                    <form action="./usuario" id="loginForm" method="POST">
                    <input type="hidden" name="action" value="registrar"/>
                    <div class="form-group input-group">
                      <span class="input-group-addon"><i class="fa fa-user"></i></span>
                      <input class="form-control" type="text" name='rut' placeholder="12345678-K" maxlength="10" required/>          
                    </div>
                    <div class="form-group input-group">
                      <span class="input-group-addon"><i class="fa fa-user"></i></span>
                      <input class="form-control" type="text" name='usuario' placeholder="usuario" maxlength="50" required/>          
                    </div>
                    <div class="form-group input-group">
                      <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                      <input class="form-control" type="password" name='password' placeholder="contraseña" maxlength="50" required/>     
                    </div>
                    <div class="form-group text-right">
                      <button type="submit" class="btn btn-primary">Crear Cuenta</button>
                    </div>
                    
                    <%
                        if(session.getAttribute(ServletUsuario.MENSAJE) != null) {
                    %>
                    <div class="row">
                         <div class="col-sm-12 col-md-10 col-md-offset-1">
                            <div class='alert alert-danger'><strong>Error!</strong> <%=session.getAttribute(ServletUsuario.MENSAJE)%></div>
                         </div>
                    </div>
                    <%
                        } else {
                    %><!-- NO HAY MENSAJES EN SESSION --><%        
                        }
                        session.setAttribute(ServletUsuario.MENSAJE, null);
                    %>
                  </form>        
                </div>  
              </div>    
            </div>
        </div>
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/moment.min.js"></script>
    </body>
</html>
