package hr.intellexi.intellexiappservices.intellexiappservice.web.services;


import hr.intellexi.intellexiappservices.intellexiappservice.web.model.EventDto;

import java.util.List;

public interface EventService {

    EventDto getEventById(long id);

    void deleteById(long id);

    EventDto saveEvent(EventDto eventDto);

    void updateEvent(EventDto eventDto);

    List<EventDto> findAll();
}
