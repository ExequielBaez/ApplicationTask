package com.exe.applicationTask.services;

import com.exe.applicationTask.persistence.entities.ApplicationEntity;
import com.exe.applicationTask.persistence.entities.TaskEntity;
import com.exe.applicationTask.persistence.repositories.ApplicationRepository;
import com.exe.applicationTask.persistence.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {


    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

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

   /* @Override
    public TaskEntity addTask(TaskEntity taskEntity , Integer idApplication) {



        ApplicationEntity applicationEntity = applicationRepository.findById(idApplication).orElse(null);

        taskEntity.setApplication(applicationEntity);

        return taskRepository.save(taskEntity);
    }*/

    @Override
    public TaskEntity addTask(TaskEntity taskEntity) {

        ApplicationEntity applicationEntity = applicationRepository
                .findById(taskEntity.getApplication().getIdApplication()).orElse(null);

        taskEntity.setApplication(applicationEntity);

        return taskRepository.save(taskEntity);


    }

    @Override
    public void deleteTask(TaskEntity taskEntity){
        taskRepository.delete(taskEntity);
    }
}
