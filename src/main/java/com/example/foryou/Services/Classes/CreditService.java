package com.example.foryou.Services.Classes;

import com.example.foryou.DAO.Entities.Credit;
import com.example.foryou.DAO.Repositories.CreditRepository;
import com.example.foryou.Services.Interfaces.ICreditService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CreditService implements ICreditService {

    private CreditRepository creditRepository;
    @Override
    public Credit add(Credit c) {
        return creditRepository.save(c);
    }

    @Override
    public Credit edit(Credit u) {
        return creditRepository.save(u);
    }

    @Override
    public List<Credit> selectAll() {
        return creditRepository.findAll();
    }

    @Override
    public Credit selectById(int creditId) {
        return creditRepository.findById(creditId).get();
    }

    @Override
    public void deleteById(int creditId) {
        creditRepository.deleteById(creditId);
    }

    @Override
    public void delete(Credit c) {
        creditRepository.delete(c);
    }

    @Override
    public List<Credit> addAll(List<Credit> list) {
        return creditRepository.saveAll(list);
    }

    @Override
    public void deleteAll(List<Credit> list) {
        creditRepository.deleteAll(list);
    }

    @Override
    public void deleteAll() {
        creditRepository.deleteAll();
    }
}