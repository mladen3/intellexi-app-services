package hr.intellexi.intellexiappservices.intellexiappservice.web.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProjectDto {

    private long id;
    private String name;
    private Boolean active;
}
