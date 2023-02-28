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
public class Subproduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int subproductid;
    String name;
    float scoring;
    @ManyToOne
    Product product;
    @OneToMany(mappedBy = "subproduct")
    List<Contracts> contractsList;

}
