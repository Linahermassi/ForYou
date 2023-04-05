package com.example.foryou.Services.Classes;

import com.example.foryou.DAO.Entities.Event;
import com.example.foryou.DAO.Entities.InscriptionEvent;
import com.example.foryou.DAO.Entities.User;
import com.example.foryou.DAO.Repositories.EventRepository;
import com.example.foryou.DAO.Repositories.InscriptionEventRepository;
import com.example.foryou.DAO.Repositories.UserRepository;
import com.example.foryou.Services.Interfaces.IinscriptionEventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class InscriptionEventService implements IinscriptionEventService {
    private InscriptionEventRepository inscriptionEventRepository;
    private EventRepository eventRepository;
    private UserRepository userRepository;
    @Override
    public InscriptionEvent add(InscriptionEvent a) {
        return inscriptionEventRepository.save(a);
    }

    @Override
    public InscriptionEvent edit(InscriptionEvent a) {
        return inscriptionEventRepository.save(a);
    }

    @Override
    public List<InscriptionEvent> selectAll() {
        return inscriptionEventRepository.findAll();
    }

    @Override
    public InscriptionEvent selectById(int id) {
        return inscriptionEventRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        inscriptionEventRepository.deleteById(id);
    }

    @Override
    public void delete(InscriptionEvent a) {
        inscriptionEventRepository.delete(a);
    }

    @Override
    public List<InscriptionEvent> addAll(List<InscriptionEvent> list) {
        return inscriptionEventRepository.saveAll(list);
    }

    @Override
    public void deleteAll(List<InscriptionEvent> list) {
        inscriptionEventRepository.deleteAll(list);
    }
    @Override
    public void deleteAll() {
        inscriptionEventRepository.deleteAll();
    }
    @Override
    public InscriptionEvent assignParticipantandEventToInscription(int idEvent, int idParticipant, InscriptionEvent i) {
        Event event= eventRepository.findById(idEvent).get();

        User participant=userRepository.findById(idParticipant).get();



        i.setEvent(event);
        i.setParticipant(participant);

        return inscriptionEventRepository.save(i);
    }
    @Override
    public void assignMarkEvent(int mark, int inscriptionid){

        InscriptionEvent inscription= inscriptionEventRepository.findById(inscriptionid).get();
        inscription.setMark(mark);
        inscriptionEventRepository.save(inscription);
    }

}
