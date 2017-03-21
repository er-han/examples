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
  public Page<ProductDto> findAll(Integer page, Integer pageSize) {

    Page<ProductDto> productDtos;
    if (page != null && page >= 0 && pageSize != null && pageSize > 0) {
      Pageable pageRequest = new PageRequest(page, pageSize);
      productDtos = productService.findAll(pageRequest);
    } else {
      List<ProductDto> _productDtos = productService.findAll();
      productDtos = new PageImpl<ProductDto>(_productDtos);
    }

    return productDtos;
  }


}
