package com.example.foryou.RestControllers;

import com.example.foryou.DAO.Entities.InscriptionEvent;
import com.example.foryou.Services.Interfaces.IinscriptionEventService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerResponse;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/InscriptionEvent")
public class InscriptionEventRestController {
    private IinscriptionEventService iinscriptionEventService;

    @GetMapping("/afficherInscriptionEventById/{Id}")
    public InscriptionEvent afficherCreditById(@PathVariable int Id) {

        return iinscriptionEventService.selectById(Id);
    }

    @GetMapping("/afficherAllInscriptionEvents")
    public List<InscriptionEvent> afficherAll() {
        return iinscriptionEventService.selectAll();
    }

    @PostMapping("/ajouterInscriptionEvent")
    public InscriptionEvent addInscriptionEvent(@RequestBody InscriptionEvent InscriptionEvent) {
        return iinscriptionEventService.add(InscriptionEvent);

    }

    @PostMapping("ajouterAllInscriptionEvents")
    public ResponseEntity<String> addAllInscriptionEvent(@RequestBody List<InscriptionEvent> InscriptionEventList) {
        iinscriptionEventService.addAll(InscriptionEventList);
        return ResponseEntity.ok("Added successfully.");
    }

    @PutMapping("/ModifierInscriptionEvent")
    public ResponseEntity<String> editInscriptionEvent(@RequestBody InscriptionEvent InscriptionEvent) {
        iinscriptionEventService.edit(InscriptionEvent);
        return ResponseEntity.ok("Edited successfully.");
    }

    @DeleteMapping("SupprimerInscriptionEvent")
    public ResponseEntity<String> deleteInscriptionEvent(@RequestBody InscriptionEvent InscriptionEvent) {
        iinscriptionEventService.delete(InscriptionEvent);
        return ResponseEntity.ok("Deleted successfully.");
    }

    @DeleteMapping("/SupprimerInscriptionEventById")
    public ResponseEntity<String> supprimerInscriptionEventsById(@RequestParam int InscriptionEventId) {
        iinscriptionEventService.deleteById(InscriptionEventId);
        return ResponseEntity.ok("Deleted successfully.");
    }

    @DeleteMapping("/SupprimerAllInscriptionEvents")
    public ResponseEntity<String> supprimerAllInscriptionEvents(@RequestBody List<InscriptionEvent> InscriptionEventList) {
        iinscriptionEventService.deleteAll(InscriptionEventList);
        return ResponseEntity.ok("Deleted successfully.");
    }

    @DeleteMapping("/SupprimerAll")
    public ResponseEntity<String> SupprimerAll() {
        iinscriptionEventService.deleteAll();
        return ResponseEntity.ok("Deleted successfully.");
    }

    @PostMapping("/ajouterParticpantInscriptionEvent/{EventId}/{ParticipantId}")
    public InscriptionEvent addInscriptionEvent(@PathVariable int EventId, @PathVariable int ParticipantId) {
        InscriptionEvent i = new InscriptionEvent();
        return iinscriptionEventService.assignParticipantandEventToInscription(EventId, ParticipantId, i);

    }

    @Autowired
    private JavaMailSender javaMailSender;

    @Scheduled(cron = "0 0 0 * * *")
    @PostMapping("/EventReminder")
    public void SendEventReminder() {
        List<InscriptionEvent> list = (List<InscriptionEvent>) iinscriptionEventService.selectAll();
        for (InscriptionEvent i : list) {
            LocalDate today = LocalDate.now();

            if (0 == (i.getEvent().getDate_Event().compareTo(today.plusDays(7)))) {
                System.out.println(i.getParticipant().getEmail());
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(i.getParticipant().getEmail());
                message.setSubject("Reminder");
                message.setText(i.getEvent().getName_Event() + "event will happen in 7 days ");


                javaMailSender.send(message);
            }
        }
    }

    @PostMapping("/SendFeedback")
    @Scheduled(cron = "0 0 0 * * *")
    public void sendfeedback() {
        List<InscriptionEvent> list = (List<InscriptionEvent>) iinscriptionEventService.selectAll();
        for (InscriptionEvent i : list) {
            LocalDate today = LocalDate.now();

            if (0 == (i.getEvent().getDate_Event().compareTo(today.minusDays(1)))) {
                System.out.println(i.getParticipant().getEmail());
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(i.getParticipant().getEmail());
                message.setSubject("Reminder");
                message.setText("event will happen in 7 days ");


                javaMailSender.send(message);
            }
        }
    }

    @PostMapping("/SetFeedback/{inscriptionid}/{mark}")
    public void setfeedback(@PathVariable int inscriptionid, @PathVariable int mark) {
        iinscriptionEventService.assignMarkEvent(mark, inscriptionid);
    }


}
