package com.exe.applicationTask.services;

import com.exe.applicationTask.persistence.entities.TaskEntity;
import com.exe.applicationTask.persistence.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {


    @Autowired
    private TaskRepository taskRepository;
    @Override
    public List<TaskEntity> getAllTasks() {
        List<TaskEntity> task = taskRepository.findAll();
        return task;
    }

    @Override
    public TaskEntity getTask(int idTask) {

        TaskEntity task = taskRepository.findById(idTask).orElse(null);

        return task;
    }

    @Override
    public TaskEntity addTask(TaskEntity taskEntity) {
        return taskRepository.save(taskEntity);
    }

    @Override
    public void deleteTask(TaskEntity taskEntity){
        taskRepository.delete(taskEntity);
    }
}
