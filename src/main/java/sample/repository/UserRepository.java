package sample.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sample.domain.User;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends MyRepository<User, Long>, UserCustomRepository {

    User findByEmail(@Param("email") String email);

    User findByName(String name);

    List<User> findAllByName(String name);

    List<User> findAllByName(String name, Pageable pageable);

    @Query("select u from User u where u.name=?1")
    User findByUserName(String name);

    @Query(value = "select * from user where full_name=?1", nativeQuery = true)
    User findByUserNameNative(String name);

    List<User> findByNameNamed(String name);
}
