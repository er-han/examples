package tr.com.erhankarakaya.examples.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tr.com.erhankarakaya.examples.jpa.dal.repository.BaseRepositoryImpl;
import tr.com.erhankarakaya.examples.jpa.startup.InsertProductRunner;

/**
 * Created by erhan.karakaya on 3/16/2017.
 */
@SpringBootApplication
@EnableJpaRepositories( repositoryBaseClass = BaseRepositoryImpl.class)
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public InsertProductRunner insertProduct() {
    return new InsertProductRunner();
  }
}
