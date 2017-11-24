<%-- 
    Document   : index
    Created on : 19-nov-2017, 23:34:08
    Author     : papalominos
--%>


<%@page import="Servlet.ServletUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <style>
            body{
                /*
                background: #00589F;
                
                filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#00589F', endColorstr='#0073CF', GradientType=0);
                background: -webkit-linear-gradient(to bottom, #00589F 50%, #0073CF) !important;
                background: -moz-linear-gradient(to bottom, #00589F 50%, #0073CF) !important;
                background: -ms-linear-gradient(to bottom, #00589F 50%, #0073CF) !important;
                background: -o-linear-gradient(to bottom, #00589F 50%, #0073CF) !important;
                background: linear-gradient(to bottom, #00589F 50%, #0073CF) !important;
                color: white;
                */
              }

              div.well{
                height: 250px;
              } 

              .Absolute-Center {
                margin: auto;
                position: absolute;
                top: 0; left: 0; bottom: 0; right: 0;
              }

              .Absolute-Center.is-Responsive {
                width: 70%; 
                height: 50%;
                min-width: 200px;
                max-width: 500px;
                padding: 40px;
              }

              #logo-container{
                margin: auto;
                margin-bottom: 10px;
                width:500px;
                height:30px;
              }
        </style>
        <title>Login</title>
    </head>
    <body>
        
        <div class="container">
            <br/>
            <h1>Bienvenido!</h1>
            <hr/>
            <br/>
            <br/>
            <br/>
            <div class="row">
              <div class="Absolute-Center is-Responsive">
                <div id="logo-container"></div>
                <div class="col-sm-12 col-md-10 col-md-offset-1">
                  <form action="./usuario" id="loginForm" method="POST">
                    <input type="hidden" name="action" value="login"/>
                    <div class="form-group input-group">
                      <span class="input-group-addon"><i class="fa fa-user"></i></span>
                      <input class="form-control" type="text" name='usuario' placeholder="usuario" maxlength="50" required/>          
                    </div>
                    <div class="form-group input-group">
                      <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                      <input class="form-control" type="password" name='password' placeholder="contraseña" maxlength="50" required/>     
                    </div>
                     <div class="row">
                         <div class="col-sm-6 col-md-5 col-md-offset-1">
                            <button type="submit" class="btn btn-primary">Iniciar Sesión</button>
                         </div>
                         <div class="col-sm-6 col-md-5 col-md-offset-1 text-right">
                            <a href="RegistrarUsuario.jsp" class="btn btn-secondary">Crear Cuenta</a>
                         </div>
                    </div>
                    <br/>
                    <%
                        //HttpSession session = request.getSession();
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
