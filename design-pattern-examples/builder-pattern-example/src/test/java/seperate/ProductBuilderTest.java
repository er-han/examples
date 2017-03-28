package seperate;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Calendar;

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
    ProductBuilder productBuilder = new ProductBuilder();
    Product product = productBuilder.build();

    assertNotNull(product);
  }

  @Test
  public void shouldReturnAllFieldsCorrect() {
    ProductBuilder productBuilder = new ProductBuilder();
    Product product = productBuilder.setId(ID)
        .setDescription(DESCRIPTION)
        .setExpirationDate(EXPIRATIONDATE)
        .setPrice(PRICE)
        .setQuantity(QUANTITY)
        .setTitle(TITLE)
        .build();

    assertEquals(ID, product.getId());
    assertEquals(TITLE, product.getTitle());
    assertEquals(DESCRIPTION, product.getDescription());
    assertEquals(EXPIRATIONDATE, product.getExpirationDate());
    assertEquals(PRICE, product.getPrice());
    assertEquals(QUANTITY, product.getQuantity());
  }
}