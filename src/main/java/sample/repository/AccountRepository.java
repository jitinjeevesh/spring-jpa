package sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
