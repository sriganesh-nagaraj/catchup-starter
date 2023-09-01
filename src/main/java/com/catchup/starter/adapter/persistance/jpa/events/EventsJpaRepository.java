package com.catchup.starter.adapter.persistance.jpa.events;

import com.catchup.core.events.models.Event;
import com.catchup.core.events.repositories.EventsRepository;
import com.catchup.starter.adapter.persistance.jpa.events.internal.EventsJpaDataAccessor;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EventsJpaRepository implements EventsRepository {

  private EventsJpaDataAccessor eventsJpaDataAccessor;

  @Autowired
  public EventsJpaRepository(EventsJpaDataAccessor eventsJpaRepository) {
    this.eventsJpaDataAccessor = eventsJpaRepository;
  }

  @Override
  public Event saveEvent(Event event) {
    EventEntity eventEntity = new EventEntity(event.id(), event.name(),
        event.description(), event.scheduledAt(), event.organizedBy(),
        event.attendeesCount());
    EventEntity savedEventEntity = eventsJpaDataAccessor.save(eventEntity);
    return event;
  }

  @Override
  public void deleteEvent(String eventId) {
    eventsJpaDataAccessor.deleteById(eventId);
  }

  @Override
  public List<Event> getAllEventsByCreator(String s) {
    return eventsJpaDataAccessor.findAllByOrganizedBy(s).stream()
        .map(EventsJpaRepository::recordMapper).collect(
        Collectors.toList());
  }

  @Override
  public Optional<Event> getEventById(String id) {
    return eventsJpaDataAccessor.findById(id)
        .map(EventsJpaRepository::recordMapper);
  }

  @Override
  public void deleteAll() {
    eventsJpaDataAccessor.deleteAll();
  }

  public static Event recordMapper(EventEntity eventEntity) {
    return new Event(eventEntity.getId(), eventEntity.getName(),
        eventEntity.getDescription(), eventEntity.getScheduledAt(),
        eventEntity.getOrganizedBy(), eventEntity.getAttendeesCount());
  }
}
