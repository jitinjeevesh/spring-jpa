package sample.custom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import sample.repository.MyRepositoryImpl;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class MyRepositoryFactoryBean<R extends JpaRepository<T, I>, T, I extends Serializable> extends JpaRepositoryFactoryBean<R, T, I> {

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new MyRepositoryFactory(entityManager);
    }

    private static class MyRepositoryFactory<T, I extends Serializable> extends JpaRepositoryFactory {

        private EntityManager entityManager;

        public MyRepositoryFactory(EntityManager entityManager) {
            super(entityManager);

            this.entityManager = entityManager;
        }

        @Override
        protected Object getTargetRepository(RepositoryMetadata metadata) {
            return new MyRepositoryImpl<T, I>((Class<T>) metadata.getDomainType(), entityManager);
        }

        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return MyRepositoryImpl.class;
        }
    }
}
