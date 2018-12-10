package edu.hit.software.se160132.entity.constraint;

import java.time.Instant;

public interface Mutable extends Record{
    public Long getVersion();
    public void setVersion(Long version);
    public Instant getLastModified();
    public void setLastModified(Instant instant);
}
