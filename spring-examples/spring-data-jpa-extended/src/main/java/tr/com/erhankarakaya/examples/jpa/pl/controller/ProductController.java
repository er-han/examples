package tr.com.erhankarakaya.examples.jpa.pl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
@RestController
public class ProductController {

  @Autowired
  ProductService productService;

  @RequestMapping("/getproducts")
  public Page<ProductDto> findAll(Pageable pageable) {

    Page<ProductDto> productDtos = productService.findAll(pageable);

    return productDtos;
  }


}
