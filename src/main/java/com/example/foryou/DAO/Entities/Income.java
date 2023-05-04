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
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String product;

    float totalIncome;

    float totalExpenses;

    public float getIncomeRatio() {

        float netIncome = totalIncome - totalExpenses;
        float netIncomeRatio = 0.0f;

        if (totalIncome != 0.0f) {
            netIncomeRatio = netIncome / totalIncome;
        }

        return netIncomeRatio;
    }
}
