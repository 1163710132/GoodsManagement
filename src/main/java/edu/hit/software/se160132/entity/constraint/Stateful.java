package edu.hit.software.se160132.entity.constraint;

import edu.hit.software.se160132.entity.State;

public interface Stateful extends Mutable {
    State getState();
    void setState(State state);
}
