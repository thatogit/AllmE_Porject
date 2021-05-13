package com.villascode.allme.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class EmailService implements EmailSender{

    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
    private final JavaMailSender mailSender=null;
    private String email="villascode@gmail.com";

 @Override
 @Async
 public void send(String to, String from){
     try{
         MimeMessage mimeMessage=mailSender.createMimeMessage();
         MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,"utf-8");
         helper.setText(email,true);
         helper.setTo(to);
         helper.setSubject("Confirm your email");
         helper.setFrom(email);
     }catch (MessagingException e){
         LOGGER.error("Failed to send the email",e);
         throw new IllegalStateException(String.format("Failed to sent %s ",email));
     }

 }
}
