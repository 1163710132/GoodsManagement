package edu.hit.software.se160132.repository;

import edu.hit.software.se160132.entity.StockAllocate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockAllocateRepository extends JpaRepository<StockAllocate, Long> {

}
