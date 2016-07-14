package sample.dao;

import org.springframework.stereotype.Repository;
import sample.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public User save(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
            return user;
        } else {
            return entityManager.merge(user);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> list() {
        Query typedQuery = entityManager.createQuery("select u from User u");
        return typedQuery.getResultList();
    }
}
