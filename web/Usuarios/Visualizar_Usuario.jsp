<%-- 
    Document   : Visualizar
    Created on : 21/10/2023, 07:27:23 PM
    Author     : Enmanuel
--%>

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
            <th>Nombre Completo</th>
            <th>Usuario</th>
            <th>Contrseña</th>
            <th >Tipo</th>
            <th>Acción</th>
        </thead>
        <tbody id="tbl_alumno">
        <% 
            //Estudiante clsEstudiante2  = new Estudiante();
            String search =request.getParameter("search");
            String campo=request.getParameter("campo");
            
            List<UsuarioClass> tblModelo= new ArrayList<UsuarioClass>();
                
            if(search.equals("")){
                UsuarioClass clase = new UsuarioClass();
                tblModelo =clase.buscar(search);

            }
            else{
                UsuarioClass clase = new UsuarioClass();
                tblModelo =clase.buscarFil(search);

            }
            
            for(int a=0;a< tblModelo.size();a++){
                out.println("<tr data-id="+ tblModelo.get(a).getCod_usuario()+"  >");
                out.println("<td>" + tblModelo.get(a).getNombre()  + "</td>");
                out.println("<td>" + tblModelo.get(a).getUsuario() + "</td>");
                out.println("<td>" + tblModelo.get(a).getClave() + "</td>"); 
                out.println("<td>" + tblModelo.get(a).getTipo() + "</td>"); 
                
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

