package com.example.foryou.RestControllers;

import com.example.foryou.DAO.Entities.Income;
import com.example.foryou.DAO.Repositories.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incomes")
public class IncomeController {

    @Autowired
    IncomeRepository repository;
    @GetMapping("")
    public List<Income> list()
    {
        return repository.findAll();
    }

    @PostMapping("")
    public Income add(@RequestBody Income Income)
    {
        repository.save(Income);

        return Income;
    }
}
