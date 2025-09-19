package com.example.springcore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String street;

    private String city;

    private String state;

    private String zipCode;

    @OneToOne
    @JoinColumn(name = "university_id", referencedColumnName = "id")
    private University university;

//    @OneToOne(mappedBy = "address")
//    private University university;



    // bu boglanish oddiy boglanish chuni mappedBy ishlatilmadi,
    // bu yerda foreign key university table da bo'ladi
}
