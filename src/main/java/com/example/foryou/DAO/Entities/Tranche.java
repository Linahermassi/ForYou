package com.example.foryou.DAO.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Tranche implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int trancheId;
    float Amount;
    @Temporal(TemporalType.DATE)
    Date PaymentDate;
    @ManyToOne
    Credit credit;
}
