package edu.hit.software.se160132.entity;

import edu.hit.software.se160132.entity.constraint.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;

@Entity
@EntityListeners(AuditingEntityListener.class)
//@IdClass(SellShelf.class)
public class SalesOrder implements Identified, Record, SomeGoods, Successor, Action {
    @Id
    @GeneratedValue
    private Long id;
    private Long item;
    private Long goods;
    private Integer amount;
    private Long total;
    private Long original;
    @CreatedDate
    private Instant created;
    private Long precursor;
    private EntityType precursorType;
    private Long actor;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getGoods() {
        return goods;
    }

    @Override
    public void setGoods(Long goods) {
        this.goods = goods;
    }

    public Long getItem() {
        return item;
    }

    public void setItem(Long item) {
        this.item = item;
    }

    @Override
    public Integer getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getOriginal() {
        return original;
    }

    public void setOriginal(Long original) {
        this.original = original;
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
    public Long getActor() {
        return actor;
    }

    @Override
    public void setActor(Long actor) {
        this.actor = actor;
    }
}
