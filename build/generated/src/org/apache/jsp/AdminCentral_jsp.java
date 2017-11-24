package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Usuario;
import Servlet.ServletUsuario;

public final class AdminCentral_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("         <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">\r\n");
      out.write("        <title>Administracion</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("            <div style=\"background-image: url(img/banner.jpg); background-position: right; background-size: 100%; \" class=\"jumbotron text-center\">\r\n");
      out.write("              <h4 class=\"display-4\">Inmobiliaria <br> Adeudadito mas Feliz</h4>\r\n");
      out.write("            <h5 class=\"lead\">El lugar donde su sueño se hace <h5 style=\"color: white\">Realidad</h5></h5>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            \r\n");
      out.write("            <nav class=\"navbar navbar-toggleable-md navbar-light bg-faded navbar-inverse bg-primary\">\r\n");
      out.write("                <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNavAltMarkup\" aria-controls=\"navbarNavAltMarkup\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("                  <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("                </button>\r\n");
      out.write("                    ");

                        if(session.getAttribute(ServletUsuario.USUARIO_ACTUAL) != null) {
                            Usuario actual = (Usuario) session.getAttribute(ServletUsuario.USUARIO_ACTUAL);
                    
      out.write("\r\n");
      out.write("                        <a class=\"navbar-brand\" href=\"usuario?action=logout\">");
      out.print(actual.getN_usuario());
      out.write(" (Cerrar)</a>\r\n");
      out.write("                    ");

                        } else {
                    
      out.write("  \r\n");
      out.write("                        <script>location.href=\"usuario?action=logout\";</script>\r\n");
      out.write("                    ");
        
                        }
                    
      out.write("\r\n");
      out.write("                \r\n");
      out.write("                <a class=\"navbar-brand\" href=\"#\">Navbar</a>\r\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbarNavAltMarkup\">\r\n");
      out.write("                  <div class=\"navbar-nav\">\r\n");
      out.write("                    <a class=\"nav-item nav-link active\" href=\"#\">Home <span class=\"sr-only\">(current)</span></a>\r\n");
      out.write("               \r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("              </nav>\r\n");
      out.write("            <form action=\"./ServletPrincipal\" name=\"fom1\" method=\"POST\">\r\n");
      out.write("            <table class=\"table text-center\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td> <img src=\"img/nuevoEdificio.jpg\" width=\"120\" height=\"120\"> </td>\r\n");
      out.write("                    <td><img src=\"img/BuscarEdificio.jpg\" width=\"120\" height=\"120\"></td>\r\n");
      out.write("                    <td><img src=\"img/arriendo.jpg\" width=\"120\" height=\"120\"></td>\r\n");
      out.write("                    <td><img src=\"img/user.jpg\" width=\"120\" height=\"120\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <input type=\"submit\" name=\"btn_nEdificio\"  value=\"Crear nuevo Edificio\" class=\"btn btn-info\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <input type=\"submit\" name=\"btn_buscarEdi\"  value=\"Buscar Edificio\" class=\"btn btn-success\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <input type=\"submit\" name=\"btn_Ingresa_Departamento\"  value=\"Ingresar Departamento\" class=\"btn btn-danger\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <input type=\"submit\" name=\"btn_usuarios\"  value=\"Usuarios\" class=\"btn btn-warning\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    </form>\r\n");
      out.write("                    \r\n");
      out.write("                </tr>\r\n");
      out.write("                \r\n");
      out.write("            </table>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <script src=\"js/jquery-3.2.1.min.js\"></script>\r\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"js/moment.min.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
