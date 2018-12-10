package edu.hit.software.se160132.entity.constraint;

import edu.hit.software.se160132.entity.EntityType;

public interface Successor {
    Long getPrecursor();
    void setPrecursor(Long precursor);
    EntityType getPrecursorType();
    void setPrecursorType(EntityType precursorType);
}
