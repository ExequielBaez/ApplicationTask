package com.exe.applicationTask.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
@Entity
@Data

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTask;

    private String technician;

    private String materials;

    private String type;

    private String statusTask;

    private Date dateTask;

    private String descriptionTask;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_application")
    private Application application;
}
