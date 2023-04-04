package com.example.foryou.DAO.Entities;

import com.fasterxml.jackson.annotation.*;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
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
     float salaire;
     String region;
    @Enumerated(EnumType.STRING)
     Gender gender;
    @ManyToOne
    @JsonIgnoreProperties("user")
    User user;
    @OneToMany
    @JsonIgnore
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
    @OneToMany(mappedBy = "client")
    @JsonIgnore
    List<Credit> creditList;



}
