package edu.hit.software.se160132.entity;

import edu.hit.software.se160132.entity.constraint.Caused;
import edu.hit.software.se160132.entity.constraint.Immutable;
import edu.hit.software.se160132.entity.constraint.Trans;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.PositiveOrZero;
import java.time.Instant;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class MoneyTrans implements Immutable, Trans, Caused {
    @Id
    @GeneratedValue
    private Long id;
    private Long creator;
    private Long cause;
    private Integer causeType;
    private Long total;
    private Long source;
    private Long target;
    @CreatedDate
    private Instant created;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getCreator() {
        return creator;
    }

    @Override
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public Long getSource() {
        return source;
    }

    @Override
    public void setSource(Long source) {
        this.source = source;
    }

    @Override
    public Long getTarget() {
        return target;
    }

    @Override
    public void setTarget(Long target) {
        this.target = target;
    }

    @Override
    public Instant getCreated() {
        return created;
    }

    @Override
    public void setCreated(Instant created) {
        this.created = created;
    }

    @Override
    public Long getCause() {
        return cause;
    }

    @Override
    public void setCause(Long cause) {
        this.cause = cause;
    }

    @Override
    public Integer getCauseType() {
        return causeType;
    }

    @Override
    public void setCauseType(Integer causeType) {
        this.causeType = causeType;
    }
}
