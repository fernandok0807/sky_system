/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.ClienteClass;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Enmanuel
 */
public class Cliente extends HttpServlet {

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
            out.println("<title>Servlet Cliente</title>");            
            out.println("</head>");
            out.println("<body>");
            ClienteClass nuevo = new ClienteClass();

                        
            //System.out.println(dato);
            
            int accion = Integer.parseInt(request.getParameter("actualizar"));
                if(accion == 1){
                    ClienteClass nuevo2 = new ClienteClass();
                    nuevo2.setNombre(request.getParameter("txtnombres"));
                    nuevo2.setTelefono(request.getParameter("txttelefono"));
                    nuevo2.setCorreo(request.getParameter("txtcorreo"));
                    nuevo2.setDireccion(request.getParameter("txtdireccion"));
                    nuevo2.setCoordenadas(request.getParameter("txtcoordenadas"));
                    int ejecutar=0;
                    
                    ejecutar=nuevo.nuevo(nuevo2);
                    if(ejecutar==1){
                        out.println("<h4>Ingresado correctamente</h4>");
                    }
                    else{
                        out.println("<h4>No se pudo ingresar</h4>");
                    }
                }
                else{
                    if(accion == 2){
                        ClienteClass nuevo2 = new ClienteClass();
                        nuevo2.setCod_cliente(Integer.parseInt(request.getParameter("txtcodigo")));
                        nuevo2.setNombre(request.getParameter("txtnombres"));
                        nuevo2.setTelefono(request.getParameter("txttelefono"));
                        nuevo2.setCorreo(request.getParameter("txtcorreo"));
                        nuevo2.setDireccion(request.getParameter("txtdireccion"));
                        nuevo2.setCoordenadas(request.getParameter("txtcoordenadas"));
                    
                        int ejecutar=0;
                        ejecutar=nuevo.modificar(nuevo2);
                        if(ejecutar==1){
                            out.println("<h4>Modificado correctamente</h4>");
                        }
                        else{
                            out.println("<h4>No se pudo modifcar</h4>");
                        }
                    } 
                    else{
                        if(accion == 3){
                            int ejecutar=0;
                            ejecutar=nuevo.eliminar(request.getParameter("txtcodigo"));
                            if(ejecutar==1){
                                out.println("<h4>Eliminado correctamente</h4>");
                            }
                            else{
                                out.println("<h4>No se pudo eliminar</h4>");
                            }
                        }
                    }
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
