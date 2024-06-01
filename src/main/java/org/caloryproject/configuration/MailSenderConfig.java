package org.caloryproject.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MailSenderConfig{

    private final JavaMailSender mailSender;


    public void sendMail(String to, String subject, String context){
        SimpleMailMessage newMessage = new SimpleMailMessage();
        newMessage.setFrom("noreply@rebbin.com");
        newMessage.setTo(to);
        newMessage.setSubject(subject);
        newMessage.setText(context);
        mailSender.send(newMessage);
    }

}
