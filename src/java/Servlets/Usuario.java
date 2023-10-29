/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Clases.UsuarioClass;
import java.util.Objects;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Enmanuel
 */
public class Usuario extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Usuario</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            UsuarioClass nuevo = new UsuarioClass();
            
            UsuarioClass dato = nuevo.Ingresar(request.getParameter("usuario"),request.getParameter("contrasena"));
            
           // System.out.println(dato);
            
            if(dato==null){
                //System.out.println("Esta vacia 1");
                dato = nuevo.Ingresar2(request.getParameter("usuario"),request.getParameter("contrasena"));
                if(dato==null){
                    //System.out.println("Esta vacia2");
                    response.sendRedirect("index.jsp");
                }
                else{

                   // System.out.println("Entrando a sesión");
                    HttpSession sesion = request.getSession();

                    sesion.setAttribute("nombre", dato.getNombre());
                    sesion.setAttribute("tipo", dato.getTipo());
                    sesion.setAttribute("acceso", dato.getCod_usuario());

                    response.sendRedirect("Principal.jsp");

                }
            }
            else{
                
               // System.out.println("Entrando a sesión");
                HttpSession sesion = request.getSession();
                
                sesion.setAttribute("nombre", dato.getNombre());
                sesion.setAttribute("tipo", dato.getTipo());
                sesion.setAttribute("acceso", dato.getCod_usuario());
                
                response.sendRedirect("Principal.jsp");
                
            }
            
            
            
            out.println("</body>");
            out.println("</html>");
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
