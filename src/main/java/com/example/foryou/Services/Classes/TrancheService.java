package com.example.foryou.Services.Classes;
import com.example.foryou.DAO.Entities.Tranche;
import com.example.foryou.DAO.Repositories.TrancheRepository;
import com.example.foryou.Services.Interfaces.ITrancheService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class TrancheService implements ITrancheService {
    private TrancheRepository trancheRepository;
    @Override
    public Tranche add(Tranche t) {
        return trancheRepository.save(t);
    }

    @Override
    public Tranche edit(Tranche t) {
        return trancheRepository.save(t);
    }

    @Override
    public List<Tranche> selectAll() {
        return trancheRepository.findAll();
    }

    @Override
    public Tranche selectById(int trancheId) {
        return trancheRepository.findById(trancheId).get();
    }

    @Override
    public void deleteById(int trancheId) {
        trancheRepository.deleteById(trancheId);
    }

    @Override
    public void delete(Tranche t) {
        trancheRepository.delete(t);
    }

    @Override
    public List<Tranche> addAll(List<Tranche> list) {
        return trancheRepository.saveAll(list);
    }

    @Override
    public void deleteAll(List<Tranche> list) {
        trancheRepository.deleteAll(list);
    }

    @Override
    public void deleteAll() {
        trancheRepository.deleteAll();
    }
}

