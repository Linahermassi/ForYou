package com.example.foryou.DAO.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
public class Notification implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int notifId;
    String NotifDescription;
    TypeNotif typeNotif;
    @Temporal(TemporalType.DATE)
    Date notifDate;
    @ManyToOne
    User transmitter;
    @ManyToMany
    List<User> receivers;


}