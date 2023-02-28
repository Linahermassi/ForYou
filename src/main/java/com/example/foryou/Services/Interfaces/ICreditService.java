package com.example.foryou.Services.Interfaces;
import com.example.foryou.DAO.Entities.Credit;
import java.util.List;


public interface ICreditService {
    Credit add(Credit c);
    Credit edit(Credit c);

    List<Credit> selectAll();
    Credit selectById(int creditId);
    void deleteById(int creditId);
    void delete(Credit c);
    List<Credit> addAll(List<Credit> list);
    void deleteAll(List<Credit>list);
    void deleteAll();
}