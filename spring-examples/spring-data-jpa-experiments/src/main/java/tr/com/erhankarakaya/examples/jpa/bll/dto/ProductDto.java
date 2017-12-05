package tr.com.erhankarakaya.examples.jpa.bll.dto;

import mapper.Mappable;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * Created by erhan.karakaya on 3/17/2017.
 */
public class ProductDto implements Mappable {
  private Integer id;
  @NotEmpty
  @Size(min = 2, max = 5)
  private String title;
  @Min(1)
  @Max(500)
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

  private CategoryDto categoryDto;

  public CategoryDto getCategoryDto() {
    return categoryDto;
  }

  public void setCategoryDto(CategoryDto categoryDto) {
    this.categoryDto = categoryDto;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[Id: " + getId() + ", Title: " + getTitle() + ", Quantity: ]");
    return stringBuilder.toString();
  }
}
