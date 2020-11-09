package com.example.SpringBatchCSV.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    private Integer id;
    private String name;
    private String dept;
    private Integer salary;

}

