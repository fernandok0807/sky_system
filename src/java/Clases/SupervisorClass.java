/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Enmanuel
 */
public class SupervisorClass {
    
    private long cod_supervisor;
    String nombres, apellidos,telefono,coreo;
    String usuario,clave;

    public String PATH="https://skynetapi-d19f8eab66ba.herokuapp.com/api";
    
    public SupervisorClass() {
    }

    public long getCod_supervisor() {
        return cod_supervisor;
    }

    public void setCod_supervisor(long cod_supervisor) {
        this.cod_supervisor = cod_supervisor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCoreo() {
        return coreo;
    }

    public void setCoreo(String coreo) {
        this.coreo = coreo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
     public  List<SupervisorClass> buscar(String criterio )
{
   List<SupervisorClass>  tabla = new ArrayList<SupervisorClass>();
   
    try{
  
          try {
            // TODO add your handling code here:
            URL url = new URL(PATH+"/supervisor");
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.connect();
            
            int respuesta = conn.getResponseCode();
            
            if(respuesta!=200){
                System.out.println("Ocurrio un error");
                
            }
            else{
                StringBuilder info = new StringBuilder();
                Scanner scan = new Scanner(url.openStream(),"UTF-8");
                
                while(scan.hasNext()){
                    info.append(scan.nextLine());
                    

                }
                scan.close();
                System.out.println(info);
                
                if(String.valueOf(info).equals("")){
                    
                }
                else{
                    
                    JSONArray datos = new JSONArray(String.valueOf(info));
                    
                    System.out.println(datos.length());
                    for (int i = 0; i < datos.length(); i++) {
                        
                        JSONObject dato = datos.getJSONObject(i);
                        SupervisorClass buscar = new SupervisorClass();
                        buscar.setCod_supervisor(dato.getInt("cod_supervisor"));
                        buscar.setNombres(dato.getString("nombres"));
                        buscar.setApellidos(dato.getString("apellidos"));
                        buscar.setTelefono(dato.getString("telefono"));
                        buscar.setCoreo(dato.getString("coreo"));
                        buscar.setUsuario(dato.getString("usuario"));
                        buscar.setClave(dato.getString("clave"));
                        
                        tabla.add(buscar);

                        
                    }
                }
                
                
            }
            
            
        } catch (Exception ex) {
            System.out.println(ex);
            
        }
       
       

        
       
                    
    }    
    catch (Exception ex) {
           System.out.println(ex);
    }
    return tabla;
} 
   
   public  List<SupervisorClass> buscarFil(String criterio )
{
   List<SupervisorClass>  tabla = new ArrayList<SupervisorClass>();
   
    try{
  
          try {
            // TODO add your handling code here:
            URL url = new URL(PATH+"/supervisores/"+criterio);
              
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.connect();
            
            int respuesta = conn.getResponseCode();
            
            if(respuesta!=200){
                System.out.println("Ocurrio un error");
                
            }
            else{
                StringBuilder info = new StringBuilder();
                Scanner scan = new Scanner(url.openStream(),"UTF-8");
                
                while(scan.hasNext()){
                    info.append(scan.nextLine());
                    

                }
                scan.close();
                System.out.println(info);
                
                if(String.valueOf(info).equals("")){
                    
                }
                else{
                    
                    JSONArray datos = new JSONArray(String.valueOf(info));
                    
                    System.out.println(datos.length());
                    for (int i = 0; i < datos.length(); i++) {
                        
                         JSONObject dato = datos.getJSONObject(i);
                        SupervisorClass buscar = new SupervisorClass();
                        buscar.setCod_supervisor(dato.getInt("cod_supervisor"));
                        buscar.setNombres(dato.getString("nombres"));
                        buscar.setApellidos(dato.getString("apellidos"));
                        buscar.setTelefono(dato.getString("telefono"));
                        buscar.setCoreo(dato.getString("coreo"));
                        buscar.setUsuario(dato.getString("usuario"));
                        buscar.setClave(dato.getString("clave"));
                        tabla.add(buscar);

                        
                    }
                }
                
                
            }
            
            
        } catch (Exception ex) {
            System.out.println(ex);
            
        }
       
       

        
       
                    
    }    
    catch (Exception ex) {
           System.out.println(ex);
    }
    return tabla;
} 
   
   
   
    
   public int nuevo(SupervisorClass nuevo2){
       int resultado=0;
       
       
       try {
            // TODO add your handling code here:
            URL url = new URL(PATH+"/supervisor");
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            
            
            JSONObject objeto = new JSONObject(nuevo2);
            
            String jsonText = objeto.toString();
            
            System.out.println(jsonText);
            
            try(
                OutputStream escribir = conn.getOutputStream()) {
                byte[] entrada = jsonText.getBytes("utf-8");
                escribir.write(entrada, 0, entrada.length);	
                try(
                    BufferedReader leer = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                      StringBuilder respuesta = new StringBuilder();
                      String respuetaTemporal = null;
                      while ((respuetaTemporal = leer.readLine()) != null) {
                          respuesta.append(respuetaTemporal.trim());
                      }
                      
                      
                      resultado=1;
                }
                catch(Exception e){
                    System.out.println(e);
                    resultado=0;
                }
                
                
            }
            catch(Exception e){
                System.out.println(e);
                resultado=0;
            }
            
        } catch (Exception ex) {
            System.out.println(ex);
            resultado=0;
        }
       
       
       
       return resultado;
   }
   
   
    
   public int modificar(SupervisorClass nuevo2){
       int resultado=0;
       
       
       try {
            // TODO add your handling code here:
            URL url = new URL(PATH+"/supervisor/"+nuevo2.getCod_supervisor());
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            
            
            JSONObject objeto = new JSONObject(nuevo2);
            
            String jsonText = objeto.toString();
            
            System.out.println(jsonText);
            
            try(
                OutputStream escribir = conn.getOutputStream()) {
                byte[] entrada = jsonText.getBytes("utf-8");
                escribir.write(entrada, 0, entrada.length);	
                try(
                    BufferedReader leer = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                      StringBuilder respuesta = new StringBuilder();
                      String respuetaTemporal = null;
                      while ((respuetaTemporal = leer.readLine()) != null) {
                          respuesta.append(respuetaTemporal.trim());
                      }
                      
                      System.out.println("Respuesta de Ingreso"+respuesta.toString());
                      resultado=1;
                }
                catch(Exception e){
                    System.out.println(e);
                    resultado=0;
                }
                
                
            }
            catch(Exception e){
                System.out.println(e);
                resultado=0;
            }
            
        } catch (Exception ex) {
            System.out.println(ex);
            resultado=0;
        }
       
       
       return resultado;
   }
   
   
   public int eliminar(String codigo){
       int resultado=0;
       
        try {
            // TODO add your handling code here:
            URL url = new URL(PATH+"/supervisor/"+codigo);
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");
            
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            
            
            
            
            String jsonText = "";
            
            System.out.println(jsonText);
            
            try(
                OutputStream escribir = conn.getOutputStream()) {
                byte[] entrada = jsonText.getBytes("utf-8");
                escribir.write(entrada, 0, entrada.length);	
                try(
                    BufferedReader leer = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                      StringBuilder respuesta = new StringBuilder();
                      String respuetaTemporal = null;
                      while ((respuetaTemporal = leer.readLine()) != null) {
                          respuesta.append(respuetaTemporal.trim());
                      }
                      
                      System.out.println("Respuesta de Ingreso"+respuesta.toString());
                      resultado=1;
                }
                catch(Exception e){
                    System.out.println(e);
                    resultado=0;
                }
                
                
            }
            catch(Exception e){
                System.out.println(e);
                resultado=0;
            }
            
        } catch (Exception ex) {
            System.out.println(ex);
            resultado=0;
        }
       
      
       
       return resultado;
   }
    

    
}
