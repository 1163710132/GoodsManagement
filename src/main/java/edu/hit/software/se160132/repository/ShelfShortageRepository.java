package edu.hit.software.se160132.repository;

import edu.hit.software.se160132.entity.ShelfShortage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfShortageRepository extends JpaRepository<ShelfShortage, Long> {
}
