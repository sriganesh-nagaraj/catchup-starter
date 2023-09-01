package com.catchup.starter.adapter.persistance.jpa.events;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class EventEntity {

  @Id
  @Column(name = "id")
  private String id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "scheduled_at")
  private LocalDateTime scheduledAt;

  @Column(name = "organized_by")
  private String organizedBy;

  @Column(name = "attendees_count")
  private Long attendeesCount;

  public EventEntity() {
  }

  public EventEntity(String id, String name, String description,
      LocalDateTime scheduledAt, String organizedBy, Long attendeesCount) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.scheduledAt = scheduledAt;
    this.organizedBy = organizedBy;
    this.attendeesCount = attendeesCount;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDateTime getScheduledAt() {
    return scheduledAt;
  }

  public void setScheduledAt(LocalDateTime scheduledAt) {
    this.scheduledAt = scheduledAt;
  }

  public String getOrganizedBy() {
    return organizedBy;
  }

  public void setOrganizedBy(String organizedBy) {
    this.organizedBy = organizedBy;
  }

  public Long getAttendeesCount() {
    return attendeesCount;
  }

  public void setAttendeesCount(Long attendeesCount) {
    this.attendeesCount = attendeesCount;
  }
}

