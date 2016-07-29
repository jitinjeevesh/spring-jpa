package sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.domain.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
