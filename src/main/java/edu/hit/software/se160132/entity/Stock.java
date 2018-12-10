package edu.hit.software.se160132.entity;

import edu.hit.software.se160132.entity.constraint.Described;
import edu.hit.software.se160132.entity.constraint.Identified;
import edu.hit.software.se160132.entity.constraint.Mutable;
import edu.hit.software.se160132.entity.constraint.Named;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Stock implements Identified, Named, Described, Mutable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @Version
    private Long version;
    @LastModifiedDate
    private Instant lastModified;
    @CreatedDate
    private Instant created;

    public Stock(){}

    public Stock(Long id, String name){
        this.id = id;
        this.name = name;
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
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Long getVersion() {
        return version;
    }

    @Override
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public Instant getLastModified() {
        return lastModified;
    }

    @Override
    public void setLastModified(Instant lastModified) {
        this.lastModified = lastModified;
    }
}
