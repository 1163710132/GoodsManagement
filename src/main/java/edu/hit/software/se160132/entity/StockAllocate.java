package edu.hit.software.se160132.entity;

import edu.hit.software.se160132.entity.constraint.Action;
import edu.hit.software.se160132.entity.constraint.Identified;
import edu.hit.software.se160132.entity.constraint.Record;
import edu.hit.software.se160132.entity.constraint.SomeGoods;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class StockAllocate implements Identified, Record, SomeGoods, Action {
    @Id
    @GeneratedValue
    private Long id;
    private Integer amount;
    @CreatedDate
    private Instant created;
    private Long goods;
    @Column(name = "_from")
    private Long from;
    @Column(name = "_to")
    private Long to;
    private Long actor;

    @Override
    public Integer getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Integer amount) {
        this.amount = amount;
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
    public Instant getCreated() {
        return created;
    }

    @Override
    public void setCreated(Instant created) {
        this.created = created;
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
    public Long getActor() {
        return actor;
    }

    @Override
    public void setActor(Long actor) {
        this.actor = actor;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }
}
