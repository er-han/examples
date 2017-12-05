package tr.com.erhankarakaya.examples.jpa.bll.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tr.com.erhankarakaya.examples.jpa.bll.dto.ProductDto;
import tr.com.erhankarakaya.examples.jpa.dal.entity.Product;
import tr.com.erhankarakaya.examples.jpa.dal.repository.ProductRepository;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by erhan.karakaya on 3/17/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductServiceTest {

  @Mock
  ProductRepository productRepository;

  @InjectMocks
  ProductService productService = new ProductServiceImpl();

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  private static final Integer ID = 1;
  private static final String TITLE = "PRODUCT1";
  private static final Integer QUANTITY = 50;

  @Test
  public void saveReturnsProductId() {
    Product product = new Product();
    product.setId(ID);
    product.setQuantity(QUANTITY);
    product.setTitle(TITLE);
    when(productRepository.save(any(Product.class))).thenReturn(product);

    ProductDto productDto = new ProductDto();
    productDto.setQuantity(QUANTITY);
    productDto.setTitle(TITLE);


    productDto = productService.save(productDto);

    assertNotNull(productDto);
    assertEquals(ID, productDto.getId());
  }


}