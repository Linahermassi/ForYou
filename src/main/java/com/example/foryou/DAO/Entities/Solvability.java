package com.example.foryou.DAO.Entities;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Solvability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    float currentAssets;
    float currentLiabilities;
    float nonCurrentAssets;
    float nonCurrentLiabilities;

    int year;

    float solvencyRatio;

    boolean liquidityProblems;

    public float calculateSolvencyRatio() {
        float totalAssets = currentAssets + nonCurrentAssets;
        float totalLiabilities = currentLiabilities + nonCurrentLiabilities;
        float solvencyRatio = 0.0f;

        if (totalLiabilities != 0.0f) {
            solvencyRatio = totalAssets / totalLiabilities;
        }
        this.solvencyRatio = solvencyRatio;

        return this.solvencyRatio;
    }

    public boolean hasLiquidityProblems() {
        boolean liquidityProblems = false;

        if (currentAssets < currentLiabilities) {
            liquidityProblems = true;
        }

        return liquidityProblems;
    }

    public boolean isSolvent() {
        boolean solvent = false;

        if (currentAssets > currentLiabilities && nonCurrentAssets > nonCurrentLiabilities) {
            solvent = true;
        }

        return solvent;
    }
}
