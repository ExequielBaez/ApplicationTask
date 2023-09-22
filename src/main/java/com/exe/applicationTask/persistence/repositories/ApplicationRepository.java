package com.exe.applicationTask.persistence.repositories;

import com.exe.applicationTask.persistence.entities.ApplicationEntity;
import com.exe.applicationTask.persistence.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Integer> {
}
