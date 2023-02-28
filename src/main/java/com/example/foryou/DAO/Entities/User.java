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
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int userId;
     String password;
     String firstName;

     String lastName;

     String email;
     String profession;
    @Temporal(TemporalType.DATE)
     Date birthDate;
     String adress;
     long phone;
     String expertiseDomain;
    @Enumerated(EnumType.STRING)
     Gender gender;
    @ManyToOne
    User user;
    @OneToMany
    List<User> userList;
    @ManyToOne
    Role role;
    @ManyToMany(mappedBy = "userList")
    List<Reclamation> reclamationList;
    @OneToMany(mappedBy = "assureur")
    List<Contracts> contractsA;
    @OneToMany(mappedBy = "user")
    List<Contracts> contractsList;
    @OneToMany(mappedBy = "client")
    List<Sinister> sinisterList;


}
