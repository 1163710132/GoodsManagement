package edu.hit.software.se160132.repository;

import edu.hit.software.se160132.entity.StockDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDeliveryRepository extends JpaRepository<StockDelivery, Long> {
}
