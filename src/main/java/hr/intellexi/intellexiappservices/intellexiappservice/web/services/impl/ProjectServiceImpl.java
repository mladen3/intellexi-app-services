package hr.intellexi.intellexiappservices.intellexiappservice.web.services.impl;

import hr.intellexi.intellexiappservices.intellexiappservice.web.domain.Project;
import hr.intellexi.intellexiappservices.intellexiappservice.web.mappers.ProjectMapper;
import hr.intellexi.intellexiappservices.intellexiappservice.web.model.ProjectDto;
import hr.intellexi.intellexiappservices.intellexiappservice.web.repositories.ProjectRepository;
import hr.intellexi.intellexiappservices.intellexiappservice.web.services.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper){
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }


    @Override
    public List<ProjectDto> findAll() {
        log.info("Finding all Projects");
        return projectRepository.findAll().stream().map(projectMapper::ProjectToProjectDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(long projectId) {

        log.info("Deleting project by ID: ",projectId);
        projectRepository.deleteById(projectId);

    }

    @Override
    public ProjectDto saveProject(ProjectDto projectDto) {
        log.info("Saving project: ",projectDto);
        Project projectToSave = projectRepository.save(projectMapper.ProjectDtoToProject(projectDto));
        return projectMapper.ProjectToProjectDto(projectToSave);
    }

    @Override
    public void updateProject(ProjectDto projectDto) {
        log.info("Updating project: ",projectDto);
        projectRepository.save(projectMapper.ProjectDtoToProject(projectDto));

    }

    @Override
    public ProjectDto getProjectById(long projectId) {
        log.info("Finding project with id: ",projectId);
        Project projectToReturn = projectRepository.findById(projectId).orElse(new Project());
        log.info("Returning project: ",projectToReturn);
        return projectMapper.ProjectToProjectDto(projectToReturn);
    }
}
