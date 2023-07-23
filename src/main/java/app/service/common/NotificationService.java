package app.service.common;

import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

@Service
@AllArgsConstructor
public class NotificationService {

    private final JavaMailSender javaMailSender;

    public void sendNotification() throws MailException, MessagingException {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "25");

        Session session = Session.getInstance(props,
                new jakarta.mail.Authenticator() {
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
        mail.setText("<h1>funcionooo</h1>");*/

        javaMailSender.send(new SimpleMailMessage());
    }
}
