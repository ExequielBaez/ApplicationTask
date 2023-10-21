package com.exe.applicationTask.controller;

import com.exe.applicationTask.exception.RegisterNotFound;
import com.exe.applicationTask.persistence.entities.ApplicationEntity;
import com.exe.applicationTask.services.ApplicationService;
import org.apache.coyote.Response;
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
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public ResponseEntity<?> getAllApplications(){

        var applications = applicationService.getAllApplications();

        applications.forEach(application -> logger.info(application.toString()));

        Map<String, Object> response = Map.of("message", "Applications List", "data", applications);

        // return ResponseEntity.ok(response)
        return new ResponseEntity<>(response, OK);
    }

    @GetMapping("/{idApplication}")
    public ResponseEntity<?> getApplication(@PathVariable int idApplication){

        ApplicationEntity application = applicationService.getApplication(idApplication);

        if(application == null){

            throw new RegisterNotFound("No se encontro el empleado id: " +idApplication);
        }
        return ResponseEntity.ok(application);
    }

    @PostMapping
    public ResponseEntity<?> addApplicaton(@RequestBody ApplicationEntity application){
        logger.info("Application to create: " +application);
        applicationService.addApplication(application);
        //obteniendo el URI de servicio
        String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/")
                .path("{id}").buildAndExpand(application.getIdApplication()).toUriString();
        // sin URI return applicationService.addApplication(application);
        return ResponseEntity.status(CREATED).body(uri);
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
