package edu.hit.software.se160132.repository;

import edu.hit.software.se160132.entity.StockItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockItemRepository extends JpaRepository<StockItem, Long> {
    StockItem findByStockAndGoods(Long stock, Long goods);
    Optional<StockItem> findFirstByStockAndGoods(Long stock, Long goods);
}
