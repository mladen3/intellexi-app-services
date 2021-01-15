package hr.intellexi.intellexiappservices.intellexiappservice.mappers;


import hr.intellexi.intellexiappservices.intellexiappservice.domain.Event;
import hr.intellexi.intellexiappservices.intellexiappservice.web.model.EventDto;
import org.mapstruct.Mapper;

@Mapper
public interface EventMapper {

    EventDto EventToEventDto(Event event);

    Event EventDtoToEvent(EventDto eventDto);

}
