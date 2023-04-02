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
public class Paiement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String stripeCustomerId;
    String stripeChargeId;
    double montant;
    @Enumerated(EnumType.STRING)
    PaymentFormality paymentFormality;
    @Temporal(TemporalType.DATE)
    Date paymentDate;
    @Enumerated(EnumType.STRING)
    PaymentType paymentType;
    @ManyToOne
    Contracts contrat;


}