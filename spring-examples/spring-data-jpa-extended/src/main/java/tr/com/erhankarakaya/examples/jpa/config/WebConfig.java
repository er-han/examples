package tr.com.erhankarakaya.examples.jpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by erhan.karakaya on 3/21/2017.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
    resolver.setOneIndexedParameters(true);
    resolver.setFallbackPageable(new PageRequest(1, 50));
    argumentResolvers.add(resolver);
    super.addArgumentResolvers(argumentResolvers);
  }

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

    super.configureContentNegotiation(configurer);
  }
}
