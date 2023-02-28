package com.example.foryou.Services.Interfaces;

import com.example.foryou.DAO.Entities.User;

import java.util.List;

public interface IuserService {
    User add(User u);

    User edit(User u);

    List<User> selectAll();

    User selectById(int userId);

    void deleteById(int roleId);

    void delete(User u);

    List<User> addAll(List<User> list);

    void deleteAll(List<User> list);

    List<User> selectByAdress(User adress);
}
