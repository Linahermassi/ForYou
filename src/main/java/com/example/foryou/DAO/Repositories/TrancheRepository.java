package com.example.foryou.DAO.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foryou.DAO.Entities.Tranche;


public interface TrancheRepository extends JpaRepository<Tranche,Integer> {
}