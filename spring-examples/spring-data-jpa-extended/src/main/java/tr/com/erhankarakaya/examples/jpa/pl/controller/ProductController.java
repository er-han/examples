package tr.com.erhankarakaya.examples.jpa.pl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tr.com.erhankarakaya.examples.jpa.bll.dto.BindingResultDto;
import tr.com.erhankarakaya.examples.jpa.bll.dto.ProductDto;
import tr.com.erhankarakaya.examples.jpa.bll.service.ProductService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by erhan.karakaya on 3/20/2017.
 */
@Controller
public class ProductController {

  @Autowired
  ProductService productService;

  @RequestMapping("/products")
  public String findAll(Pageable pageable, Model model) {

    Page<ProductDto> productDtos = productService.findAll(pageable);

    model.addAttribute("products", productDtos);

    return "products";
  }


  @RequestMapping(value = "/save", method = RequestMethod.GET)
  public String saveGet(Model model) {

      model.addAttribute("product", new ProductDto());
      return "save";
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String save(@Valid ProductDto productDto, BindingResult bindingResult, Model model) {

    if (bindingResult.hasErrors()) {
      BindingResultDto bindingResultDto = new BindingResultDto();
      bindingResultDto.setAllErros(bindingResult.getAllErrors());
      model.addAttribute("errors", bindingResultDto);
      model.addAttribute("error", bindingResult);
      return "save";
    }
    productDto = productService.save(productDto);

    return "redirect:/products?" + bindingResult.hasErrors();
  }

}
