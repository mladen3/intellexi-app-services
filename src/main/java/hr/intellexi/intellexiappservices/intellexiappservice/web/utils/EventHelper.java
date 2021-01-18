package hr.intellexi.intellexiappservices.intellexiappservice.web.utils;

import hr.intellexi.intellexiappservices.intellexiappservice.web.domain.Event;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class EventHelper {

    public static List<Event> getTestEventList(){

        List<Event> listToReturn = new ArrayList<>();

        listToReturn.add(Event.builder()
                .title("WorkHours")
                .start(LocalDateTime.now().minusDays(1))
                .end(LocalDateTime.now().minusHours(18))
                .editable(true)
                .build());

        listToReturn.add(Event.builder()
                .title("WorkHours")
                .start(LocalDateTime.now().minusDays(2))
                .end(LocalDateTime.now().minusHours(1).minusHours(16))
                .editable(true)
                .build());

        listToReturn.add(Event.builder()
                .title("WorkHours")
                .start(LocalDateTime.of(2021, Month.JANUARY, 15,8,24))
                .end(LocalDateTime.of(2021, Month.JANUARY, 15, 12, 45))
                .editable(true)
                .build());

        listToReturn.add(Event.builder()
                .title("WorkHours")
                .start(LocalDateTime.of(2021, Month.JANUARY, 11,8,50))
                .end(LocalDateTime.of(2021, Month.JANUARY, 11, 16, 45))
                .editable(true)
                .build());

        listToReturn.add(Event.builder()
                .title("WorkHours")
                .start(LocalDateTime.of(2021, Month.JANUARY, 18,9,0))
                .end(LocalDateTime.of(2021, Month.JANUARY, 18, 17, 24))
                .editable(true)
                .build());

        listToReturn.add(Event.builder()
                .title("WorkHours")
                .start(LocalDateTime.of(2021, Month.JANUARY, 20,7,30))
                .end(LocalDateTime.of(2021, Month.JANUARY, 20, 16, 45))
                .editable(true)
                .build());

        return listToReturn;
    }

}
