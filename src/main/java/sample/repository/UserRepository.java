package sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
