package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Departamento;
import Modelo.Edificio;
import java.util.ArrayList;

public final class NuevoArrendatario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
HttpSession sesion = request.getSession(true);
    ArrayList<Departamento> dep = (ArrayList<Departamento>) sesion.getAttribute("id_departamento");  
 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">\r\n");
      out.write("        <title>Nuevo Arrendatario</title>      \r\n");
      out.write("        \r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div>\r\n");
      out.write("            \r\n");
      out.write("                 <div class=\"container-fluid\">\r\n");
      out.write("            <div style=\"background-image: url(img/banner.jpg); background-position: right; background-size: 100%; \" class=\"jumbotron text-center\">\r\n");
      out.write("                <h4 class=\"display-4\" >Inmobiliaria <br> Adeudadito mas Feliz</h4>\r\n");
      out.write("            <h5 class=\"lead\">El lugar donde su sueño se hace <h5 style=\"color: red\">Realidad</h5></h5>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("          \r\n");
      out.write("            <div class=\" container text-center \" > \r\n");
      out.write("                \r\n");
      out.write("                <table class=\"table-active \">\r\n");
      out.write("                    <form action=\"./ServletArrendatario\" method=\"POST\" name=\"formArrendatario\">\r\n");
      out.write("                    <th colspan=\"2\" class=\"text-center\">\r\n");
      out.write("                    <h3>Nuevo Arrendatario</h3><br>\r\n");
      out.write("                    <h4>Ingrese los datos necesarios para registrar el nuevo arrendatario</h4>\r\n");
      out.write("                        \r\n");
      out.write("                    </th>\r\n");
      out.write("                    \r\n");
      out.write("                    <tr>                        \r\n");
      out.write("                        <td><h5>Condominio:</h5></td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                             <select name=\"id_edificio\">\r\n");
      out.write("                               ");
  
                               for (Departamento elem : dep) {
                               
      out.write("  <option  value=\"");
      out.print( elem.getId_edificio() );
      out.write("\" > </option>\r\n");
      out.write("                                   \r\n");
      out.write("                                   ");
 } 
      out.write("                                    \r\n");
      out.write("                              </select>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>   \r\n");
      out.write("                        <td>\r\n");
      out.write("                            <h5>Número de departamento:</h5>\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <input type=\"text\" name=\"num_dpto\" class=\"form-control\"\r\n");
      out.write("                        </td>\r\n");
      out.write("                        \r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <h5>Nombre del residente:</h5>\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <input type=\"text\" name=\"txtResidente\" class=\"form-control\"\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    \r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td colspan=\"2\" class=\"text-center\">\r\n");
      out.write("                            <input type=\"submit\" name=\"btn_guardar\" value=\"Confirmar arrendatario\" class=\"btn btn-success\">\r\n");
      out.write("        </form>\r\n");
      out.write("                    <form action=\"./ServletPrincipal\" method=\"POST\" name=\"arr\">\r\n");
      out.write("                        \r\n");
      out.write("                            <input type=\"submit\" name=\"btn_volver\" value=\"Volver\" class=\"btn btn-danger\" a href=\"index.jsp\">\r\n");
      out.write("                       </form>\r\n");
      out.write("                        </td>\r\n");
      out.write("                        \r\n");
      out.write("                   \r\n");
      out.write("                    </tr>\r\n");
      out.write("                </table>\r\n");
      out.write("         </form>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
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
