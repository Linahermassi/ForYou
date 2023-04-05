package com.example.foryou.DAO.Repositories;

import com.example.foryou.DAO.Entities.Contracts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contracts,Integer> {
}
