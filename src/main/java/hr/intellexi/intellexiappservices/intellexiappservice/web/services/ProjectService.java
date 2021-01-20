package hr.intellexi.intellexiappservices.intellexiappservice.web.services;

import hr.intellexi.intellexiappservices.intellexiappservice.web.model.ProjectDto;

import java.util.List;

public interface ProjectService {

    List<ProjectDto> findAll();

    void deleteById (long projectId);

    ProjectDto saveProject(ProjectDto projectDto);

    void updateProject(ProjectDto projectDto);

    ProjectDto getProjectById (long projectId);
}
