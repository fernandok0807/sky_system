<%-- 
    Document   : Visualizar
    Created on : 21/10/2023, 07:27:23 PM
    Author     : Enmanuel
--%>

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
            <th>Nombre</th>
            <th>Teléfono</th>
            <th >Correo</th>
            <th >Dirección</th>
            <th >Coordenadas</th>
            
            <th>Acción</th>
        </thead>
        <tbody id="tbl_alumno">
        <% 
            //Estudiante clsEstudiante2  = new Estudiante();
            String search =request.getParameter("search");
            String campo=request.getParameter("campo");
            
            List<ClienteClass> tblModelo= new ArrayList<ClienteClass>();
            ClienteClass clase = new ClienteClass();
            if(search.equals("")){
                
                tblModelo =clase.buscar(search);

            }
            else{
                
                tblModelo =clase.buscarFil(search);

            }
            
            for(int a=0;a< tblModelo.size();a++){
                out.println("<tr data-id="+ tblModelo.get(a).getCod_cliente()+"  >");
                out.println("<td>" + tblModelo.get(a).getNombre()  + "</td>");
                out.println("<td>" + tblModelo.get(a).getTelefono() + "</td>"); 
                out.println("<td>" + tblModelo.get(a).getCorreo() + "</td>"); 
                out.println("<td>" + tblModelo.get(a).getDireccion() + "</td>"); 
                
                out.println("<td> " + tblModelo.get(a).getCoordenadas() + "</td>"); 
                
                %>   
                <td> <a  class="btn btn-success" style="color:#FFF;"  role="button" data-toggle="modal"  data-target=".bd-example-modal-xl" name="accion" id="accion"> Modificar</a>
                    <button class="btn btn-danger" data-toggle="modal"  data-target=".modal2" name="accion" id="accion">Eliminar</button></td>
                <%out.println("</tr>");
            }%>
        </tbody>
    </table>
        
    </div>
    </body>
   
</html>

