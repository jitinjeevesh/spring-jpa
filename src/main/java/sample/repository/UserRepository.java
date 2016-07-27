package sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sample.domain.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository {

    User findByEmail(String email);

    User findByName(String name);

    List<User> findAllByName(String name);

    @Query("select u from User u where u.name=?1")
    User findByUserName(String name);

    @Query(value = "select * from user where full_name=?1", nativeQuery = true)
    User findByUserNameNative(String name);

    List<User> findByNameNamed(String name);
}
