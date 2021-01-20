package hr.intellexi.intellexiappservices.intellexiappservice.web.mappers;

import hr.intellexi.intellexiappservices.intellexiappservice.web.domain.Project;
import hr.intellexi.intellexiappservices.intellexiappservice.web.model.ProjectDto;
import org.mapstruct.Mapper;

@Mapper
public interface ProjectMapper {

    ProjectDto ProjectToProjectDto (Project project);

    Project ProjectDtoToProject (ProjectDto projectDto);
}
