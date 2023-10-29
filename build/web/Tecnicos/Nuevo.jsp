<%-- 
    Document   : Principal
    Created on : 21/10/2023, 07:27:23 PM
    Author     : Enmanuel
--%>



<%@page import="Clases.TecnicoClass"%>
<%@page import="java.util.List"%>
<%@include file="../Principal.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">      
        <script src="js/jquery2.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/ajax.js" type="text/javascript"></script>
        <script src="grados.js" type="text/javascript"></script>
        
    </head>
    <body>
        <br>
          <%
         
          
        HttpSession sesi= request.getSession();
        String use="";
        String tip="";
        try{
            
             use=String.valueOf(sesi.getAttribute("acceso"));
             tip=String.valueOf(sesi.getAttribute("tipo"));
             
        }catch(Exception e){
            System.out.println(e);
                
        }
        %>
        <div class="container">
            <h4 style="color:#007bff;text-align: center" >Tecnicos</h4>
            <br>
            <form class="form-horizontal" action="" method="POST" name="buscador_form" id="buscador_form">
                <br>
                <div class="row">
                    <label class="control-label col-md-2">Buscador por nombre: </label>
                    <div class="col-md-10">
                        <input type="text" name="search" id="search" class="form-control" placeholder="">
                    </div>
                </div>
                <br>
                <div class="form-row" style="justify-content: center">
                        <a href="../Principal.jsp" class="btn btn-info" style="width:93px;height: 38px; padding: 5px;margin:2px" > Regresar  </a>
                        <button type="button" class="btn btn-primary" style="width:93px; height: 38px; padding: 5px;margin:2px" data-toggle="modal" data-target="#modals" id="news" name="news">Nuevo</button>
                    
                </div>
                <input type="hidden" name="elec" id="elec" value="1"><br>
            </form>
        
              <div id="resultados"></div>
        
        </div>
        <div class="modal fade bd-example-modal-xl" id="modals" tabindex="-1" role="dialog" aria-labelledby="myExtraLargeModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-xl" role="document">
              <div class="modal-content">
                  <div class="modal-header">
                      <h4 style="color:#045FB4;text-align: center" >Información Técnico </h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body">
                    <form action="../Tecnico" method="POST" id="formulario">
        <div class="container">
            
            <div class="form-row">
                <div class="form-group col-md-2">
                    <label class="control-label">Codigo:</label>
                    <input class="form-control" name="txtcodigo" id="txtcodigo" type="text" placeholder="00" disabled>
                </div>
                <div class="form-group col-md-5">
                    <label class="control-label">Nombre Completo:</label>
                    <input class="form-control" name="txtnombres" id="txtnombres" type="text" placeholder="">
                </div>
                <div class="form-group col-md-5">
                    <label class="control-label">Teléfono:</label>
                    <input class="form-control" name="txttelefono" id="txttelefono" type="text" placeholder="">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-5">
                    <label class="control-label">Correo Electrónico</label>
                    <input class="form-control" name="txtcorreo" id="txtcorreo" type="text" placeholder="">
                </div>
                
            </div>
            <div class="form-row">
                <div class="form-group col-md-5">
                    <label class="control-label">Usuario</label>
                    <input class="form-control" name="txtusuario" id="txtusuario" type="text" placeholder="">
                </div>
                <div class="form-group col-md-5">
                    <label class="control-label">Clave</label>
                    <input class="form-control" name="txtclave" id="txtclave" type="text" placeholder="">
                </div>
            </div>
            
            <div class="form-row">
                 
                <%
                    
              
                    if(tip.equals("administrador")){
                  %>  
                    <div class="form-group col-md-6">
                    <label class="control-label">Supervisor:</label>
                    <select id="txtsupervisor" name="txtsupervisor" class="form-control" onchange="cambio();"  >
                    <%
                        TecnicoClass clsEstudiante  = new TecnicoClass();
                        List<List<String>> lista = clsEstudiante.supervisores();
                        for(int i=0;i< lista.get(0).size() ;i++){
                           out.println("<option value='" +lista.get(0).get(i) +"'>" +lista.get(1).get(i) +"</option>");
                        }   
                    %>
                    </select>
                </div>
                <%}
                else{%>  
                   <div class="form-group col-md-7" hidden>
                    <label class="control-label">Supervisor:</label>
                    <input class="form-control" name="txtsuperviso" id="txtsuperviso" type="text" placeholder="" value="<%=use%>">
                </div>
                <%}%>
               
                
            </div>
        
        
            <div class="form-row justify-content">
                <div class="form-group">
                   <button name="actualizar" id="actualizar" value="1" type="submit" class="btn btn-primary"> Guardar </button>	
                   
                   <button style="display:none" name="actualizar1" id="actualizar1" value="2" type="submit" class="btn btn-success"> Guardar Cambios </button>	

                   <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
            
                </div>
            </div>
        </div>
        </form>
                    <hr>
        <div id="foot" style="display:none">
            <div id="resultados1"></div>
            <br>
            <button style="display:none" id="acept" name="acept" class="btn btn-warning" data-dismiss="modal">Aceptar</button>
        </div>
        </div>
        
               
              </div>
            </div>
        </div>
        
      
        <div class="modal fade modal2" id="modal2" tabindex="-1" role="dialog" aria-labelledby="myExtraLargeModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-xl" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                      <h4 style="color:#FE2E2E;text-align: center" >Elimnar Registro</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                <div class="modal-body">
                    <div class="container">
                                <label hidden style="padding: 2px" id="lbcodigo"></label>
                        <br>
                        <div class="row">
                            
                            <div class="col">
                                <label style="font-weight: bold;padding: 2px">Nombres: </label>
                                <label style="padding: 2px" id="lbnombres"></label>
                            </div>
                            
                        </div>
                        <div class="row">
                            <div class="col">
                                <label style="font-weight: bold;padding: 2px">Teléfono: </label>
                                <label style="padding: 2px" id="lbtelefono"></label>
                            </div>
                            <div class="col">
                                <label style="font-weight: bold;padding: 2px">Correo: </label>
                                <label style="padding: 2px" id="lbcorreo"></label>
                            </div>
                            
                        </div>
                       <div class="row">
                            <div class="col">
                                <label style="font-weight: bold;padding: 2px">Día Libre: </label>
                                <label style="padding: 2px" id="lbdia"></label>
                            </div>
                            <div class="col">
                                <label style="font-weight: bold;padding: 2px">Supervisor: </label>
                                <label style="padding: 2px" id="lbsupervisor"></label>
                            </div>
                            
                        </div>
                        
                        
                        <br>
                        <div class="row">
                            <div class="col" style="text-align:center;">
                                <label style="font-weight: bold;padding: 2px">¿ Desea eliminar la información del técnico ? </label>
                            </div>                            
                        </div>
                        <div class="row">
                            <div class="col" style="text-align:center;">
                                <button class="btn btn-danger" id="actualizar2" name="actualizar2" value="3">Si</button>
                                <button class="btn btn-primary" data-dismiss="modal" >No</button>
                            </div>                            
                        </div>
                        <div class="row">
                            <div class="col" style="text-align:center;">
                                <label  style="font-weight: bold;padding: 2px;color:#FE2E2E;font-size:85%"> La información eliminada no se puede recuperar </label>
                            </div>                            
                        </div>
                        
                    </div>
                    <hr>
                    <div id="foot2" style="display:none">
            <div id="resultados2"></div>
            <br>
            <button style="display:none" id="acept2" name="acept2" class="btn btn-warning" data-dismiss="modal">Aceptar</button>
        </div>
                </div>
                </div>
            </div>
        </div>
        
            
            <br><br>
    </body>
    
    
    
</html>
