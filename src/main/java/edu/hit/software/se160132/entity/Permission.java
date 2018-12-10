package edu.hit.software.se160132.entity;

import edu.hit.software.se160132.entity.constraint.Identified;
import edu.hit.software.se160132.entity.constraint.Record;
import edu.hit.software.se160132.security.Role;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Permission implements Identified, Record {
    @Id
    @GeneratedValue
    private Long id;
    private Long accountId;
    private Role role;
    private Long target;
    private Long grantor;
    @CreatedDate
    private Instant created;

    public Permission(){

    }

    public Permission(Long accountId, Role role, Long target){
        this.accountId = accountId;
        this.role = role;
        this.target = target;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getTarget() {
        return target;
    }

    public void setTarget(Long target) {
        this.target = target;
    }

    public Long getGrantor() {
        return grantor;
    }

    public void setGrantor(Long grantor) {
        this.grantor = grantor;
    }

    @Override
    public Instant getCreated() {
        return created;
    }

    @Override
    public void setCreated(Instant created) {
        this.created = created;
    }

    public static String of(Role role, Long target){
        return role.name() + ":" + target;
    }
}
