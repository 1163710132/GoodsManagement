package edu.hit.software.se160132.entity;

import edu.hit.software.se160132.entity.constraint.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class ShelfSupply implements Identified, Record, SomeGoods, Successor, Action{
    @Id
    @GeneratedValue
    private Long id;
    private Long shelf;
    private Long goods;
    private Integer amount;
    @CreatedDate
    private Instant created;
    private Long precursor;
    private EntityType precursorType;
    private Long actor;
    private Long item;

    @Override
    public Long getPrecursor() {
        return precursor;
    }

    @Override
    public void setPrecursor(Long precursor) {
        this.precursor = precursor;
    }

    @Override
    public EntityType getPrecursorType() {
        return precursorType;
    }

    @Override
    public void setPrecursorType(EntityType precursorType) {
        this.precursorType = precursorType;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getShelf() {
        return shelf;
    }

    public void setShelf(Long shelf) {
        this.shelf = shelf;
    }

    @Override
    public Long getGoods() {
        return goods;
    }

    @Override
    public void setGoods(Long goods) {
        this.goods = goods;
    }

    @Override
    public Integer getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Integer amount) {
        this.amount = amount;
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
    public Long getActor() {
        return actor;
    }

    @Override
    public void setActor(Long actor) {
        this.actor = actor;
    }

    public Long getItem() {
        return item;
    }

    public void setItem(Long item) {
        this.item = item;
    }
}
