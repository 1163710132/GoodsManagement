package edu.hit.software.se160132.entity.constraint;

import java.time.Instant;

public interface Mutable extends Identified {
    Instant getCreated();
    void setCreated(Instant created);
    Instant getLastModified();
    void setLastModified(Instant lastModified);
    Long getVersion();
    void setVersion(Long version);
}
