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
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int poductid;
     String name;
     String description;
    @Enumerated(EnumType.STRING)
     Type typeProduct;
    @OneToMany(mappedBy = "product")
    List<Subproduct> subproductList;
        }
