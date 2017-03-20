package tr.com.erhankarakaya.examples.jpa.startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import tr.com.erhankarakaya.examples.jpa.bll.dto.ProductDto;
import tr.com.erhankarakaya.examples.jpa.bll.service.ProductService;
import tr.com.erhankarakaya.examples.jpa.util.StringUtil;

import java.util.Random;

/**
 * Created by erhan.karakaya on 3/17/2017.
 */
public class InsertProductRunner implements CommandLineRunner {

  public static final Logger logger = LoggerFactory.getLogger(InsertProductRunner.class);

  @Autowired
  ProductService productService;

  @Override
  public void run(String... args) throws Exception {
    logger.info("----------------------------------------------");
    logger.info("----------------------------------------------");
    logger.info("----------------------------------------------");

    int productQuantity = 100;
    for (int i = 0; i < productQuantity; i++) {
      ProductDto productDto = prepareRandomProductDto();
      try {
        productDto = productService.save(productDto);
      }
      catch (Exception e) {
        logger.error(e.getMessage());
      }
      logger.info("New product is added: " + productDto.toString());
    }

    logger.info("----------------------------------------------");
    logger.info("----------------------------------------------");
    logger.info("----------------------------------------------");

  }


  private ProductDto prepareRandomProductDto() {
    ProductDto productDto = new ProductDto();
    String randomTitle = StringUtil.generateRandomString(15);
    productDto.setTitle(randomTitle);
    Random random = new Random();
    int randomQuantity = random.nextInt(1000);
    productDto.setQuantity(randomQuantity);
    return productDto;
  }
}
