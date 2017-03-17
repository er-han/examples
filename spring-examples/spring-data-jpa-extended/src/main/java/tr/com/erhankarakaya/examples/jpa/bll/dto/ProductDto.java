package tr.com.erhankarakaya.examples.jpa.bll.dto;

/**
 * Created by erhan.karakaya on 3/17/2017.
 */
public class ProductDto {
  private Integer id;
  private String title;
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

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
