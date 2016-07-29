package sample.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.dao.UserDao;
import sample.domain.AdminUser;
import sample.domain.NormalUser;
import sample.domain.Sale;
import sample.domain.User;
import sample.repository.SaleRepository;

@Component
public class BootStrapUtil implements InitializingBean {
    @Autowired
    private UserDao userDao;
    @Autowired
    private SaleRepository saleRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        User user = new User();
        user.setEmail("one");
        user.setName("one");
        userDao.save(user);

        User user2 = new User();
        user2.setEmail("one@gmail.com");
        user2.setName("one");
        userDao.save(user2);

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


        Sale sale = new Sale();
        sale.setUser(user);
        saleRepository.save(sale);
        Sale sale1 = new Sale();
        sale1.setUser(user);
        saleRepository.save(sale1);

    }
}
