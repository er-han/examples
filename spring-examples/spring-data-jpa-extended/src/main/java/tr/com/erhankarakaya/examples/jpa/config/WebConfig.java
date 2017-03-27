package tr.com.erhankarakaya.examples.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;
import java.util.Locale;

/**
 * Created by erhan.karakaya on 3/21/2017.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
//    resolver.setOneIndexedParameters(true);
    resolver.setFallbackPageable(new PageRequest(0, 500));
    argumentResolvers.add(resolver);
    super.addArgumentResolvers(argumentResolvers);
  }

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

    super.configureContentNegotiation(configurer);
  }

  @Bean
  public ViewResolver jsonViewResolver() {
    return new ViewResolver() {
      @Override
      public View resolveViewName(String viewName, Locale locale) throws Exception {
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        view.setContentType("application/json");
        return view;
      }
    };
  }
}
