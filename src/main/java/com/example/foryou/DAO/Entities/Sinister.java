package com.example.foryou.DAO.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Sinister implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int sinisterId;
    @Enumerated(EnumType.STRING)
     Type typeSinister;
     String Judgement;
     String damageAmount;
     @ManyToOne
     User client;
     @ManyToOne
     Contracts contract;
     @OneToMany(mappedBy = "sinister")
     List <Offer> offerList;



}
