package com.exe.applicationTask.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;

@Entity(name = "application")
@Data

public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idApplication;

    private String name;

    private String sector;

    private String numberPhone;

    private String equipment;

    private Date dateApplication;

    private String statusApplication;

    private String descriptionApplication;



}
