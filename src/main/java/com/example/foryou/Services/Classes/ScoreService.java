package com.example.foryou.Services.Classes;

import com.example.foryou.DAO.Entities.Contracts;
import com.example.foryou.DAO.Entities.Type;
import com.example.foryou.DAO.Entities.User;
import com.example.foryou.DAO.Repositories.ContractRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScoreService {
    ContractRepository contractRepository;

    public double calculerScore(User client) {
        Type typeContrat = client.getInsurancetype();
        double score = 0;

        if (typeContrat.equals("CAR_INSURANCE")) {
            int age = client.getAge();
            int anneesPermis = client.getAnneesPermis();
            boolean aEuAccident = client.isAEuAccident();
            int nbSinistres = client.getNbSinistres();
            score += age * 0.1;
            score += anneesPermis * 0.05;
            score += aEuAccident ? 10 : 0;
            score += nbSinistres * 2;
        }
        else if (typeContrat.equals("AGRICULTURE_INSURANACE")) {
            int surfaceExploitation = client.getSurfaceExploitation();
            int nbAnimaux = client.getNbAnimaux();
            int nbInstallations = client.getNbInstallations();
            int valeurCultures = client.getValeurCultures();
            score += surfaceExploitation * 0.05;
            score += nbAnimaux * 0.1;
            score += nbInstallations * 0.15;
            score += valeurCultures * 0.01;
        }
        else if (typeContrat.equals("CREDIT_INSURANCE")){
            int nbCredit = client.getCreditList().size();
            int dureeCredit = client.getDureeCredit();
            double montantCredit = client.getMontantCredit();
            score += nbCredit * 0.2;
            score += dureeCredit * 0.1;
            score += montantCredit * 0.3;
        }

        return score;
    }
    public double modifierMontantContrat(int contratId) {
        Contracts contrat = contractRepository.findById(contratId).get();
        User client = contrat.getUser();
        double score = calculerScore(client);
        double montantContrat = contrat.getCeilingAmount();
        if (score < 50) {
            montantContrat *= 1.3;
        } else if (score < 75) {
            montantContrat *= 1.2;
        } else if (score < 90) {
            montantContrat *= 1.1;
        } // Pas de modification si score >= 90
        contrat.setCeilingAmount(montantContrat);
        return contrat.getCeilingAmount();
    }

    }