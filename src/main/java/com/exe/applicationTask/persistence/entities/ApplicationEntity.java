package com.exe.applicationTask.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity(name = "application")
@Data

public class ApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idApplication;

    private String name;

    private String sector;

    private String numberPhone;

    private String equipment;

    private String descriptionApplication;

    private Date dateApplication;

    private String statusApplication;


    @OneToOne(mappedBy = "application")
    private TaskEntity task;




}
