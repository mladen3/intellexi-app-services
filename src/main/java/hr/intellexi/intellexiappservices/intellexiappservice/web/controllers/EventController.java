package hr.intellexi.intellexiappservices.intellexiappservice.web.controllers;


import hr.intellexi.intellexiappservices.intellexiappservice.web.model.EventDto;
import hr.intellexi.intellexiappservices.intellexiappservice.web.services.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/v1/event")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping("/findAll")
    public List<EventDto> findAll(){ return eventService.findAll(); }

    @GetMapping("{eventId}")
    public EventDto getEvent(@PathVariable("eventId") long eventId){ return eventService.getEventById(eventId); }

    @PostMapping
    public ResponseEntity<EventDto> saveEvent(@RequestBody EventDto eventDto){
        return  new ResponseEntity<>(eventService.saveEvent(eventDto), HttpStatus.OK);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateEvent(@RequestBody EventDto eventDto){  eventService.updateEvent(eventDto); }

    @DeleteMapping("{eventId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEvent(@RequestParam("eventId") long eventId){ eventService.deleteById(eventId); }

}
