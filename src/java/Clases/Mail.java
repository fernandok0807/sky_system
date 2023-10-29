    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Enmanuel
 */
public class Mail {

    public Mail() {
    }
    
    
    
    public void sendMail(String correo, String contenido,String fecha,String asunto,String paso,String estado){
        System.out.println("Preparando correo");
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.port", "587");
        
        String servidor="dynamicprocess2019@gmail.com";
        String pass="jpsx hmvv aqrt xnqt";
        //fk29082023
        
        Session sesion= Session.getInstance(propiedades, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(servidor,pass); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        
        Message mensaje= prepareMessage(sesion,servidor,correo,contenido,fecha,asunto,paso,estado);
        try{
            Transport.send(mensaje);
        }
        catch(Exception e){
            System.out.println("error 2: "+e);
        }
        
    }
    
    private static Message prepareMessage(Session sesion,String server,String receptor,String contenido,String fecha,String asunto,String paso,String estado){
        try{
            Message mensaje = new MimeMessage(sesion);
            mensaje.setFrom(new InternetAddress("Sky Net Corp<"+server+">"));
            mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
            mensaje.setSubject("Reporte de Vista Técnico SKYNET");
            String body= "\nIniciado el: "+contenido+"\n"+
                    "Finalizado el: "+fecha+"\n\n"+
                    "Reporte de Nuestro Técnico a la empresa:\n"+ paso +"\n";
               
            mensaje.setText(body);
            
            return mensaje;
        }
        catch (Exception ex) {
            System.out.println("Error al enviar "+ex);
            
        }
        return null;
    }
    
}
