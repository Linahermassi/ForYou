package com.example.foryou.RestControllers;

import com.example.foryou.DAO.Entities.Solvability;
import com.example.foryou.DAO.Repositories.SolvabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solvabilities")
public class SolvabilityController {

    @Autowired
    SolvabilityRepository repository;
    @GetMapping("")
    public List<Solvability> list()
    {
        return repository.findAll();
    }


    @PostMapping("")
    public Solvability add(@RequestBody Solvability solvability)
    {
        solvability.calculateSolvencyRatio();
        solvability.setLiquidityProblems(solvability.hasLiquidityProblems());
        repository.save(solvability);

        return solvability;
    }

}
