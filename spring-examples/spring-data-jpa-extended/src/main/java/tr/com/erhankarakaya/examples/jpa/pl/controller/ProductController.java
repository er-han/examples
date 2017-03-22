package tr.com.erhankarakaya.examples.jpa.pl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tr.com.erhankarakaya.examples.jpa.bll.dto.ProductDto;
import tr.com.erhankarakaya.examples.jpa.bll.service.ProductService;

import java.util.List;

/**
 * Created by erhan.karakaya on 3/20/2017.
 */
@Controller
public class ProductController {

  @Autowired
  ProductService productService;

  @RequestMapping("/getproducts")
  public String findAll(Pageable pageable, Model model) {

    Page<ProductDto> productDtos = productService.findAll(pageable);

    model.addAttribute("products", productDtos);

    return "products";
  }

}
