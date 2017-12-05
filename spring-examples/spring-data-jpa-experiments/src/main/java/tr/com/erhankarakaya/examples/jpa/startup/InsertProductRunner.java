package tr.com.erhankarakaya.examples.jpa.startup;

import mapper.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;
import tr.com.erhankarakaya.examples.jpa.bll.dto.CategoryDto;
import tr.com.erhankarakaya.examples.jpa.bll.dto.ProductDto;
import tr.com.erhankarakaya.examples.jpa.bll.service.CategoryService;
import tr.com.erhankarakaya.examples.jpa.bll.service.ProductService;
import tr.com.erhankarakaya.examples.jpa.dal.entity.Category;
import tr.com.erhankarakaya.examples.jpa.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by erhan.karakaya on 3/17/2017.
 */
public class InsertProductRunner implements CommandLineRunner {

  public static final Logger logger = LoggerFactory.getLogger(InsertProductRunner.class);

  @Autowired
  ProductService productService;

  @Autowired
  CategoryService categoryService;


  @Override
  public void run(String... args) throws Exception {
    logger.info("----------------------------------------------");
    logger.info("----------------------------------------------");
    logger.info("Started inserting test data.");
    logger.info("----------------------------------------------");
    logger.info("----------------------------------------------");

    int categoryQuantity = 10;
    List<CategoryDto> categories = new ArrayList<>();
    for (int i = 0; i < categoryQuantity; i++) {
      CategoryDto categoryDto = prepareRandomCategoryDto();
      categoryDto = categoryService.save(categoryDto);
      if (categoryDto!=null) {
        logger.info("New category is added: " + categoryDto.toString());
        categories.add(categoryDto);
      }
    }


    int productQuantity = 100;
    for (int i = 0; i < productQuantity; i++) {
      CategoryDto categoryDto = categories.get(i%10);
      Assert.notNull(categoryDto);
      ProductDto productDto = prepareRandomProductDto(categoryDto);
      try {
        productDto = productService.save(productDto);
      }
      catch (Exception e) {
        logger.info(e.getMessage());
        logger.info(productDto.toString());
      }
      logger.info("New product is added: " + productDto.toString());
    }

    logger.info("----------------------------------------------");
    logger.info("----------------------------------------------");
    logger.info("Ended inserting test data.");
    logger.info("----------------------------------------------");
    logger.info("----------------------------------------------");

  }


  private ProductDto prepareRandomProductDto(CategoryDto categoryDto) {
    ProductDto productDto = new ProductDto();
    String randomTitle = StringUtil.generateRandomString(15);
    productDto.setTitle(randomTitle);
    Random random = new Random();
    int randomQuantity = random.nextInt(1000);
    productDto.setQuantity(randomQuantity);
    productDto.setCategoryDto(categoryDto);
    return productDto;

  }

  private CategoryDto prepareRandomCategoryDto() {
    CategoryDto categoryDto = new CategoryDto();
    String randomTitle = StringUtil.generateRandomString(15);
    categoryDto.setTitle(randomTitle);
    return categoryDto;
  }
}
