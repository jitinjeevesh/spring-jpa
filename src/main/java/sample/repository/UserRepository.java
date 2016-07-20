package sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.domain.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByName(String name);

    List<User> findAllByName(String name);
}
