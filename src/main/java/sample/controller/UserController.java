package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.dao.UserDao;
import sample.domain.User;
import sample.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("save")
    public User save() {
        User user = new User();
        user.setName("Jeevesh");
        user.setEmail("jeevesh@gmail.com");
        return userDao.save(user);
    }

    @RequestMapping("saveWithRepository")
    public User saveWithRepository() {
        User user = new User();
        user.setName("Jeevesh Pandey");
        user.setEmail("jeeveshpandey@gmail.com");
        return userRepository.save(user);
    }

    @RequestMapping("list")
    public List<User> list() {
        return userDao.list();
    }

    @RequestMapping("findByName/{name}")
    public User findByName(@PathVariable String name) {
        return userRepository.findByEmail(name);
    }

    @RequestMapping("findByNameQuery/{name}")
    public User findByNameQuery(@PathVariable String name) {
        return userRepository.findByUserName(name);
    }

    @RequestMapping("findByNameNativeQuery/{name}")
    public User findByNameNativeQuery(@PathVariable String name) {
        return userRepository.findByUserNameNative(name);
    }

    @RequestMapping("findByNameNamed/{name}")
    public List<User> findByNameNamed(@PathVariable String name) {
        return userRepository.findByNameNamed(name);
    }
}
