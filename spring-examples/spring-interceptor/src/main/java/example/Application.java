package example;

import example.interceptor.AppInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by erhan.karakaya on 3/27/2017.
 */
@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    AppInterceptor appInterceptor = new AppInterceptor();
    registry.addInterceptor(appInterceptor);
    super.addInterceptors(registry);
  }
}
