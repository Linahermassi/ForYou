package com.example.foryou.DAO.Repositories;

import com.example.foryou.DAO.Entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement,Integer> {
}
