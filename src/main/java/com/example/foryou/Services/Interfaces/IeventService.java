package com.example.foryou.Services.Interfaces;

import com.example.foryou.DAO.Entities.Event;

import java.util.List;

public interface IeventService {
    Event add(Event a);

    Event edit(Event a);

    List<Event> selectAll();

    Event selectById(int id);

    void deleteById(int id);

    void delete(Event a);

    List<Event> addAll(List<Event> list);

    void deleteAll(List<Event> list);

    void deleteAll();
}