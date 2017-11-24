/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControlEdificio;
import Modelo.Edificio;
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
@WebServlet(name = "ServletEdificio", urlPatterns = {"/ServletEdificio"})
public class ServletEdificio extends HttpServlet {

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
            
            
            String btn_guardar = request.getParameter("btn_guardar");
            String btn_buscar = request.getParameter("btn_buscar");
            String btn_habilitar = request.getParameter("btn_habilitar");
            String btn_volver = request.getParameter("btn_volver");
            String btn_editar = request.getParameter("btn_editar");
            String btn_guardar_editado = request.getParameter("btn_guardar_editado");
            
            
            if(btn_guardar != null)
            {
              String codigo = request.getParameter("id_edificio");
              String nomb_edificio = request.getParameter("n_edificio");
              String direccion = request.getParameter("direccion");
              String comuna = request.getParameter("comuna");
              int c = Integer.parseInt(comuna);
              String permiso = request.getParameter("permiso");
              int p = Integer.parseInt(permiso);
              
              Edificio e = new Edificio();
              e.setId_edificio(codigo);
              e.setN_edifico(nomb_edificio);
              e.setDireccion(direccion);
              e.setId_comuna(c);
              e.setPosee_permiso(p);
              
              ControlEdificio ce = new ControlEdificio();
              ce.InsertarEdificio(e);
              
              dispatcher = request.getRequestDispatcher("/AdminCentral.jsp");
                dispatcher.forward(request, response);

            }
            if(btn_buscar != null)
            {
                String cod = request.getParameter("comuna");
                int c  = Integer.parseInt(cod);
                sesion.setAttribute("com", c);
                ControlEdificio ce = new ControlEdificio(); 
                sesion.setAttribute("lista_edi", ce.ListarEdificios(c));  
                dispatcher = request.getRequestDispatcher("/BuscaEdificio.jsp");
                dispatcher.forward(request, response);
                
            }
            if(btn_habilitar != null)
            {
                String id = request.getParameter("id");
                ControlEdificio c = new ControlEdificio();
                c.Hablitar(id);
                int com = (Integer) sesion.getAttribute("com");
                ControlEdificio ce = new ControlEdificio(); 
                sesion.setAttribute("lista_edi", ce.ListarEdificios(com));  
                dispatcher = request.getRequestDispatcher("/BuscaEdificio.jsp");
                dispatcher.forward(request, response);
                
            }
            if (btn_volver != null)
            {
             dispatcher = request.getRequestDispatcher("/AdminCentral.jsp");
                dispatcher.forward(request, response);

            }
            
            if (btn_editar != null)
            {
             String id = request.getParameter("id");
             String nombre = request.getParameter("nombre_l");
             String direccion = request.getParameter("direccion");
             String comuna = request.getParameter("comuna");
             int c = Integer.parseInt(comuna);
             String permiso = request.getParameter("permiso");
             int p = Integer.parseInt(permiso);
             
             Edificio e = new Edificio();
             e.setId_edificio(id);
             e.setN_edifico(nombre);
             e.setDireccion(direccion);
             e.setId_comuna(c);
             e.setPosee_permiso(p);
             sesion.setAttribute("mod_edi_ori", e);
             dispatcher = request.getRequestDispatcher("/EditarEdificio.jsp");
             dispatcher.forward(request, response);
            }  
            if(btn_guardar_editado != null)
            {
                Edificio edi_nuevo = new Edificio();
                String codigo = request.getParameter("codigo");
                String nombre = request.getParameter("nombre_n");
                String direccion = request.getParameter("direccion");
                String permiso = request.getParameter("permiso");
                int p = Integer.parseInt(permiso);
                
                edi_nuevo.setId_edificio(codigo);
                edi_nuevo.setN_edifico(nombre);
                edi_nuevo.setDireccion(direccion);
                edi_nuevo.setPosee_permiso(p);
                
                Edificio edi_ori = (Edificio) sesion.getAttribute("mod_edi_ori");
                
                ControlEdificio edit = new ControlEdificio();
                edit.modEdificio(edi_nuevo, edi_ori);
                 int com = (Integer) sesion.getAttribute("com");
                ControlEdificio ce = new ControlEdificio(); 
                sesion.setAttribute("lista_edi", ce.ListarEdificios(com)); 
                
                dispatcher = request.getRequestDispatcher("/BuscaEdificio.jsp");
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
