package hr.intellexi.intellexiappservices.intellexiappservice.web.services.impl;

import hr.intellexi.intellexiappservices.intellexiappservice.repositories.EventRepository;
import hr.intellexi.intellexiappservices.intellexiappservice.web.model.EventDto;
import hr.intellexi.intellexiappservices.intellexiappservice.web.services.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EventServiceImpl implements EventService {

    public final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    @Override
    public EventDto getEventById(long id) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public EventDto saveEvent(EventDto eventDto) {
        return null;
    }

    @Override
    public void updateEvent(EventDto eventDto) {

    }

    @Override
    public List<EventDto> findAll() {
        return null;
    }
}