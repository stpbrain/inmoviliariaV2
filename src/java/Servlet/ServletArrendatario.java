
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControlArrendatario;
import Modelo.Departamento;
import static Servlet.ServletEdificio.LISTA_DEPARTAMENTOS;
import static Servlet.ServletUsuario.MENSAJE;
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
 * Author     : Kathy
 */
@WebServlet(name = "ServletArrendatario", urlPatterns = {"/ServletArrendatario"})
public class ServletArrendatario extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String btnIngresar = request.getParameter("btn_guardar");
            String btnBuscar = request.getParameter("btn_buscar"); //falta crear el botón buscar
            String btnVolver = request.getParameter("btn_volver");
            String btnModificar = request.getParameter("btn_editar");
            
            HttpSession sesion = request.getSession();
            RequestDispatcher dispatcher;
                       
            if (btnIngresar != null){
                String idEdificio = request.getParameter("id_edificio");
                //falta el idDepartamento que es autoincrementable (?)
                int numDepto = Integer.parseInt(request.getParameter("num_dpto"));
                String residente = request.getParameter("txtResidente");
                
                ControlArrendatario ctrlArrendatario = new ControlArrendatario();
                
                Departamento dpto = new Departamento();
                dpto.setId_edificio(idEdificio);
                dpto.setNumero_d(numDepto);
                dpto.setResidente(residente);
                
                
                if(ctrlArrendatario.GuardarDpto(dpto)) {
                    sesion.setAttribute(MENSAJE, "Departamento Creado");
                } else {
                    sesion.setAttribute(MENSAJE, "No se logra crear Departamento");
                }
                
                dispatcher = request.getRequestDispatcher("/NuevoArrendatario.jsp");
                dispatcher.forward(request, response);

            }
            
            if(btnBuscar != null)
            {
                String condominio = request.getParameter("id_edificio");
                int idCondominio  = Integer.parseInt(condominio);
                sesion.setAttribute("condominio", idCondominio);
                ControlArrendatario ctrlArrendatario = new ControlArrendatario(); 
                sesion.setAttribute("listaDpto", ctrlArrendatario.ListarDepartamentos(condominio));  
                dispatcher = request.getRequestDispatcher("/NuevoArrendatario.jsp"); //cambiar
                dispatcher.forward(request, response);
                
            }
            
            if (btnVolver != null)
            {
             dispatcher = request.getRequestDispatcher("/AdminCentral.jsp");
                dispatcher.forward(request, response);

            }
            
            if (btnModificar != null){

                System.out.println("EDITAAAAAA");
                Integer idDpto = Integer.parseInt(request.getParameter("idDepartamento"));
                String residente = request.getParameter("residente");
             
                ControlArrendatario ctrlArrendatario = new ControlArrendatario(); 
                if(ControlArrendatario.editarResidente(idDpto, residente)) {
                
                    sesion.setAttribute(MENSAJE, "Residente actualizado");
                    sesion.setAttribute(ServletPrincipal.LISTA_EDIFICIOS, ctrlArrendatario.ObtenerIdEdificio());
                    sesion.setAttribute(LISTA_DEPARTAMENTOS, null);
                    
                } else {
                    sesion.setAttribute(MENSAJE, "No se logra editar residente");
                }
             
             dispatcher = request.getRequestDispatcher("/BuscarDepartamento.jsp");
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
