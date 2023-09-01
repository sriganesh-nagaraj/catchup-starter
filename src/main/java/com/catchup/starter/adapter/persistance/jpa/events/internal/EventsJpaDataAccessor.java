package com.catchup.starter.adapter.persistance.jpa.events.internal;

import com.catchup.starter.adapter.persistance.jpa.events.EventEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsJpaDataAccessor extends JpaRepository<EventEntity,
    String> {

  List<EventEntity> findAllByOrganizedBy(String organizedBy);


}
