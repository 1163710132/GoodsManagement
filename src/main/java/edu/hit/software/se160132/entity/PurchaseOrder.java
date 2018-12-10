package edu.hit.software.se160132.entity;

import edu.hit.software.se160132.entity.constraint.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class PurchaseOrder implements Identified, Record, SomeGoods, Successor, Action {
    @Id
    @GeneratedValue
    private Long id;
    private Integer amount;
    private Long goods;
    private Long total;
    @CreatedDate
    private Instant created;
    private Long precursor;
    private EntityType precursorType;
    private Long actor;
    private Long supplier;

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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
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

    public Long getSupplier() {
        return supplier;
    }

    public void setSupplier(Long supplier) {
        this.supplier = supplier;
    }
}
