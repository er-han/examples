package tr.com.erhankarakaya.examples.jpa.bll.service;

import tr.com.erhankarakaya.examples.jpa.bll.dto.CategoryDto;

/**
 * Created by erhan.karakaya on 4/19/2017.
 */
public interface CategoryService {
  CategoryDto save(CategoryDto categoryDto);
}
