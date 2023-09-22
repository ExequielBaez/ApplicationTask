package com.exe.applicationTask.persistence.repositories;

import com.exe.applicationTask.persistence.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
}
