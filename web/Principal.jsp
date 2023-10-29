<%-- 
    Document   : Principal
    Created on : 21/10/2023, 07:27:23 PM
    Author     : Enmanuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="img/ECCV.ico"/>
    <title>Skynet System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  </head>
  <body>
      
      <%
  
        HttpSession sesion= request.getSession();
        String user="";
        String ciclo="";
        try{
            
             user=String.valueOf(sesion.getAttribute("nombre"));
            ciclo=String.valueOf(sesion.getAttribute("tipo"));        
        
        }catch(Exception e){
            System.out.println(e);
        }
        
  
  %>
    
      <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="/skynet_system/index.jsp">Skynet Sistema</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        
        
            <%if(ciclo.equals("administrador") ){ %>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Supervisores
                </a>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="/skynet_system/Supervisores/Nuevo.jsp">Nuevo</a></li>
                  
                </ul>
              </li>

            <%}
            else{%>
                
            <%}
            %>
            <%if(ciclo.equals("administrador") || ciclo.equals("supervisor")){ %>
             <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Técnicos
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/skynet_system/Tecnicos/Nuevo.jsp">Nuevo</a></li>
            
          </ul>
        </li>    
            <%}
            else{%>
                
            <%}
            %>
            <%if(ciclo.equals("administrador")  || ciclo.equals("supervisor")){ %>
            <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Clientes
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/skynet_system/Clientes/Nuevo.jsp">Nuevo</a></li>
            
          </ul>
        </li>
        
            <%}
            else{%>
                
            <%}
            %>
            <%if( ciclo.equals("tecnico")){ %>
            <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Visitas
          </a>
          <ul class="dropdown-menu">
            <li><a class="nav-link" href="/skynet_system/Visitas/Visita.jsp?h=0">Visitas Programadas</a></li>
            <li><a class="nav-link" href="/skynet_system/Visitas/Visita.jsp?h=1">Visitas Historial</a></li>
            
          </ul>
        </li>
            
            <%}
            else{%>
                <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Visitas
          </a>
          <ul class="dropdown-menu">
            
            <li><a class="nav-link" href="/skynet_system/Visitas/Nuevo.jsp?h=1">Nuevo</a></li>
            
          </ul>
        </li>
            
            <%}
            %>
          <li class="nav-item">
          <a class="nav-link" href="/skynet_system/Principal.jsp?cerrar=true">Cerrar Sesión</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
      
      
  <br> 
      <h5><% 
          System.out.println(request.getParameter("cerrar"));
          
          try{
             if(request.getParameter("cerrar").equals("true")){
                System.out.println("cerrando sesion");
                session.invalidate();
                out.print("<script>location.replace('/skynet_system/index.jsp');</script>");
            } 
          }
          catch(Exception e){
          out.print("   Bienvenido al sistema: "+user);
          }
          %><h5>
      
      
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>