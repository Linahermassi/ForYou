package com.example.foryou.RestControllers;

import com.example.foryou.DAO.Entities.Event;
import com.example.foryou.DAO.Entities.InscriptionEvent;
import com.example.foryou.DAO.Entities.User;
import com.example.foryou.Services.Classes.UserService;
import com.example.foryou.Services.Interfaces.IeventService;
import com.example.foryou.Services.Interfaces.IinscriptionEventService;
import com.example.foryou.Services.Interfaces.IuserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Event")
public class EventRestController {
    private IeventService iEventService;
    IuserService iuserService;

    private IinscriptionEventService iinscriptionEventService;

    @GetMapping("/afficherEventById/{Id}")
    public Event afficherEventById(@PathVariable int Id) {

        return iEventService.selectById(Id);
    }

    @GetMapping("/afficherAllEvents")
    public List<Event> afficherAll() {
        return iEventService.selectAll();
    }

    @PostMapping("/ajouterEvent")
    public Event addEvent(@RequestBody Event Event) {
        return iEventService.add(Event);

    }

    @PostMapping("/ajouterEventavecuser")
    public Event addEvent(@RequestBody Event Event, @RequestParam int UserId) {
        User organizer;
        organizer = iuserService.selectById(UserId);
        Event.setOrganizer(organizer);
        return iEventService.add(Event);

    }

    @PostMapping("ajouterAllEvents")
    public ResponseEntity<String> addAllEvent(@RequestBody List<Event> EventList) {
        iEventService.addAll(EventList);
        return ResponseEntity.ok("Added successfully.");
    }

    @PutMapping("/ModifierEvent")
    public ResponseEntity<String> editEvent(@RequestBody Event Event) {
        iEventService.edit(Event);
        return ResponseEntity.ok("Edited successfully.");
    }

    @DeleteMapping("SupprimerEvent")
    public ResponseEntity<String> deleteEvent(@RequestBody Event Event) {
        iEventService.delete(Event);
        return ResponseEntity.ok("Deleted successfully.");
    }

    @DeleteMapping("/SupprimerEventById")
    public ResponseEntity<String> supprimerEventsById(@RequestParam int EventId) {
        iEventService.deleteById(EventId);
        return ResponseEntity.ok("Deleted successfully.");
    }

    @DeleteMapping("/SupprimerAllEvents")
    public ResponseEntity<String> supprimerAllEvents(@RequestBody List<Event> EventList) {
        iEventService.deleteAll(EventList);
        return ResponseEntity.ok("Deleted successfully.");
    }

    @DeleteMapping("/SupprimerAll")
    public ResponseEntity<String> SupprimerAll() {
        iEventService.deleteAll();
        return ResponseEntity.ok("Deleted successfully.");
    }

    @PutMapping("/CalcualteRating")

    public void calculateRating() {
        List<Event> list = (List<Event>) iEventService.selectAll();
        for (Event i : list) {
            List<InscriptionEvent> listinsc = (List<InscriptionEvent>) i.getInscriptionEvent();
            double totalMarks = 0;
            int count = 0;
            for (InscriptionEvent j : listinsc) {
                if (j.getMark() != null) {
                    totalMarks += j.getMark();
                    count++;
                }
            }
            if (count > 0) {
                double averageMark = totalMarks / count;
                System.out.println("Average mark for event " + i.getName_Event() + ": " + averageMark);
                i.setMark(averageMark);
                iEventService.add(i);
            } else {
                System.out.println("No marks found for event " + i.getName_Event());
            }
        }
    }

    @PutMapping("/SetRatingforOrganizers")
    public void calculateUserRating() {
        List<User> list = (List<User>) iuserService.selectAll();
        for (User i : list) {
            List<Event> listevent = (List<Event>) i.getEventsCreated();
            double totalMarks = 0;
            int count = 0;
            for (Event j : listevent) {
                if (j.getMark() != null) {
                    totalMarks += j.getMark();
                    count++;
                }
            }
            if (count > 0) {
                double averageMark = totalMarks / count;
                System.out.println("Average mark for organizer " + i.getFirstName() + ": " + averageMark);
                i.setFeedbackmark(averageMark);
                iuserService.add(i);
            } else {
                System.out.println("No marks found for event " + i.getFirstName());
            }
        }
    }
}



