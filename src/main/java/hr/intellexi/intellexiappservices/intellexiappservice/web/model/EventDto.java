package hr.intellexi.intellexiappservices.intellexiappservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDto {

    private long id;
    private String title;
    private LocalDateTime start;
    private LocalDateTime end;
    private Boolean editable;
}
