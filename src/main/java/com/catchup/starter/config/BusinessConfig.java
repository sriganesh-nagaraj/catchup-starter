package com.catchup.starter.config;

import com.catchup.core.events.serviceimpls.EventsServiceImpl;
import com.catchup.core.events.services.EventsService;
import com.catchup.starter.adapter.persistance.jpa.events.EventsJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusinessConfig {

  @Autowired
  private EventsJpaRepository eventsJpaRepository;

  @Bean
  public EventsService getEventsService() {
    return new EventsServiceImpl(eventsJpaRepository);
  }

}
