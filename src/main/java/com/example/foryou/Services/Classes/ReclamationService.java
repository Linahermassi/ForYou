package com.example.foryou.Services.Classes;

import com.example.foryou.DAO.Entities.Reclamation;
import com.example.foryou.Services.Interfaces.IReclamationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.foryou.DAO.Repositories.ReclamationRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class ReclamationService implements IReclamationService {

    private ReclamationRepository reclamationRepository;

    @Override
    public Reclamation add(Reclamation rec) {
        return reclamationRepository.save(rec);
    }

    @Override
    public Reclamation edit(Reclamation rec) {
        return reclamationRepository.save(rec);
    }

    @Override
    public List<Reclamation> selectAll() {
        return reclamationRepository.findAll();
    }

    @Override
    public Reclamation selectById(int reclamationId) {
        return reclamationRepository.findById(reclamationId).get();
    }

    @Override
    public void deleteById(int reclamationId) {
        reclamationRepository.deleteById(reclamationId);
    }

    @Override
    public void delete(Reclamation rec) {
        reclamationRepository.delete(rec);
    }

    @Override
    public List<Reclamation> addAll(List<Reclamation> listrec) {
        return reclamationRepository.saveAll(listrec);
    }

    @Override
    public void deleteAll(List<Reclamation> listrec) { reclamationRepository.deleteAll(listrec);
    }

    @Override
    public void deleteAll() {
        reclamationRepository.deleteAll();
    }

}