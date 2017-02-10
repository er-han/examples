package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by erhan.karakaya on 10.02.2017.
 */
@RestController
public class HomeController {
  @RequestMapping("/")
  public String home(){
    return "Hello World!";
  }
}
