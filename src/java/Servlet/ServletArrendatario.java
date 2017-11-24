
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControlArrendatario;
import Modelo.Departamento;
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
            String btnModificar = request.getParameter("btn_modificar");
            
            HttpSession sesion = request.getSession();
            RequestDispatcher dispatcher;
                       
            if (btnIngresar != null){
                String idEdificio = request.getParameter("id_edificio");
                //falta el idDepartamento que es autoincrementable (?)
                int numDepto = Integer.parseInt("num_depto");
                String residente = request.getParameter("txtResidente");
                
                ControlArrendatario ctrlArrendatario = new ControlArrendatario();
                
                Departamento dpto = new Departamento();
                dpto.setId_edificio(idEdificio);
                dpto.setNumero_d(numDepto);
                dpto.setResidente(residente);
                
                
                ctrlArrendatario.GuardarDpto(dpto);
                
                dispatcher = request.getRequestDispatcher("/AdminCentral.jsp");
                dispatcher.forward(request, response);

            }
            
            if(btnBuscar != null)
            {
                String condominio = request.getParameter("id_edificio");
                int idCondominio  = Integer.parseInt(condominio);
                sesion.setAttribute("condominio", idCondominio);
                ControlArrendatario ctrlArrendatario = new ControlArrendatario(); 
                sesion.setAttribute("listaDpto", ctrlArrendatario.ListarEdificios(idCondominio));  
                dispatcher = request.getRequestDispatcher("/NuevoArrendatario.jsp"); //cambiar
                dispatcher.forward(request, response);
                
            }
            
            if (btnVolver != null)
            {
             dispatcher = request.getRequestDispatcher("/AdminCentral.jsp");
                dispatcher.forward(request, response);

            }
            
            if (btnModificar != null){

             String residente = request.getParameter("residente");
             
             Departamento nuevoDepto = new Departamento();
             nuevoDepto.setResidente(residente);

             sesion.setAttribute("modifica", nuevoDepto);
             dispatcher = request.getRequestDispatcher("/NuevoArrendatario.jsp");
             dispatcher.forward(request, response);
            }
        }
    }           
}
