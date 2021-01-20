package hr.intellexi.intellexiappservices.intellexiappservice.web.utils;

import hr.intellexi.intellexiappservices.intellexiappservice.web.domain.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectHelper {


    public static List<Project> getProjectTestList(){

        List<Project> listToReturn = new ArrayList<>();

        listToReturn.add(Project.builder()
                .name("PBZ DIGICAL")
                .active(true)
                .build());

        listToReturn.add(Project.builder()
                .name("INTELLEXI APP")
                .active(true)
                .build());

        listToReturn.add(Project.builder()
                .name("CBC")
                .active(true)
                .build());

        listToReturn.add(Project.builder()
                .name("AVAYA BMF")
                .active(true)
                .build());

        listToReturn.add(Project.builder()
                .name("ISKRA")
                .active(true)
                .build());

        listToReturn.add(Project.builder()
                .name("ERICSSON")
                .active(true)
                .build());

        return listToReturn;
    }
}
