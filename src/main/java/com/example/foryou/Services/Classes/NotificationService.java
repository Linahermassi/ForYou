package com.example.foryou.Services.Classes;

import com.example.foryou.Services.Interfaces.INotificationService;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class NotificationService implements INotificationService {

        // Envoyer des notifications par courrier électronique:
        private JavaMailSender javaMailSender;
        public void sendEmail(String to, String subject, String text) throws MessagingException {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true);
            javaMailSender.send(message);
        }
    }


