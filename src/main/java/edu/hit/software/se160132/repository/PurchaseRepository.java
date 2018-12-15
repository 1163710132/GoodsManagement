package edu.hit.software.se160132.repository;

import edu.hit.software.se160132.entity.GoodsTrans;
import edu.hit.software.se160132.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
