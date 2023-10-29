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
public class TecnicoClass {
    
    private long cod_cliente;
    private String nombre, telefono, correo, cod_supervisor;
    private String nom;
    
    private String usuario, clave;
    
    public String PATH="https://skynetapi-d19f8eab66ba.herokuapp.com/api";
    
    public TecnicoClass() {
    }

    public long getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(long cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    

    public String getCod_supervisor() {
        return cod_supervisor;
    }

    public void setCod_supervisor(String cod_supervisor) {
        this.cod_supervisor = cod_supervisor;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    
    
    
    
    
    public  List<TecnicoClass> buscar(String criterio )
    {
   List<TecnicoClass>  tabla = new ArrayList<TecnicoClass>();
   
    try{
  
          try {
            // TODO add your handling code here:
            URL url = new URL(PATH+"/tecnico");
            
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
                        TecnicoClass buscar = new TecnicoClass();
                        buscar.setCod_cliente(dato.getInt("cod_tecnico"));
                        buscar.setNombre(dato.getString("nombre"));
                        buscar.setTelefono(dato.getString("telefono"));
                        buscar.setCorreo(dato.getString("correo"));
                        buscar.setUsuario(dato.getString("usuario"));
                        buscar.setClave(dato.getString("clave"));
                        buscar.setCod_supervisor(String.valueOf(dato.getInt("cod_supervisor")));
                        
                        buscar.setNom(nombresupervisor(buscar.getCod_supervisor()));
                        
                        
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
   
   public  List<TecnicoClass> buscarFil(String criterio )
{
   List<TecnicoClass>  tabla = new ArrayList<TecnicoClass>();
   
    try{
  
          try {
            // TODO add your handling code here:
            URL url = new URL(PATH+"/tecnicos/"+criterio);
              
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
                        TecnicoClass buscar = new TecnicoClass();
                        buscar.setCod_cliente(dato.getInt("cod_tecnico"));
                        buscar.setNombre(dato.getString("nombre"));
                        buscar.setTelefono(dato.getString("telefono"));
                        buscar.setCorreo(dato.getString("correo"));
                        buscar.setUsuario(dato.getString("usuario"));
                        buscar.setClave(dato.getString("clave"));
                        buscar.setCod_supervisor(String.valueOf(dato.getInt("cod_supervisor")));
                        buscar.setNom(nombresupervisor(buscar.getCod_supervisor()));
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
   
   
   
    
   public int nuevo(TecnicoClass nuevo2){
       int resultado=0;
       
       
       try {
            // TODO add your handling code here:
            URL url = new URL(PATH+"/tecnico");
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            
            
            JSONObject objeto = new JSONObject(nuevo2);
            
            String jsonText = objeto.toString();
            
            System.out.println("El json"+jsonText);
            
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
   
   
    
   public int modificar(TecnicoClass nuevo2){
       int resultado=0;
       
       
       try {
            // TODO add your handling code here:
            URL url = new URL(PATH+"/tecnico/"+nuevo2.getCod_cliente());
            
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
            URL url = new URL(PATH+"/tecnico/"+codigo);
            
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
    

   public List<List<String>> supervisores()            
    {
    
    List<List<String>> lista = new ArrayList<List<String>>();
        lista.add(new ArrayList<String>());
        lista.add(new ArrayList<String>());
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
                
                 lista.get(0).add("0");
                 lista.get(1).add(" -- Seleccione Supervisor -- ");
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
                        
                        
                        lista.get(0).add(String.valueOf(buscar.getCod_supervisor()));
                        lista.get(1).add(buscar.getNombres()+" "+buscar.getApellidos());

                        
                    }
                }
                
                
            }
            
            
        } catch (Exception ex) {
            System.out.println(ex);
            
        }
           return lista;

      
}


public String nombresupervisor(String codi)            
    {
    
    String respuest="";
    try {
            // TODO add your handling code here:
            URL url = new URL(PATH+"/supervisor/" + codi);
            
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
                    
                        JSONObject dato = new JSONObject(String.valueOf(info));
                        SupervisorClass buscar = new SupervisorClass();
                        buscar.setCod_supervisor(dato.getInt("cod_supervisor"));
                        buscar.setNombres(dato.getString("nombres"));
                        buscar.setApellidos(dato.getString("apellidos"));
                        buscar.setTelefono(dato.getString("telefono"));
                        buscar.setCoreo(dato.getString("coreo"));
                        
                    respuest = buscar.getNombres() + " "+buscar.getApellidos();
                }
                
                
            }
            
            
        } catch (Exception ex) {
            System.out.println(ex);
            
        }
           return respuest;

      
}
   
    
}
