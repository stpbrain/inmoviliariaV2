/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControlArrendatario;
import Controlador.ControlEdificio;
import Controlador.ControlUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author papalominos
 */
@WebServlet(name = "ServletPrincipal", urlPatterns = {"/ServletPrincipal"})
public class ServletPrincipal extends HttpServlet {

    public static final String LISTA_EDIFICIOS = "listaEdificios";
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
             RequestDispatcher dispatcher = null;
              HttpSession sesion = request.getSession();
             
           
            // validar si la sesion de login esta iniciada !!!
            
            String btn_nuevo_edificio = request.getParameter("btn_nEdificio");
            String btn_buscar_edificio = request.getParameter("btn_buscarEdi");
            String btn_Ingresa_Depto = request.getParameter("btn_Ingresa_Departamento");
            String btn_buscar_depto = request.getParameter("btn_Buscar_Departamento");
            String btn_usuarios = request.getParameter("btn_usuarios");
            
            if (btn_nuevo_edificio != null)
            {
                    ControlEdificio ce = new ControlEdificio();
                  
                    sesion.setAttribute("comuna", ce.ObtererComuna());
                    dispatcher = request.getRequestDispatcher("/CrearNuevoEdificio.jsp");
                    dispatcher.forward(request, response);
                   
            }
            if(btn_buscar_edificio != null)
            {
                    ControlEdificio ce = new ControlEdificio();
                  
                    sesion.setAttribute("comuna", ce.ObtererComuna());
                    dispatcher = request.getRequestDispatcher("/BuscaEdificio.jsp");
                    dispatcher.forward(request, response);
            }
            
            if (btn_buscar_depto != null){
                
                ControlEdificio ctrl = new ControlEdificio();
                ControlArrendatario ctrl2 = new ControlArrendatario();
                sesion.setAttribute(LISTA_EDIFICIOS, ctrl2.ObtenerIdEdificio());    
                dispatcher = request.getRequestDispatcher("/BuscarDepartamento.jsp");
                dispatcher.forward(request, response);
            }
            
            if(btn_Ingresa_Depto != null)
            {
                ControlArrendatario ctrlArrendatario = new ControlArrendatario();
                sesion.setAttribute("id_edificio", ctrlArrendatario.ObtenerIdEdificio());
              
                dispatcher = request.getRequestDispatcher("/NuevoArrendatario.jsp");
                dispatcher.forward(request, response);
            }
            if(btn_usuarios != null)
            {
               ControlUsuario list = new ControlUsuario();
               sesion.setAttribute("listUsuario", list.ListarUsuario());
               dispatcher = request.getRequestDispatcher("/Usuarios.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
