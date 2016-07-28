package sample.repository;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class MyRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements MyRepository<T, ID> {

    private final EntityManager entityManager;

    public MyRepositoryImpl(Class<T> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public T sharedMethod(ID id) {
        Class<T> domainType = getDomainClass();
        return entityManager.find(domainType, id);
    }
}
