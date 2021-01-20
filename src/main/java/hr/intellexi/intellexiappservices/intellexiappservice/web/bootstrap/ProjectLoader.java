package hr.intellexi.intellexiappservices.intellexiappservice.web.bootstrap;

import hr.intellexi.intellexiappservices.intellexiappservice.web.repositories.ProjectRepository;
import hr.intellexi.intellexiappservices.intellexiappservice.web.utils.ProjectHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProjectLoader implements CommandLineRunner {


    private final ProjectRepository projectRepository;

    public ProjectLoader(ProjectRepository projectRepository) { this.projectRepository = projectRepository; }


    @Override
    public void run(String... args) throws Exception {
        loadProjects();
    }

    public void loadProjects(){
        if(projectRepository.count() == 0){
            ProjectHelper.getProjectTestList().stream().forEach(project -> projectRepository.save(project));
        }
    }
}
