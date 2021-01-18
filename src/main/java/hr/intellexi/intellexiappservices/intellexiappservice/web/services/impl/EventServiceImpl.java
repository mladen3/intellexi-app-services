package hr.intellexi.intellexiappservices.intellexiappservice.web.services.impl;

import hr.intellexi.intellexiappservices.intellexiappservice.web.domain.Event;
import hr.intellexi.intellexiappservices.intellexiappservice.web.mappers.EventMapper;
import hr.intellexi.intellexiappservices.intellexiappservice.web.repositories.EventRepository;
import hr.intellexi.intellexiappservices.intellexiappservice.web.model.EventDto;
import hr.intellexi.intellexiappservices.intellexiappservice.web.services.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;


    public EventServiceImpl(EventRepository eventRepository, EventMapper eventMapper){

        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    @Override
    public EventDto getEventById(long id) {
        log.info("Getting event with ID: " + id);
        Event event = eventRepository.findById(id).orElse(new Event());
        return eventMapper.EventToEventDto(event);
    }

    @Override
    public void deleteById(long id) {
        log.info("Deleting event with ID: " + id);
        eventRepository.deleteById(id);
    }

    @Override
    public EventDto saveEvent(EventDto eventDto) {
        log.info("Saving event : " + eventDto.toString());

        Event eventToSave = eventRepository.save(eventMapper.EventDtoToEvent(eventDto));
        return eventMapper.EventToEventDto(eventToSave);

    }

    @Override
    public void updateEvent(EventDto eventDto) {
        log.info("Updating event : " + eventDto.toString());

        eventRepository.save(eventMapper.EventDtoToEvent(eventDto));
    }

    @Override
    public List<EventDto> findAll() {
        log.info("Finding all events");
        return eventRepository.findAll().stream().map(eventMapper::EventToEventDto).collect(Collectors.toList());
    }
}