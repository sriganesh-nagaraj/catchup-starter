CREATE TABLE events (
    id VARCHAR(55) PRIMARY KEY,
    name TEXT,
    description TEXT,
    scheduled_at TIMESTAMP,
    organized_by VARCHAR(55),
    attendees_count INTEGER
);