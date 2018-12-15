package edu.hit.software.se160132.repository;

import edu.hit.software.se160132.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
