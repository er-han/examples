package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by erhan.karakaya on 3/27/2017.
 */
@Controller
public class HomeController {

  @GetMapping(value = {"", "/index"})
  public String index() {
    return "index";
  }

  @PostMapping(value = "/index")
  public String post() {
    return "index";
  }
}
