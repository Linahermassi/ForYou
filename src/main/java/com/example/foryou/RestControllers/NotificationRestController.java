package com.example.foryou.RestControllers;

import com.example.foryou.Services.Classes.ContractService;
import com.example.foryou.Services.Interfaces.INotificationService;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/Notification")
public class NotificationRestController {
        private INotificationService iNotificationService;
        @Autowired
        private ContractService contratService;
        @PostMapping("/sendEmail")
        public ResponseEntity<?> sendEmail() throws MessagingException, javax.mail.MessagingException {
            contratService.verifierContrats();
            return ResponseEntity.ok().build();
        }
    // Lina essel l profa bech taamel crud wallé
    }




