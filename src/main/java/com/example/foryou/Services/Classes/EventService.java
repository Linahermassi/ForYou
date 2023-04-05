package com.example.foryou.Services.Classes;

import com.example.foryou.DAO.Entities.Event;
import com.example.foryou.DAO.Entities.InscriptionEvent;
import com.example.foryou.DAO.Repositories.EventRepository;
import com.example.foryou.DAO.Repositories.InscriptionEventRepository;
import com.example.foryou.Services.Interfaces.IeventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class EventService implements IeventService {
    private EventRepository eventRepository;
    @Override
    public Event add(Event a) {
        return eventRepository.save(a);
    }

    @Override
    public Event edit(Event a) {
        return eventRepository.save(a);
    }

    @Override
    public List<Event> selectAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event selectById(int id) {
        return eventRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        eventRepository.deleteById(id);
    }

    @Override
    public void delete(Event a) {
        eventRepository.delete(a);
    }

    @Override
    public List<Event> addAll(List<Event> list) {
        return eventRepository.saveAll(list);
    }

    @Override
    public void deleteAll(List<Event> list) {
        eventRepository.deleteAll(list);
    }
    @Override
    public void deleteAll() {
        eventRepository.deleteAll();
    }




}
