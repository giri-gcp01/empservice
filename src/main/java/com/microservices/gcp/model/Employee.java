package com.microservices.gcp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employees")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

}
