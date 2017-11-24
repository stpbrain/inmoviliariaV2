/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControlUsuario;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pc-ccarreno
 */
@WebServlet(name = "ServletUsuario", urlPatterns = {"/usuario"})
public class ServletUsuario extends HttpServlet {

    public static final String LOGIN = "login";
    public static final String REGISTRAR = "registrar";
    public static final String TEST = "test";
    public static final String LOGOUT = "logout";
    public static final String USUARIO_ACTUAL = "usuario_actual";
    public static final String MENSAJE = "mensaje";

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
        
        String action = request.getParameter("action");
        
        if(action!= null && !action.isEmpty()) {
            
            if(action.equals(LOGIN)) {
                
                login(request, response);
                
            } else if(action.equals(REGISTRAR)) {
                
                registrar(request, response);
                
            } else if(action.equals(LOGOUT)) {
                
                logout(request, response);
                
            } else if(action.equals(TEST)) {
                
                test(request, response);
                
            } else {
                
                error404(request, response);
            }
        }
    }
    
    void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher = null;
        
        String nomUsuario = request.getParameter("usuario");
        String contrasena = request.getParameter("password");
        
        HttpSession session = request.getSession(true);
                
        if(!nomUsuario.isEmpty() && !contrasena.isEmpty()) {
        
            Usuario usuario = ControlUsuario.validaLogin(nomUsuario, contrasena);

            if(usuario != null) {

                System.out.println("USUARIO ENCONTRADO!");
                session.setAttribute(USUARIO_ACTUAL, usuario);
                dispatcher = request.getRequestDispatcher("/AdminCentral.jsp");

            } else {

                System.out.println("USUARIO NO EXISTE!");
                session.setAttribute(MENSAJE, "Usuario y/o Contraseña NO válido(s).");
                dispatcher = request.getRequestDispatcher("/index.jsp");
            }
        } else {
            
            //capturar en index.jsp si es que existe la variable de session
            System.out.println("Usuario y/o Contraseña NO válido(s).");
            session.setAttribute(MENSAJE, "Usuario y/o Contraseña NO válido(s).");
            dispatcher = request.getRequestDispatcher("/index.jsp");
        }
        
        dispatcher.forward(request, response);
    }
    
    void registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher = null;
        
        String rut = request.getParameter("rut");
        String nomUsuario = request.getParameter("usuario");
        String contrasena = request.getParameter("password");
        
        HttpSession session = request.getSession(true);
                
        if(!rut.isEmpty() &&!nomUsuario.isEmpty() && !contrasena.isEmpty()) {
        
            if(validarRut(rut)) {
                
                Usuario u = new Usuario();

                u.setRut(rut);
                u.setN_usuario(nomUsuario);
                u.setPass(contrasena);

                Boolean resultado = ControlUsuario.registrarUsuario(u);

                if(resultado) {

                    session.setAttribute(USUARIO_ACTUAL, u);
                    dispatcher = request.getRequestDispatcher("/AdminCentral.jsp");

                } else {

                    session.setAttribute(MENSAJE, "No fue Posible crear el usuario.");
                    dispatcher = request.getRequestDispatcher("/RegistrarUsuario.jsp");
                    //response.sendRedirect("/demo.jsp");
                }
            } else {

                session.setAttribute(MENSAJE, "RUT no es válido.");
                dispatcher = request.getRequestDispatcher("/RegistrarUsuario.jsp");
                //response.sendRedirect("/demo.jsp");
            }
        } else {
            
            //capturar en index.jsp si es que existe la variable de session
            session.setAttribute(MENSAJE, "Todos los campos son oblogatorios.");
            dispatcher = request.getRequestDispatcher("/RegistrarUsuario.jsp");
        }
        
        dispatcher.forward(request, response);
    }
    
    void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        session.invalidate();
        
        try {
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    void error404(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/404.jsp");
            dispatcher.forward(request, response);
            
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void test(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
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


//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ServletUsuario</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ServletUsuario at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }

    private boolean validarRut(String rut) {
        
        boolean validacion = false;
        
        try {
            
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }

}
