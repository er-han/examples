package tr.com.erhankarakaya.examples.jpa.dal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {
  @Column(name = "ID", columnDefinition = "NUMBER")
  private Integer id;

  @Column(name = "TITLE", columnDefinition = "NVARCHAR2(250)")
  private String title;

  @Column(name = "QUANTITY", columnDefinition = "NUMBER")
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
