package com.exe.applicationTask.services;

import com.exe.applicationTask.persistence.entities.ApplicationEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface ApplicationService {

    public List<ApplicationEntity> getAllApplications();

    public ApplicationEntity getApplication(int idApplication);

    public ApplicationEntity addApplication(ApplicationEntity applicationEntity);

    public void deleteApplication(ApplicationEntity applicationEntity);
}
