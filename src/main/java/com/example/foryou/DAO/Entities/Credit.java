package com.example.foryou.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    Credit credit;
    @OneToMany(mappedBy = "credit")
    @JsonIgnore
    List<Tranche> trancheList;
    @ManyToOne
    User client;

}
