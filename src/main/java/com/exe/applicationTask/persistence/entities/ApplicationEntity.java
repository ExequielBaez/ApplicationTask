package com.exe.applicationTask.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity(name = "application")


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

    @JsonIgnore
    @OneToOne(mappedBy = "application")
    private TaskEntity task;

    public Integer getIdApplication() {
        return idApplication;
    }

    public void setIdApplication(Integer idApplication) {
        this.idApplication = idApplication;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getDescriptionApplication() {
        return descriptionApplication;
    }

    public void setDescriptionApplication(String descriptionApplication) {
        this.descriptionApplication = descriptionApplication;
    }

    public Date getDateApplication() {
        return dateApplication;
    }

    public void setDateApplication(Date dateApplication) {
        this.dateApplication = dateApplication;
    }

    public String getStatusApplication() {
        return statusApplication;
    }

    public void setStatusApplication(String statusApplication) {
        this.statusApplication = statusApplication;
    }

    public TaskEntity getTask() {
        return task;
    }

    public void setTask(TaskEntity task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "ApplicationEntity{" +
                "idApplication=" + idApplication +
                ", name='" + name + '\'' +
                ", sector='" + sector + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", equipment='" + equipment + '\'' +
                ", descriptionApplication='" + descriptionApplication + '\'' +
                ", dateApplication=" + dateApplication +
                ", statusApplication='" + statusApplication + '\'' +
                '}';
    }
}
