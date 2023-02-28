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
public class Contracts implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int contract_id ;
    @Temporal(TemporalType.DATE)
     Date creationDate;
    @Temporal(TemporalType.DATE)
     Date startDate;
    @Temporal(TemporalType.DATE)
     Date endDate;
    float NetPremium;
    float TTCPremium;
    float ceilingAmout;
    float refundAmount;
    @Temporal(TemporalType.DATE)
    Date paymentDate;
    @Enumerated(EnumType.STRING)
    PaymentType paymentType;
    int installementsnbr;
    @ManyToOne
    User assureur;
    @ManyToOne
    User user;
    @OneToMany(mappedBy = "contract")
    List<Sinister> sinisterList;
    @ManyToOne
    Subproduct subproduct;
}
