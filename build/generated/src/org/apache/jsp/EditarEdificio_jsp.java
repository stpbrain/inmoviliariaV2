package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Edificio;

public final class EditarEdificio_jsp extends org.apache.jasper.runtime.HttpJspBase
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

HttpSession sesion = request.getSession(true);
Edificio edi = (Edificio) sesion.getAttribute("mod_edi_ori");





      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("         <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("         <div class=\"container-fluid\">\r\n");
      out.write("            <div style=\"background-image: url(img/banner.jpg); background-position: right; background-size: 100%; \" class=\"jumbotron text-center\">\r\n");
      out.write("                <h4 class=\"display-4\" >Inmobiliaria <br> Adeudadito mas Feliz</h4>\r\n");
      out.write("                <h5 class=\"lead\">El lugar donde su sueño se hace <h5 style=\"color: red\">Realidad</h5></h5>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <form action=\"./ServletEdificio\" method=\"POST\" name=\"f4\">\r\n");
      out.write("            <table class=\"table container text-center table-striped table-bordered table-hover\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td colspan=\"2\"><h3>Portal de Modificacion </h3></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>El codigo del edificio es : </td>\r\n");
      out.write("                    <td><input type=\"text\" name=\"codigo\" value=\"");
      out.print( edi.getId_edificio());
      out.write("\" class=\"form-control\" readonly=\"readonly\"> </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Ingrese nuevo nombre de Edificio:</td>\r\n");
      out.write("                    <td><input type=\"text\" name=\"nombre\" placeholder=\"el nombre actual es : ");
      out.print(edi.getN_edifico());
      out.write("\" class=\"form-control\" ></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Ingrese nueva Direccion :</td>\r\n");
      out.write("                    <td><input type=\"text\" name=\"direccion\" placeholder=\"La direccion es : ");
      out.print(edi.getDireccion());
      out.write("\"class=\"form-control\"> </td>\r\n");
      out.write("                    \r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Estado actual del permiso : ");
 if(edi.getPosee_permiso() == 0)     
                        { 
      out.write("<h6 style=\"color: red \">No posee Permisos</h6> ");
}
                          else {
      out.write("<h6 style=\"color: green\">Posee Permisos</h6> ");
 }
                        
      out.write("</td>\r\n");
      out.write("                    \r\n");
      out.write("                     <td>\r\n");
      out.write("                            <select name=\"permiso\">\r\n");
      out.write("                                <option value=\"2\">Cambiar a ...</option>\r\n");
      out.write("                                <option value=\"0\"> No posee Permiso</option>\r\n");
      out.write("                                <option value=\"1\"> Si posee Permiso</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td colspan=\"2\" >\r\n");
      out.write("                        <input type=\"submit\" name=\"btn_guardar_editado\" value=\"Guardar\" class=\"btn btn-success\">\r\n");
      out.write("                        <input type=\"submit\" name=\"btn_volver\" value=\"Volver\" class=\"btn btn-danger\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
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
