package com.example.foryou.Services.Interfaces;

import com.example.foryou.DAO.Entities.Tranche;

import java.util.List;

public interface ITrancheService {
    Tranche add(Tranche t);
    Tranche edit(Tranche t);

    List<Tranche> selectAll();
    Tranche selectById(int TrancheId);
    void deleteById(int TrancheId);
    void delete(Tranche t);
    List<Tranche> addAll(List<Tranche> list);
    void deleteAll(List<Tranche>list);
    void deleteAll();
}

