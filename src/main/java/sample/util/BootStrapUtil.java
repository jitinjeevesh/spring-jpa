package sample.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.dao.UserDao;
import sample.domain.AdminUser;
import sample.domain.NormalUser;
import sample.domain.User;

@Component
public class BootStrapUtil implements InitializingBean {
    @Autowired
    private UserDao userDao;

    @Override
    public void afterPropertiesSet() throws Exception {
        User user = new User();
        user.setEmail("one");
        user.setName("one");
        userDao.save(user);

        AdminUser admin = new AdminUser();
        admin.setEmail("two");
        admin.setName("two");
        admin.setType("two");
        userDao.save(admin);

        NormalUser normalUser = new NormalUser();
        normalUser.setEmail("three");
        normalUser.setName("three");
        normalUser.setMobile(1234566l);
        userDao.save(normalUser);
    }
}
