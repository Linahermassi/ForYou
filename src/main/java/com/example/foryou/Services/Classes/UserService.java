package com.example.foryou.Services.Classes;

import com.example.foryou.DAO.Entities.User;
import com.example.foryou.DAO.Repositories.UserRepository;
import com.example.foryou.Services.Interfaces.IuserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IuserService {
    private UserRepository userRepository;

    @Override
    public User add(User u) {
        return userRepository.save(u);
    }

    @Override
    public User edit(User u) {
        return userRepository.save(u);
    }

    @Override
    public List<User> selectAll() {
        return userRepository.findAll();
    }

    @Override
    public User selectById(int userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public void deleteById(int roleId) {
        userRepository.deleteById(roleId);
    }

    @Override
    public void delete(User u) {
        userRepository.delete(u);
    }

    @Override
    public List<User> addAll(List<User> list) {
        return userRepository.saveAll(list);
    }

    @Override
    public void deleteAll(List<User> list) {
        userRepository.deleteAll(list);
    }


    @Override
    public List<User> selectByAdress(String adress) {
        //return abonnementRepository.getByTypeAbo(type);
        return userRepository.findByAdress(adress);
    }

    @Override
    public User selectByUsername(String username) {
        //return abonnementRepository.getByTypeAbo(type);
        return userRepository.findByUsername(username);
    }


    @Override
    public User selectByEmail(String email) {
        //return abonnementRepository.getByTypeAbo(type);
        return userRepository.findByEmail(email);
    }


}
