package inner;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Created by erhan.karakaya on 3/28/2017.
 */
public class ProductBuilderTest {


  private static Integer ID = 999;
  private static String TITLE = "TITLE";
  private static String DESCRIPTION = "DESC";
  private static LocalDate EXPIRATIONDATE = LocalDate.of(2020,6,15);
  private static Double PRICE = 49.90;
  private static Integer QUANTITY = 500;

  @Test
  public void shouldNotReturnNull_whenNoFieldIsGiven() {
    Product.ProductBuilder productBuilder = Product.getBuilder();
    Product product = productBuilder.build();

    assertNotNull(product);
  }

  @Test
  public void shouldReturnAllFieldsCorrect() {
    Product.ProductBuilder productBuilder = Product.getBuilder();
    Product product = productBuilder.id(ID)
        .description(DESCRIPTION)
        .expirationDate(EXPIRATIONDATE)
        .price(PRICE)
        .quantity(QUANTITY)
        .title(TITLE)
        .build();

    assertEquals(ID, product.getId());
    assertEquals(TITLE, product.getTitle());
    assertEquals(DESCRIPTION, product.getDescription());
    assertEquals(EXPIRATIONDATE, product.getExpirationDate());
    assertEquals(PRICE, product.getPrice());
    assertEquals(QUANTITY, product.getQuantity());
  }
}