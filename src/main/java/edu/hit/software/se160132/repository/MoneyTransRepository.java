package edu.hit.software.se160132.repository;

import edu.hit.software.se160132.entity.GoodsTrans;
import edu.hit.software.se160132.entity.MoneyTrans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyTransRepository extends JpaRepository<MoneyTrans, Long> {
}
