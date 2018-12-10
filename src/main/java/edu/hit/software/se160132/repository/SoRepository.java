package edu.hit.software.se160132.repository;

import edu.hit.software.se160132.entity.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoRepository extends JpaRepository<SalesOrder, Long> {
}
