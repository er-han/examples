package tr.com.erhankarakaya.examples.jpa.dal.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by erhan.karakaya on 4/17/2017.
 */
@Entity
@Table(name = "CATEGORY")
public class Category extends BaseEntity{
  @Id
  @SequenceGenerator(name="SEQ_GEN", sequenceName="SEQ_Category_Id", allocationSize=1)
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
  @Column(name = "ID", columnDefinition = "NUMBER")
  private Integer id;

  @Column(name = "TITLE", columnDefinition = "NVARCHAR2(250)")
  private String title;

  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
  private List<Product> products;

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

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


}
