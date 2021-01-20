package hr.intellexi.intellexiappservices.intellexiappservice.web.controllers;


import hr.intellexi.intellexiappservices.intellexiappservice.web.model.ProjectDto;
import hr.intellexi.intellexiappservices.intellexiappservice.web.services.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/v1/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController (ProjectService projectService) { this.projectService = projectService; }

    @GetMapping
    public List<ProjectDto> findAll (){ return projectService.findAll();  }

    @GetMapping("{projectId")
    public ProjectDto getById (@PathVariable("projectId") long projectId){ return projectService.getProjectById(projectId); }

    @DeleteMapping("{projectId")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById (@PathVariable("projectId") long projectId) { projectService.deleteById(projectId); }

    @PostMapping
    public ResponseEntity<ProjectDto> saveProject(@RequestBody ProjectDto projectDto){
        return new ResponseEntity<>(projectService.saveProject(projectDto), HttpStatus.OK);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateProject(@RequestBody ProjectDto projectDto) { projectService.saveProject(projectDto); }



}
