package com.exe.applicationTask.services;

import com.exe.applicationTask.persistence.entities.ApplicationEntity;
import com.exe.applicationTask.persistence.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService{

    @Autowired
    private ApplicationRepository applicationRepository;
    @Override
    public List<ApplicationEntity> getAllApplications() {
        List<ApplicationEntity> applications = applicationRepository.findAll();
        return applications;
    }

    @Override
    public ApplicationEntity getApplication(int idApplication) {

        ApplicationEntity application = applicationRepository.findById(idApplication).orElse(null);

        return application;
    }

    @Override
    public ApplicationEntity addApplication(ApplicationEntity applicationEntity) {
        return applicationRepository.save(applicationEntity);
    }

    @Override
    public void deleteApplication(ApplicationEntity applicationEntity){
        applicationRepository.delete(applicationEntity);
    }


}
