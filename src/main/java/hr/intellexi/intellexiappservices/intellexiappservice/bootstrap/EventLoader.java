package hr.intellexi.intellexiappservices.intellexiappservice.bootstrap;


import hr.intellexi.intellexiappservices.intellexiappservice.repositories.EventRepository;
import hr.intellexi.intellexiappservices.intellexiappservice.utils.EventHelper;
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
