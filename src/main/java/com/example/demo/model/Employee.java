package com.example.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Employee {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String role;
}
