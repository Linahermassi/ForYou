package com.example.foryou.DAO.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Credit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int creditId;
     float amount;
     float interestRate;
    @Temporal(TemporalType.DATE)
     Date startDate;
    @Temporal(TemporalType.DATE)
     Date endtDate;
     float refundAmount;
     int nbrTranches;
     String methodPayment;
    @OneToOne
    Credit credit;
    @OneToMany(mappedBy = "credit")
    List<Tranche> trancheList;

}
