package sample.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.dao.UserDao;
import sample.domain.AdminUser;
import sample.domain.NormalUser;
import sample.domain.Account;
import sample.domain.User;
import sample.repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class BootStrapUtil implements InitializingBean {
    @Autowired
    private UserDao userDao;
    @Autowired
    private AccountRepository accountRepository;

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


        Account account = new Account();
        accountRepository.save(account);
        Account account1 = new Account();
        accountRepository.save(account1);

        List<Account> accounts=new ArrayList<Account>();
        accounts.add(account);
        accounts.add(account1);
        user.setAccounts(accounts);
        userDao.save(user);

    }
}
