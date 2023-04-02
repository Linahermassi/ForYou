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
    @JsonIgnore
    User user;
    @OneToMany
    @JsonIgnore
    List<User> userList;
    @ManyToOne
    @JsonIgnore
    Role role;
    @ManyToMany(mappedBy = "userList")
    @JsonIgnore
    List<Reclamation> reclamationList;
    @OneToMany(mappedBy = "assureur")
    @JsonIgnore
    List<Contracts> contractsA;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    List<Contracts> contractsList;
    @OneToMany(mappedBy = "client")
    @JsonIgnore
    List<Sinister> sinisterList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="Participant")
    @JsonIgnore
     List<InscriptionEvent> InscriptionEvent;
    @OneToMany(mappedBy = "organizer")
    @JsonIgnore
    List<Event> EventsCreated;
Double Feedbackmark;

}
