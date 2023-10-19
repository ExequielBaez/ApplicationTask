package com.exe.applicationTask.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Entity(name = "task")
@Getter
@Setter
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

    //@JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_application")
    private ApplicationEntity application;


    @Override
    public String toString() {
        return "TaskEntity{" +
                "idTask=" + idTask +
                ", technician='" + technician + '\'' +
                ", materials='" + materials + '\'' +
                ", descriptionTask='" + descriptionTask + '\'' +
                ", type='" + type + '\'' +
                ", dateTask=" + dateTask +
                ", statusTask='" + statusTask + '\'' +
                ", application=" + application +
                '}';
    }
}
