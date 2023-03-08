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

    public <E> User(String javainuse, String $2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6, ArrayList<E> es) {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
