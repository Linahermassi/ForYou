package com.example.foryou.RestControllers;

import com.example.foryou.DAO.Entities.Credit;
import com.example.foryou.Services.Classes.ScoreService;
import com.example.foryou.Services.Interfaces.IScoreServie;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Score")
@CrossOrigin("*")
public class ScoreRestController {
    private IScoreServie iScoreServie;
    @GetMapping("/Scoring/{clientId}")
    public double scoring(@PathVariable Long clientId){
        return iScoreServie.calculerScore(clientId);
    }
    @GetMapping("/UpdateAmount/{contratId}")
    double modifierMontantContrat(@PathVariable int contratId) {
        return iScoreServie.modifierMontantContrat(contratId);
    }

    @GetMapping("/Scoring/{clientId}/{contratId}")
    double[] Score (@PathVariable Long clientId,@PathVariable int contratId) {
        return iScoreServie.Score1(clientId,contratId);
    }

    }
