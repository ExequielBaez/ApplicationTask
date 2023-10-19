package com.exe.applicationTask.services;

import com.exe.applicationTask.persistence.entities.TaskEntity;

import java.util.List;

public interface TaskService {
    public List<TaskEntity> getAllTasks();

    public TaskEntity getTask(int idTask);

    //public TaskEntity addTask(TaskEntity taskEntity, Integer idApplication);

    public TaskEntity addTask(TaskEntity taskEntity);

    public void deleteTask(TaskEntity taskEntity);
}

