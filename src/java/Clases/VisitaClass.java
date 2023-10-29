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
public class VisitaClass {
    
    private long cod_cliente, codtecnico, cod_visita;
    private String ingreso, egreso, coordenada,reporte;
    
    
    private String nombreCliente,correoCliente;
            
    public String PATH="https://skynetapi-d19f8eab66ba.herokuapp.com/api";
    
    public VisitaClass() {
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    

    public long getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(long cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public long getCodtecnico() {
        return codtecnico;
    }

    public void setCodtecnico(long codtecnico) {
        this.codtecnico = codtecnico;
    }

    public long getCod_visita() {
        return cod_visita;
    }

    public void setCod_visita(long cod_visita) {
        this.cod_visita = cod_visita;
    }

    public String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    public String getEgreso() {
        return egreso;
    }

    public void setEgreso(String egreso) {
        this.egreso = egreso;
    }

    public String getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(String coordenada) {
        this.coordenada = coordenada;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    
    
    
     public  List<VisitaClass> buscar(String criterio )
{
   List<VisitaClass>  tabla = new ArrayList<VisitaClass>();
   
    try{
  
          try {
            // TODO add your handling code here:
            URL url = new URL(PATH+"/visita");
            
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
                    
                    String abc = String.valueOf(info);
                    abc = abc.replaceAll("null","\"null\"");
                    JSONArray datos = new JSONArray(abc);
                    System.out.println(datos.toString());
                    System.out.println(datos.length());
                    for (int i = 0; i < datos.length(); i++) {
                        
                        JSONObject dato = datos.getJSONObject(i);
                        VisitaClass buscar = new VisitaClass();
                        buscar.setCod_visita(dato.getInt("cod_visita"));
                        buscar.setCodtecnico(dato.getInt("cod_tecnico"));
                        buscar.setCod_cliente(dato.getInt("cod_cliente"));
                        
                        if(dato.getString("ingreso").equals("null")){
                            buscar.setIngreso("");
                        }
                        else{
                            buscar.setIngreso((dato.getString("ingreso")));
                        }
                            
                        if(dato.getString("egreso").equals("null")){
                            buscar.setEgreso("");
                        }
                        else{
                            buscar.setEgreso((dato.getString("egreso")));
                        }
                            
                        if(dato.getString("reporte").equals("null")){
                            buscar.setReporte("");
                        }
                        else{
                            buscar.setReporte((dato.getString("reporte")));
                        }
                        
                        buscar.setCoordenada(dato.getString("coordenada"));
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
   
   public  List<VisitaClass> buscar2(String criterio,String codigo )
{
   List<VisitaClass>  tabla = new ArrayList<VisitaClass>();
   
    try{
  
          try {
            // TODO add your handling code here:
            URL url = new URL(PATH+"/visitas/"+codigo);
            
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
                    
                    String abc = String.valueOf(info);
                    abc = abc.replaceAll("null","\"null\"");
                    JSONArray datos = new JSONArray(abc);
                    //System.out.println(datos.toString());
                    //System.out.println(datos.length());
                    for (int i = 0; i < datos.length(); i++) {
                        
                        JSONObject dato = datos.getJSONObject(i);
                        VisitaClass buscar = new VisitaClass();
                        buscar.setCod_visita(dato.getInt("cod_visita"));
                        buscar.setCodtecnico(dato.getInt("codtecnico"));
                        buscar.setCod_cliente(dato.getInt("cod_cliente"));
                        if(dato.getString("ingreso").equals("null")){
                            buscar.setIngreso("");
                        }
                        else{
                            buscar.setIngreso((dato.getString("ingreso")));
                        }
                            
                        if(dato.getString("egreso").equals("null")){
                            buscar.setEgreso("");
                        }
                        else{
                            buscar.setEgreso((dato.getString("egreso")));
                        }
                            
                        if(dato.getString("reporte").equals("null")){
                            buscar.setReporte("");
                        }
                        else{
                            buscar.setReporte((dato.getString("reporte")));
                        }
                        
                        buscar.setNombreCliente(nombrecliente(String.valueOf(dato.getInt("cod_cliente"))));
                        buscar.setCorreoCliente(correoCliente(String.valueOf(dato.getInt("cod_cliente"))));
                        buscar.setCoordenada(dato.getString("coordenada"));
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
     
     
   public  List<VisitaClass> buscarFil(String criterio )
{
   List<VisitaClass>  tabla = new ArrayList<VisitaClass>();
   
    try{
  
          try {
            // TODO add your handling code here:
            URL url = new URL(PATH+"/visitas/"+criterio);
              
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
                    
                    String abc = String.valueOf(info);
                    abc = abc.replaceAll("null","\"null\"");
                    
                    JSONArray datos = new JSONArray(String.valueOf(abc));
                    
                    System.out.println(datos.length());
                    for (int i = 0; i < datos.length(); i++) {
                        
                        JSONObject dato = datos.getJSONObject(i);
                        VisitaClass buscar = new VisitaClass();
                        buscar.setCod_visita(dato.getInt("cod_visita"));
                        buscar.setCodtecnico(dato.getInt("codtecnico"));
                        buscar.setCod_cliente(dato.getInt("cod_cliente"));
                        if(dato.getString("ingreso").equals("null")){
                            buscar.setIngreso("");
                        }
                        else{
                            buscar.setIngreso((dato.getString("ingreso")));
                        }
                            
                        if(dato.getString("egreso").equals("null")){
                            buscar.setEgreso("");
                        }
                        else{
                            buscar.setEgreso((dato.getString("egreso")));
                        }
                        
                        if(dato.getString("reporte").equals("null")){
                            buscar.setReporte("");
                        }
                        else{
                            buscar.setReporte((dato.getString("reporte")));
                        }
                            
                        
                            
                        
                        
                        buscar.setNombreCliente(nombrecliente(String.valueOf(dato.getInt("cod_cliente"))));
                        
                        buscar.setCoordenada(dato.getString("coordenada"));
                        buscar.setReporte(dato.getString("reporte"));
                        
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
   
   
   
    
   public int nuevo(VisitaClass nuevo2){
       int resultado=0;
       
       
       try {
            // TODO add your handling code here:
            URL url = new URL(PATH+"/visita");
            
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
   
   
    
   public int modificar(VisitaClass nuevo2){
       int resultado=0;
       
       
       try {
            // TODO add your handling code here:
            URL url = new URL(PATH+"/visita/"+nuevo2.getCod_visita());
            
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
            URL url = new URL(PATH+"/visita/"+codigo);
            
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
   
   
   
   public String nombrecliente(String codi)            
    {
    
    String respuest="";
    try {
            // TODO add your handling code here:
            URL url = new URL(PATH+"/cliente/" + codi);
            
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
                        ClienteClass buscar = new ClienteClass();
                        buscar.setCod_cliente(dato.getInt("cod_cliente"));
                        buscar.setNombre(dato.getString("nombre"));
                        buscar.setTelefono(dato.getString("telefono"));
                        buscar.setCorreo(dato.getString("correo"));
                        buscar.setDireccion(dato.getString("direccion"));
                        buscar.setCoordenadas(dato.getString("coordenadas"));
                        
                    respuest = buscar.getNombre() ;
                }
                
                
            }
            
            
        } catch (Exception ex) {
            System.out.println(ex);
            
        }
           return respuest;

     

   
    
}

    
public String correoCliente(String codi)            
    {
    
    String respuest="";
    try {
            // TODO add your handling code here:
            URL url = new URL(PATH+"/cliente/" + codi);
            
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
                        ClienteClass buscar = new ClienteClass();
                        buscar.setCod_cliente(dato.getInt("cod_cliente"));
                        buscar.setNombre(dato.getString("nombre"));
                        buscar.setTelefono(dato.getString("telefono"));
                        buscar.setCorreo(dato.getString("correo"));
                        buscar.setDireccion(dato.getString("direccion"));
                        buscar.setCoordenadas(dato.getString("coordenadas"));
                        
                    respuest = buscar.getCorreo() ;
                }
                
                
            }
            
            
        } catch (Exception ex) {
            System.out.println(ex);
            
        }
           return respuest;

     

   
    
}

public List<List<String>> tecnicos(String superv)            
    {
    
    List<List<String>> lista = new ArrayList<List<String>>();
        lista.add(new ArrayList<String>());
        lista.add(new ArrayList<String>());
              try {
            
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
                
                 lista.get(0).add("0");
                 lista.get(1).add(" -- Seleccione Técnico -- ");
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
                        
                        if(dato.getInt("cod_supervisor")==Integer.parseInt(superv)){
                            lista.get(0).add(String.valueOf(buscar.getCod_cliente()));
                        lista.get(1).add(buscar.getNombre());
                        }
                        else{
                            
                        }
                    }
                }
            }
            
            
        } catch (Exception ex) {
            System.out.println(ex);
            
        }
           return lista;

      
}

public List<List<String>> clientes(String superv)            
    {
    
    List<List<String>> lista = new ArrayList<List<String>>();
        lista.add(new ArrayList<String>());
        lista.add(new ArrayList<String>());
              try {
            // TODO add your handling code here:
            URL url = new URL(PATH+"/cliente");
            
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
                 lista.get(1).add(" -- Seleccione Cliente -- ");
                if(String.valueOf(info).equals("")){
                    
                }
                else{
                    
                    JSONArray datos = new JSONArray(String.valueOf(info));
                    
                    //System.out.println(datos.length());
                    for (int i = 0; i < datos.length(); i++) {
                        
                        JSONObject dato = datos.getJSONObject(i);
                        ClienteClass buscar = new ClienteClass();
                        buscar.setCod_cliente(dato.getInt("cod_cliente"));
                        buscar.setNombre(dato.getString("nombre"));
                        
                        
                        lista.get(0).add(String.valueOf(buscar.getCod_cliente()));
                        lista.get(1).add(buscar.getNombre());
                        
                    }
                }
            }
            
            
        } catch (Exception ex) {
            System.out.println(ex);
            
        }
           return lista;

      
}

public String coordenadasCliente(String codi)            
    {
    
    String respuest="";
    try {
            // TODO add your handling code here:
            URL url = new URL(PATH+"/cliente/" + codi);
            
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
                        ClienteClass buscar = new ClienteClass();
                        buscar.setCod_cliente(dato.getInt("cod_cliente"));
                        buscar.setNombre(dato.getString("nombre"));
                        buscar.setTelefono(dato.getString("telefono"));
                        buscar.setCorreo(dato.getString("correo"));
                        buscar.setDireccion(dato.getString("direccion"));
                        buscar.setCoordenadas(dato.getString("coordenadas"));
                        
                    respuest = buscar.getCoordenadas() ;
                }
                
                
            }
            
            
        } catch (Exception ex) {
            System.out.println(ex);
            
        }
           return respuest;

     

   
    
}
   
    
}
