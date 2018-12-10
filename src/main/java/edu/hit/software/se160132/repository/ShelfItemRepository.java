package edu.hit.software.se160132.repository;

import edu.hit.software.se160132.entity.ShelfDelivery;
import edu.hit.software.se160132.entity.ShelfItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfItemRepository extends JpaRepository<ShelfItem, Long> {
}
