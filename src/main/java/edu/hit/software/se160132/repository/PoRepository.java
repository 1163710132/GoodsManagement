package edu.hit.software.se160132.repository;

import edu.hit.software.se160132.entity.EntityType;
import edu.hit.software.se160132.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoRepository extends JpaRepository<PurchaseOrder, Long> {
    public List<PurchaseOrder> streamByPrecursorAndPrecursorType(Long precursor, EntityType precursorType);
}
