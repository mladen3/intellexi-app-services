package hr.intellexi.intellexiappservices.intellexiappservice.web.bootstrap;


import hr.intellexi.intellexiappservices.intellexiappservice.web.repositories.EventRepository;
import hr.intellexi.intellexiappservices.intellexiappservice.web.utils.EventHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EventLoader implements CommandLineRunner {

    private final EventRepository eventRepository;

    public EventLoader (EventRepository eventRepository){ this.eventRepository = eventRepository; }


    @Override
    public void run(String... args) throws Exception {
        loadEvents();
    }

    public void loadEvents(){
        if(eventRepository.count() == 0){
            EventHelper.getTestEventList().stream().forEach(event -> eventRepository.save(event));
        }
    }

}
