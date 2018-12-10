package edu.hit.software.se160132.repository;

import edu.hit.software.se160132.entity.EntityType;
import edu.hit.software.se160132.entity.StockSupply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockSupplyRepository extends JpaRepository<StockSupply, Long> {
    List<StockSupply> findByPrecursorAndPrecursorType(Long precursor, EntityType precursorType);
    Optional<StockSupply> findFirstByPrecursorAndPrecursorType(Long precursor, EntityType precursorType);
}
