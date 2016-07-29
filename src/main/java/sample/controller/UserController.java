package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("custom")
    public User customRepository() {
        return userRepository.customMethod();
    }

    @RequestMapping("shared")
    public User sharedRepository() {
        return userRepository.sharedMethod(1l);
    }

    @RequestMapping("pageable")
    public List<User> pageable(@RequestParam(required = false) int page, @RequestParam(required = false) int size) {
        Pageable pageable = new PageRequest(page, size);
        return userRepository.findAllByName("one", pageable);
    }
}
