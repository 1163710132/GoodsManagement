package edu.hit.software.se160132.entity;

import edu.hit.software.se160132.entity.constraint.Action;
import edu.hit.software.se160132.entity.constraint.Identified;
import edu.hit.software.se160132.entity.constraint.Record;
import edu.hit.software.se160132.entity.constraint.SomeGoods;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class ShelfShortage implements Identified, Record, SomeGoods, Action {
    @Id
    @GeneratedValue
    private Long id;
    private Integer amount;
    private Long goods;
    @CreatedDate
    private Instant created;
    private Long actor;
    private Long shelf;
    private Long item;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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
    public Long getGoods() {
        return goods;
    }

    @Override
    public void setGoods(Long goods) {
        this.goods = goods;
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

    public Long getShelf() {
        return shelf;
    }

    public void setShelf(Long shelf) {
        this.shelf = shelf;
    }

    public Long getItem() {
        return item;
    }

    public void setItem(Long item) {
        this.item = item;
    }
}
