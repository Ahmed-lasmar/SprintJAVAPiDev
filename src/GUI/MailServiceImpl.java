/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author HP
 */

public class MailServiceImpl {
    public static void mailsent(String recipient,String subject,String text) throws Exception {
    System.out.println("preparing to send");
    Properties props = new Properties();
    String myAccountMail="communityassassin@gmail.com";
    String Password="wkdawocplscozeuj";
    props.put("mail.smtp.auth", "true");
    
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.debug", "true");
    
    Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(
                            myAccountMail,Password);
                }
            });
    
    
         try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountMail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            
            message.setText(text);
            Transport.send(message);
        }catch(Exception e){};
    
    
    System.out.println("Message sent");
    }
}
