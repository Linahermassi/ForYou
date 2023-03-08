package com.example.foryou.Services.Interfaces;

import javax.mail.MessagingException;

public interface INotificationService {
     void sendEmail(String to, String subject, String text) throws MessagingException;
}
