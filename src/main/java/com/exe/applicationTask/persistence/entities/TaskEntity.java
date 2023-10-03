package com.exe.applicationTask.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
@Entity(name = "task")
@Data

public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTask;

    private String technician;

    private String materials;

    private String descriptionTask;

    private String type;

    private Date dateTask;

    private String statusTask;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_application")
    private ApplicationEntity application;
}
