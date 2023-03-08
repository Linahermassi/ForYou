package com.example.foryou.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int reclamationId;
     String title;
     String category;
     String details;

     @ManyToMany
     @JsonIgnore
     List<User> userList;
     @OneToOne(mappedBy = "reclamation")
     @JsonIgnore
     Response response;



}
