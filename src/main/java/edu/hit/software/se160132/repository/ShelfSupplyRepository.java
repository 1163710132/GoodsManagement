package edu.hit.software.se160132.repository;

import edu.hit.software.se160132.entity.Shelf;
import edu.hit.software.se160132.entity.ShelfSupply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfSupplyRepository extends JpaRepository<ShelfSupply, Long> {
}
