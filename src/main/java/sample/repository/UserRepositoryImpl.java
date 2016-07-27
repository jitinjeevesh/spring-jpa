package sample.repository;

import sample.domain.User;

public class UserRepositoryImpl implements UserCustomRepository {
    @Override
    public User customMethod() {
        User user = new User();
        user.setId(1l);
        user.setEmail("custom@mail.com");
        user.setName("Custom User");
        return user;
    }
}
