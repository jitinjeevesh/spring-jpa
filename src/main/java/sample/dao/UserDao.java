package sample.dao;

import sample.domain.User;

import java.util.List;

public interface UserDao {

    User save(User user);

    List<User> list();
}
