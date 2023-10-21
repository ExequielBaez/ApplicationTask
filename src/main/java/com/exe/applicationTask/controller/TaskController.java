package com.exe.applicationTask.controller;

import com.exe.applicationTask.exception.RegisterNotFound;
import com.exe.applicationTask.persistence.entities.ApplicationEntity;
import com.exe.applicationTask.persistence.entities.TaskEntity;
import com.exe.applicationTask.services.ApplicationService;
import com.exe.applicationTask.services.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<?> getAllApplications(){

        var tasks = taskService.getAllTasks();

        tasks.forEach(task -> logger.info(task.toString()));
        //return ResponseEntity.ok(tasks);
        Map<String, Object> response = Map.of("message", "Tasks List", "data", tasks);

        // return ResponseEntity.ok(response)
        return new ResponseEntity<>(response, OK);
    }
    @GetMapping("/{idTask}")
    public ResponseEntity<?> getApplication(@PathVariable int idTask){

        TaskEntity task = taskService.getTask(idTask);

        if(task == null){
            throw new RegisterNotFound("No se encontro el empleado id: " +idTask);
        }
        return ResponseEntity.ok(task);
    }

    /*@PostMapping
    public TaskEntity addTask(@RequestBody TaskEntity task, @RequestParam("idApplication") Integer idApplication ){
        logger.info("Task to create: " +task);
        return taskService.addTask(task, idApplication);

    }*/

    @PostMapping
    public ResponseEntity<?> addTask(@RequestBody TaskEntity task) {
        logger.info("Task to create: " + task);
        taskService.addTask(task);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(task.getIdTask()).toUri();

        return ResponseEntity.created(uri).body(task);
    }

    @DeleteMapping("/{idTask}")
    public ResponseEntity<Map<String, Boolean>>
    deleteTask(@PathVariable int idTask){
        TaskEntity task = taskService.getTask(idTask);

        if(task == null){
            throw new RegisterNotFound("ID not found " +idTask);
        }
        taskService.deleteTask(task);
        //JSON{"delete" : true}
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }
}
