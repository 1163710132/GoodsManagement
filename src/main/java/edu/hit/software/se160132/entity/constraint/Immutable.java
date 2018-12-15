package edu.hit.software.se160132.entity.constraint;

import java.time.Instant;

public interface Immutable extends Identified {
    Long getCreator();
    void setCreator(Long creator);
    Instant getCreated();
    void setCreated(Instant created);
}
