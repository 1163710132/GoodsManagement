package edu.hit.software.se160132.entity.constraint;

import java.time.Instant;

public interface Record {
    Instant getCreated();
    void setCreated(Instant created);
}
