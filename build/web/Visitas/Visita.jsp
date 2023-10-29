<%-- 
    Document   : Principal
    Created on : 21/10/2023, 07:27:23 PM
    Author     : Enmanuel
--%>



<%@page import="java.util.List"%>
<%@include file="../Principal.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">      
        <script src="js/jquery2.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/ajaxP.js" type="text/javascript"></script>
        <script src="grados.js" type="text/javascript"></script>
        
    </head>
    <body>
        <br>
        
        <%
         
          
        String us="";
        try{
            
             us=request.getParameter("h");
             System.out.println(us);
        
        }catch(Exception e){
            System.out.println(e);
        }
        %>
        
        
        <div class="container">
            <h4 style="color:#007bff;text-align: center" >Visitas</h4>
            <br>
            <form class="form-horizontal" action="" method="POST" name="buscador_form" id="buscador_form" hidden >
                <br>
                <div class="row" hidden>
                    <label class="control-label col-md-2">Buscador por nombre: </label>
                    <div class="col-md-10">
                        <input type="text" name="search" id="search" class="form-control" placeholder="" value="<%=us%>">
                    </div>
                </div>
                <br>
                <div class="form-row" style="justify-content: center">
                        <a href="../Principal/" class="btn btn-info" style="width:93px;height: 38px; padding: 5px;margin:2px" > Regresar  </a>
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
                      <h4 style="color:#045FB4;text-align: center" >Finalizar Visita</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body">
                    <form action="../Visita" method="POST" id="formulario">
        <div class="container">
            
            <div class="form-row" hidden >
                    <label class="control-label">Codigo:</label>
                    <input class="form-control" name="txtcodigo" id="txtcodigo" type="text" placeholder="" >
                
                    <label class="control-label">Técnico:</label>
                    <input class="form-control" name="txttecnico" id="txttecnico" type="text" placeholder="" value="<%=String.valueOf(sesion.getAttribute("acceso"))%>" >
                
                    <label class="control-label">Cliente:</label>
                    <input class="form-control" name="txtcliente" id="txtcliente" type="text" placeholder="">
                
                    <label class="control-label">fecha1:</label>
                    <input class="form-control" name="txtingreso" id="txtingreso" type="text" placeholder="">
                <label class="control-label">fecha2:</label>
                    <input class="form-control" name="txtegreso" id="txtegreso" type="text" placeholder="">
                <label class="control-label">coordenada:</label>
                    <input class="form-control" name="txtcoordenada" id="txtcoordenada" type="text" placeholder="">
                    <label class="control-label">correo:</label>
                    <input class="form-control" name="txtcorreo" id="txtcorreo" type="text" placeholder="">
            </div>
            <div class="">
                <div class="col-md-16">
                    <label class="control-label">Reporte Final:</label>
                    <textarea class="form-control" name="txtreporte" id="txtreporte" rows="7" ></textarea>
                </div>
                
                
            </div>
                <hr>
                <hr>
            
        
            <div class="form-row justify-content">
                <div class="form-group">
                   
                   
                   <button style="" name="actualizar1" id="actualizar1" value="2" type="submit" class="btn btn-success"> Guardar Cambios </button>	

                   <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
            
                </div>
            </div>
        </div>
        </form>
                    <hr>
        <div id="foot" style="display:show">
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
                      <h4 style="color:#FE2E2E;text-align: center" >Iniciar Visita</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                <div class="modal-body">
                    <div class="container">
                                <label hidden style="padding: 2px" id="lbcodigo"></label>
                        <br>
                        <div class="row">
                            
                            
                        </div>
                        <div class="row">
                            <div class="col">
                                <label style="font-weight: bold;padding: 2px">Cliente: </label>
                                <label style="padding: 2px" id="lbcliente"></label>
                            </div>
                            <div class="col">
                                <label style="font-weight: bold;padding: 2px">Fecha Inicio: </label>
                                <label style="padding: 2px" id="lbinicio"></label>
                            </div>
                            
                        </div>
                       <div class="row">
                            <div class="col">
                                <label style="font-weight: bold;padding: 2px">Fecha Fin: </label>
                                <label style="padding: 2px" id="lbfin"></label>
                            </div>
                            <div class="col">
                                <label style="font-weight: bold;padding: 2px">Coordenadas: </label>
                                <label style="padding: 2px" id="lbcoordenada"></label>
                            </div>
                            
                        </div>
                        
                        
                        <br>
                        <div class="" >
                        <form action="../Visita" method="POST" id="formulario2">
                        <div class="form-row" style="display:none">
                
                    <label class="control-label">Codigo:</label>
                    <input class="form-control" name="txtcodigo2" id="txtcodigo2" type="text" placeholder="" >
                
                    <label class="control-label">Técnico:</label>
                    <input class="form-control" name="txttecnico2" id="txttecnico2" type="text" placeholder="" value="<%=String.valueOf(sesion.getAttribute("acceso"))%>" >
                
                    <label class="control-label">Cliente:</label>
                    <input class="form-control" name="txtcliente2" id="txtcliente2" type="text" placeholder="">
                
                    <label class="control-label">fecha1:</label>
                    <input class="form-control" name="txtingreso2" id="txtingresos2" type="text" placeholder="">
                <label class="control-label">fecha2:</label>
                    <input class="form-control" name="txtegreso2" id="txtegreso2" type="text" placeholder="">
                <label class="control-label">coordenada:</label>
                    <input class="form-control" name="txtcoordenada2" id="txtcoordenada2" type="text" placeholder="">
                
                    <label class="control-label">Reporte Final:</label>
                    <textarea class="form-control" name="txtreporte2" id="txtreporte2" rows="7" ></textarea>
                
                </form>
            </div>
                        
                        <div class="row">
                            <div class="col" style="text-align:center;">
                                <label style="font-weight: bold;padding: 2px">¿ Desea iniciar la visita? </label>
                            </div>                            
                        </div>
                        <div class="row">
                            <div class="col" style="text-align:center;">
                                <button class="btn btn-danger" id="actualizar2" name="actualizar2" value="4">Si</button>
                                <button class="btn btn-primary" data-dismiss="modal" >No</button>
                            </div>                            
                        </div>
                        <div class="row">
                            <div class="col" style="text-align:center;">
                                
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
