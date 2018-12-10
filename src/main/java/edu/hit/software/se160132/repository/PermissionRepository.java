package edu.hit.software.se160132.repository;

import edu.hit.software.se160132.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    List<Permission> streamByAccountId(Long accountId);
}
