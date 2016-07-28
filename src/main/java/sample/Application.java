package sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import sample.custom.MyRepositoryFactoryBean;

@SpringBootApplication
@EntityScan(basePackages = "sample.domain")
@EnableJpaRepositories(repositoryFactoryBeanClass = MyRepositoryFactoryBean.class)
public class Application {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
    }
}
