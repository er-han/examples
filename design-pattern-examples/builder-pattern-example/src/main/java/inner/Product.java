package inner;

import java.time.LocalDate;

/**
 * Created by erhan.karakaya on 3/28/2017.
 */
public class Product {
  private Integer id;
  private String title;
  private String description;
  private LocalDate expirationDate;
  private Double price;
  private Integer quantity;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(LocalDate expirationDate) {
    this.expirationDate = expirationDate;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public static ProductBuilder getBuilder() {
    return new ProductBuilder();
  }

  public static class ProductBuilder {
    private Product product;

    public ProductBuilder() {
      product = new Product();
    }

    public ProductBuilder id(Integer id) {
      product.setId(id);
      return this;
    }

    public ProductBuilder title(String title) {
      product.setTitle(title);
      return this;
    }

    public ProductBuilder description(String description) {
      product.setDescription(description);
      return this;
    }

    public ProductBuilder expirationDate(LocalDate expirationDate) {
      product.setExpirationDate(expirationDate);
      return this;
    }

    public ProductBuilder price(Double price) {
      product.setPrice(price);
      return this;
    }

    public ProductBuilder quantity(Integer quantity) {
      product.setQuantity(quantity);
      return this;
    }

    public Product build() {
      return product;
    }
  }
}
