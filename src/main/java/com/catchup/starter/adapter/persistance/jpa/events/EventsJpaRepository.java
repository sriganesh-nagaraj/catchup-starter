package com.catchup.starter.adapter.persistance.jpa.events;

import com.catchup.core.events.models.Event;
import com.catchup.core.events.repositories.EventsRepository;
import com.catchup.starter.adapter.persistance.jpa.events.internal.EventsJpaDataAccessor;
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
        event.description());
    EventEntity savedEventEntity = eventsJpaDataAccessor.save(eventEntity);
    return event;
  }
}
