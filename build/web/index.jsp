<%-- 
    Document   : index
    Created on : 21/10/2023, 06:05:27 PM
    Author     : Enmanuel
--%>

<%@page import="java.util.Calendar"%>

<%@page session="true"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="img/ECCV.ico"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1,minimum-scale=1">
        
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilos_login.css" rel="stylesheet" type="text/css"/>
        
        <script type="text/javascript" src="js/jquery2.js"></script>
        
        
        
        <title>Inicio</title>
          <%
  
        HttpSession sesion= request.getSession();
        String user="";String ciclo="";        
        try{
            if(sesion.getAttribute("nombre")!=null && sesion.getAttribute("tipo")!=null){
                    //out.print("<script>location.replace('/Inicio/');</script>");
                    out.print("<script>location.replace('/skynet_system/Principal.jsp');</script>");
            }
       
        }catch(Exception e){
            System.out.println(e);
        }
        
  
  %>
        
        
    <body>

        
        <div class="container">
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            <img id="profile-img" class="profile-img-card" src="img/ECCV.jpg" />
            <p id="profile-name" class="profile-name-card"></p>
            <form class="form-signin" action="Usuario" method="post">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="text" name="usuario" id="usuario" class="form-control" placeholder="Usuario" required autofocus>
                <br>
                <input type="password" name="contrasena" id="contrasena" class="form-control" placeholder="Contraseña" required>
                
                <%
                    Calendar fecha = Calendar.getInstance();
                %>
                <input id="dropcic" name="dropcic" value="<%=fecha.get(Calendar.YEAR)%>" hidden >
                <br>
                <div id="resultados"></div>
                <button name="ingresar" style="" id="ingresar" class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Entrar</button>
                
            </form><!-- /form -->
            
        </div><!-- /card-container -->
    </div><!-- /container -->
    
    </body>
</html>
