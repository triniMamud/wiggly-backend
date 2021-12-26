package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class NotificationService {

    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification() throws MailException, MessagingException {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "25");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("trinimamud@gmail.com", "FireFox110298");
                    }
                });
        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress("trinimamud@gmail.com"));

        // Set To: header field of the header.
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("eliaslamanna@gmail.com"));

        // Set Subject: header field
        message.setSubject("Testing Subject");

        // Send the actual HTML message, as big as you like
        message.setContent(
                "<h1>This is actual message embedded in HTML tags</h1>",
                "text/html");

        // Send message
        Transport.send(message);


        /*SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("trinimamud@gmail.com");
        mail.setSubject("prueba mail");
        mail.setText("<h1>funcionooo</h1>");

        javaMailSender.send(mail);*/
    }
}
