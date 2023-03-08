package com.example.foryou.DAO.Repositories;

import com.example.foryou.DAO.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User,Integer> {

    List<User> findByAdress(String adress);
    User findByUsername(String username);
    User findByEmail(String email);

}
