package com.catchup.starter.adapter.rest.events;


import com.catchup.core.events.models.CreateEventRequest;
import com.catchup.core.events.models.Event;
import com.catchup.core.events.services.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventsController {

  private EventsService eventsService;

  @Autowired
  public EventsController(EventsService eventsService) {
    this.eventsService = eventsService;
  }

  @PostMapping
  public ResponseEntity<Event> createEvent(
      @RequestBody CreateEventRequest createEventRequest) {
    return ResponseEntity.ok(eventsService.createEvent(createEventRequest));
  }


}
