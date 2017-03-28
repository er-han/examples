package seperate;

import java.time.LocalDate;

/**
 * Created by erhan.karakaya on 3/28/2017.
 */
public class ProductBuilder {
  private Integer id;
  private String title;
  private String description;
  private LocalDate expirationDate;
  private Double price;
  private Integer quantity;

  public ProductBuilder setId(Integer id) {
    this.id = id;
    return this;
  }

  public ProductBuilder setTitle(String title) {
    this.title = title;
    return this;
  }

  public ProductBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public ProductBuilder setExpirationDate(LocalDate expirationDate) {
    this.expirationDate = expirationDate;
    return this;
  }

  public ProductBuilder setPrice(Double price) {
    this.price = price;
    return this;
  }

  public ProductBuilder setQuantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  public Product build() {
    Product product = new Product();
    product.setId(id);
    product.setDescription(description);
    product.setExpirationDate(expirationDate);
    product.setPrice(price);
    product.setQuantity(quantity);
    product.setTitle(title);
    return product;
  }
}
