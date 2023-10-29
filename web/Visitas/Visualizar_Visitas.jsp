<%-- 
    Document   : Visualizar
    Created on : 21/10/2023, 07:27:23 PM
    Author     : Enmanuel
--%>

<%@page import="Clases.VisitaClass"%>
<%@page import="Clases.ClienteClass"%>
<%@page import="Clases.SupervisorClass"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clases.UsuarioClass"%>
<%@page import="javax.swing.table.DefaultTableModel"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <body>
    <div class="table-responsive">
    <table class="table table-hover table-bordered">
        <thead class="success">
            <th>Cliente</th>
            <th >Fecha/Hora Inicio</th>
            <th >Fecha/Hora Fin</th>
            <th >Reporte Final</th>
            <th >Como LLegar</th>
            
            <%
                HttpSession sesion= request.getSession();
        String user="";
        try{
            
             user=String.valueOf(sesion.getAttribute("acceso"));
        System.out.println("codigo tecnico:"+user);
        }catch(Exception e){
            System.out.println(e);
            
        }
        
            String search =request.getParameter("search");
            String campo=user;
            //System.out.println(search);
            
                
                
                if(search.equals("0")){%>  
                    <th>Acción</th>
                <% }
                else{%>  
                    
                <%}%>
            
        </thead>
        <tbody id="tbl_alumno">
        <% 
            //Estudiante clsEstudiante2  = new Estudiante();
            
            List<VisitaClass> tblModelo= new ArrayList<VisitaClass>();
            VisitaClass clase = new VisitaClass();
                
                tblModelo =clase.buscar2(search,campo);
                
            for(int a=0;a< tblModelo.size();a++){
                if(search.equals("1")){
                    if(!tblModelo.get(a).getIngreso().equals("")  && !tblModelo.get(a).getEgreso().equals("")){
                        out.println("<tr data-id="+ tblModelo.get(a).getCod_visita()+" data-idtecnico="+tblModelo.get(a).getCodtecnico()+" data-idcliente="+tblModelo.get(a).getCod_cliente()+"  >");
                        out.println("<td>" + tblModelo.get(a).getNombreCliente()+ "</td>"); 
                        out.println("<td>" + tblModelo.get(a).getIngreso() + "</td>"); 
                        out.println("<td>" + tblModelo.get(a).getEgreso() + "</td>"); 
                        out.println("<td>" + tblModelo.get(a).getReporte() + "</td>"); 
                        out.println("<td>" + tblModelo.get(a).getCoordenada() + "</td>"); 
                        out.println("</tr>");
                    }
                    
                }
                else{
                    if(tblModelo.get(a).getIngreso().equals("")  || tblModelo.get(a).getEgreso().equals("")){
                        out.println("<tr data-id="+ tblModelo.get(a).getCod_visita()+" data-idtecnico="+tblModelo.get(a).getCodtecnico()+" data-idcliente="+tblModelo.get(a).getCod_cliente()+" data-ccliente="+tblModelo.get(a).getCorreoCliente()+"  >");
                        out.println("<td>" + tblModelo.get(a).getNombreCliente()+ "</td>"); 
                        out.println("<td>" + tblModelo.get(a).getIngreso() + "</td>"); 
                        out.println("<td>" + tblModelo.get(a).getEgreso() + "</td>"); 
                        out.println("<td>" + tblModelo.get(a).getReporte() + "</td>"); 
                        out.println("<td>" + tblModelo.get(a).getCoordenada() + "</td>"); 
                        out.println("<td>");
                        if(tblModelo.get(a).getIngreso().equals("")){%>
                            <button class="btn btn-success" data-toggle="modal"  data-target=".modal2" name="accion" id="accion">Iniciar</button></td>
                        <% }
                        else{
                            if(tblModelo.get(a).getEgreso().equals("") ){%>
                            <a  class="btn btn-warning" style="color:#FFF;"  role="button" data-toggle="modal"  data-target=".bd-example-modal-xl" name="accion" id="accion"> Finalizar</a>
                        <%    }
                        }
                        out.println("</td>");
                        out.println("</tr>");
                    }
                    else{
                        System.out.println("vacias");
                    }
                    
                    
                    
                }
                }
                %>   
                
        </tbody>
    </table>
        
    </div>
    </body>
   
</html>

