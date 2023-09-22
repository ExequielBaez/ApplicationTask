package com.exe.applicationTask.controller;

import com.exe.applicationTask.exception.RegisterNotFound;
import com.exe.applicationTask.persistence.entities.ApplicationEntity;
import com.exe.applicationTask.services.ApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public List<ApplicationEntity> getAllApplications(){

        var applications = applicationService.getAllApplications();

        applications.forEach(application -> logger.info(application.toString()));

        return applications;
    }
    @GetMapping("/{idApplication}")
    public ResponseEntity<ApplicationEntity> getApplication(@PathVariable int idApplication){

        ApplicationEntity application = applicationService.getApplication(idApplication);

        if(application == null){
            throw new RegisterNotFound("No se encontro el empleado id: " +idApplication);
        }
        return ResponseEntity.ok(application);
    }

    @PostMapping
    public ApplicationEntity addApplication(@RequestBody ApplicationEntity application){
        logger.info("Application to create: " +application);
        return applicationService.addApplication(application);

    }

    @DeleteMapping("/{idApplication}")
    public ResponseEntity<Map<String, Boolean>>
            deleteApplication(@PathVariable int idApplication){
                ApplicationEntity application = applicationService.getApplication(idApplication);

                if(application == null){
                    throw new RegisterNotFound("ID not found " +idApplication);
                }
                applicationService.deleteApplication(application);
                //JSON{"delete" : true}
                Map<String, Boolean> response = new HashMap<>();
                response.put("Delete", Boolean.TRUE);
                return ResponseEntity.ok(response);

    }

}
