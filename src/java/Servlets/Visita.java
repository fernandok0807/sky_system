/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.Mail;
import Clases.VisitaClass;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enmanuel
 */
public class Visita extends HttpServlet {

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
            out.println("<title>Servlet Visita</title>");            
            out.println("</head>");
            out.println("<body>");
            VisitaClass nuevo = new VisitaClass();

                        
            //System.out.println(dato);
            
            int accion = Integer.parseInt(request.getParameter("actualizar"));
                if(accion == 1){
                    VisitaClass nuevo2 = new VisitaClass();
                    //System.out.println("Entrando al serv");
                    try{
                    
                    nuevo2.setCodtecnico(Integer.parseInt(request.getParameter("txttecnico")));
                    nuevo2.setCod_cliente(Integer.parseInt(request.getParameter("txtcliente")));
                    
                    
                    nuevo2.setCoordenada(nuevo2.coordenadasCliente(request.getParameter("txtcliente")));
                    int ejecutar=0;
                    
                    ejecutar=nuevo.nuevo(nuevo2);
                    if(ejecutar==1){
                        out.println("<h4>Ingresado correctamente</h4>");
                    }
                    else{
                        out.println("<h4>No se pudo ingresar</h4>");
                    }
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                        
                }
                else{
                    if(accion == 2){
                        VisitaClass nuevo2 = new VisitaClass();
                        
                         DateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy, HH:mm:ss");
 
        String date = dateFormat.format(new Date());
                    nuevo2.setCod_visita(Integer.parseInt(request.getParameter("txtcodigo")));
                    nuevo2.setCodtecnico(Integer.parseInt(request.getParameter("txttecnico")));
                    nuevo2.setCod_cliente(Integer.parseInt(request.getParameter("txtcliente")));
                    nuevo2.setIngreso(request.getParameter("txtingreso"));
                    nuevo2.setEgreso(date);
                    nuevo2.setCoordenada(request.getParameter("txtcoordenada"));
                    nuevo2.setReporte(request.getParameter("txtreporte"));
                    nuevo2.setCorreoCliente(request.getParameter("txtcorreo"));
                    
                        int ejecutar=0;
                        ejecutar=nuevo.modificar(nuevo2);
                        if(ejecutar==1){
                            
                            
                            
                            Mail correo = new Mail();
                            
                            correo.sendMail(nuevo2.getCorreoCliente(), nuevo2.getIngreso(),nuevo2.getEgreso(),nuevo2.getNombreCliente(),nuevo2.getReporte(),"Incorrecto");
                            System.out.println(nuevo2.getCorreoCliente());
                            
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
                        else{
                            if(accion == 4){
                        VisitaClass nuevo2 = new VisitaClass();
                    nuevo2.setCod_visita(Integer.parseInt(request.getParameter("txtcodigo2")));
                    nuevo2.setCodtecnico(Integer.parseInt(request.getParameter("txttecnico2")));
                    nuevo2.setCod_cliente(Integer.parseInt(request.getParameter("txtcliente2")));
                      
                    DateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy, HH:mm:ss");
 
        String date = dateFormat.format(new Date());
 
        System.out.println(date);       
                    nuevo2.setIngreso(date);
                    nuevo2.setEgreso(null);
                    nuevo2.setCoordenada(request.getParameter("txtcoordenada2"));
                    nuevo2.setReporte(request.getParameter("txtreporte2"));
                    
                        int ejecutar=0;
                        ejecutar=nuevo.modificar(nuevo2);
                        if(ejecutar==1){
                            out.println("<h4>Se inicio  correctamente</h4>");
                            out.println("<br>");
                            String latitud=nuevo2.getCoordenada().substring(0,nuevo2.getCoordenada().indexOf(","));
                            String longitud = nuevo2.getCoordenada().substring(nuevo2.getCoordenada().indexOf(",")+1,nuevo2.getCoordenada().length());
                            System.out.println("latitud"+latitud);
                            //System.out.println( +"%2C"+));
                            out.println("<a href=\"https://www.google.com/maps/search/?api=1&query="+latitud+"%2C"+longitud+"\" target=\"_blank\">Clic para Obtener Indicaciones de Como LLegar</a>");
                                    
                        }
                        else{
                            out.println("<h4>No se pudo modifcar</h4>");
                        }
                    }
                            else{
                                       if(accion == 5){
                        VisitaClass nuevo2 = new VisitaClass();
                    nuevo2.setCod_visita(Integer.parseInt(request.getParameter("txtcodigo")));
                    nuevo2.setCodtecnico(Integer.parseInt(request.getParameter("txttecnico")));
                    nuevo2.setCod_cliente(Integer.parseInt(request.getParameter("txtcliente")));
                    nuevo2.setEgreso(null);
                    nuevo2.setIngreso(null);
                    nuevo2.setReporte(null);
                    nuevo2.setCoordenada(nuevo2.coordenadasCliente(request.getParameter("txtcliente")));
                    
                    
                        int ejecutar=0;
                        ejecutar=nuevo.modificar(nuevo2);
                        if(ejecutar==1){
                            out.println("<h4>Se Modifico Correctamente</h4>");
                            out.println("<br>");
                                    
                        }
                        else{
                            out.println("<h4>No se pudo modifcar</h4>");
                        }
                    }
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
