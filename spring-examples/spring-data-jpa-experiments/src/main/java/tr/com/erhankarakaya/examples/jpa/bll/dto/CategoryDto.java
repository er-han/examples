package tr.com.erhankarakaya.examples.jpa.bll.dto;

import mapper.Mappable;

/**
 * Created by erhan.karakaya on 4/18/2017.
 */
public class CategoryDto implements Mappable{
  private Integer id;
  private String title;

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

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[Id: " + getId() + ", Title: " + getTitle() + "]");
    return stringBuilder.toString();
  }
}
