package com.catchup.starter.adapter.rest.events;


import com.catchup.core.events.models.CreateEventRequest;
import com.catchup.core.events.models.Event;
import com.catchup.core.events.models.UpdateEventRequest;
import com.catchup.core.events.services.EventsService;
import common.exceptions.ValidationException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @GetMapping
  public ResponseEntity<List<Event>> getAllEventsByCreator(@RequestParam(
      "organized-by") String organizedBy) {
    return ResponseEntity.ok(eventsService.getAllEventsByCreator(organizedBy));
  }

  @DeleteMapping("/{id}")
  public void deleteEvent(@PathVariable String id) {
    eventsService.deleteEvent(id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Event> updateEvent(@RequestBody UpdateEventRequest updateEventRequest) {
    try {
      Event event = eventsService.updateEvent(updateEventRequest);
      return ResponseEntity.ok(event);
    } catch (ValidationException e) {
      return ResponseEntity.badRequest().build();
    }
  }


}
