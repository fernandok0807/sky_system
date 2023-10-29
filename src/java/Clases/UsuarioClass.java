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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Enmanuel
 */
public class UsuarioClass {
 
    private long cod_usuario;
    String nombre, usuario, clave, tipo;

    public String PATH="https://skynetapi-d19f8eab66ba.herokuapp.com/api";
    
    public long getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(long cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
   
   
   
   public UsuarioClass Ingresar(String usuario, String clave){
        UsuarioClass resultado;
       
       try {
            URL url = new URL(PATH+"/supervisor/"+usuario+"/"+clave);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.connect();
            int respuesta = conn.getResponseCode();
            if(respuesta!=200){
                System.out.println("Ocurrio un error");
                resultado=null;
            }
            else{
                StringBuilder info = new StringBuilder();
                Scanner scan = new Scanner(url.openStream(),"UTF-8");
                
                while(scan.hasNext()){
                    info.append(scan.nextLine());
                }
                scan.close();
               System.out.println("Resultado de buscar"+info);
                if(String.valueOf(info).equals("")){
                    System.out.println("NO hay nada");
                    resultado=null;
                }
                else{
                    JSONObject dato = new JSONObject(String.valueOf(info));
                    
                    resultado = new UsuarioClass();
                    
                    resultado.cod_usuario=dato.getInt("cod_supervisor");
                    resultado.nombre=dato.getString("nombres")+" "+dato.getString("apellidos");
                    if(dato.getString("nombres").equals("Administrador")){
                        resultado.tipo="administrador";
                    }
                    else{
                        resultado.tipo="supervisor";
                    }
                    
                    
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
            resultado=null;
        }
       
       
       
       return resultado;
   }
    
   
   public UsuarioClass Ingresar2(String usuario, String clave){
       UsuarioClass resultado;
       
       try {
            URL url = new URL(PATH+"/tecnico/"+usuario+"/"+clave);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.connect();
            int respuesta = conn.getResponseCode();
            if(respuesta!=200){
                System.out.println("Ocurrio un error");
                resultado=null;
            }
            else{
                StringBuilder info = new StringBuilder();
                Scanner scan = new Scanner(url.openStream(),"UTF-8");
                
                while(scan.hasNext()){
                    info.append(scan.nextLine());
                }
                scan.close();
               // System.out.println("Resultado de buscar"+info);
                if(String.valueOf(info).equals("")){
                    System.out.println("NO hay nada");
                    resultado=null;
                }
                else{
                    JSONObject dato = new JSONObject(String.valueOf(info));
                    
                    resultado = new UsuarioClass();
                    
                    resultado.cod_usuario=dato.getInt("cod_tecnico");
                    resultado.nombre=dato.getString("nombre");
                    resultado.tipo="tecnico";
                    
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
            resultado=null;
        }
       
       
       
       return resultado;
   }
    
  }
