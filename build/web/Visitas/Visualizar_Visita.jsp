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
            <th >Coordenadas</th>
            <th >Reporte</th>
            <th>Acción</th>
        </thead>
        <tbody id="tbl_alumno">
        <% 
            //Estudiante clsEstudiante2  = new Estudiante();
            String search =request.getParameter("search");
            String campo=request.getParameter("campo");
            
            System.out.println("valor de search"+search);
            
            List<VisitaClass> tblModelo= new ArrayList<VisitaClass>();
            VisitaClass clase = new VisitaClass();
                tblModelo =clase.buscarFil(search);

            
            
            for(int a=0;a< tblModelo.size();a++){
                out.println("<tr data-id="+ tblModelo.get(a).getCod_visita()+" data-idtecnico="+tblModelo.get(a).getCodtecnico()+" data-idcliente="+tblModelo.get(a).getCod_cliente()+"  >");
                
                out.println("<td>" + tblModelo.get(a).getNombreCliente() + "</td>"); 
                
                out.println("<td>" + tblModelo.get(a).getIngreso() + "</td>"); 
                out.println("<td>" + tblModelo.get(a).getEgreso() + "</td>"); 
                
                out.println("<td>" + tblModelo.get(a).getCoordenada() + "</td>"); 
                if(tblModelo.get(a).getReporte().equals("null")){
                    out.println("<td></td>"); 
                }
                else{
                    out.println("<td>" + tblModelo.get(a).getReporte() + "</td>"); 
                }
                
                %>
                <%if(tblModelo.get(a).getIngreso().equals("")){%>  
                <td> <a  class="btn btn-success" style="color:#FFF;"  role="button" data-toggle="modal"  data-target=".bd-example-modal-xl" name="accion" id="accion"> Modificar</a>
                <button class="btn btn-danger" data-toggle="modal"  data-target=".modal2" name="accion" id="accion">Eliminar</button></td>
                    
                <%}
                else{%>  
                <td>Visita Finalizada</td>
                <%}%>
                <%out.println("</tr>");
            }%>
        </tbody>
    </table>
        
    </div>
    </body>
   
</html>

