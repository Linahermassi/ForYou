package com.example.foryou.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
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
    String username;
    @JsonIgnore
    String password;
    String firstName;
    String lastName;
    String email;
    String profession;
    @Temporal(TemporalType.DATE)
    Date birthDate;
    String adress;
    String region;
    float salary;
    long phone;
    String expertiseDomain;
    int age;
    //Client assurance auto
    int anneesPermis ;
    boolean aEuAccident ;
    int nbSinistres;
    // Client assurance agriculture
    int surfaceExploitation ;
    int nbAnimaux ;
    int nbInstallations ;
    int valeurCultures;
    // Client assurance credit
    int DureeCredit;
    int MontantCredit;
    @Enumerated(EnumType.STRING)
    Type Insurancetype;
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
    @OneToMany(mappedBy = "transmitter")
    @JsonIgnore
    List<Notification> notificationTList;
    @OneToMany(mappedBy = "receiver")
    @JsonIgnore
    List<Notification> notificationRList;
    @OneToMany(mappedBy = "client")
    @JsonIgnore
    List<Credit> creditList;

    public <E> User(String javainuse, String $2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6, ArrayList<E> es) {
    }
}
