package tr.com.erhankarakaya.examples.jpa.bll.service;

import mapper.Mapper;
import mapper.exception.ResultTypeInstantiationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.erhankarakaya.examples.jpa.bll.dto.CategoryDto;
import tr.com.erhankarakaya.examples.jpa.dal.entity.Category;
import tr.com.erhankarakaya.examples.jpa.dal.repository.CategoryRepository;

/**
 * Created by erhan.karakaya on 4/19/2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

  private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);
  @Autowired
  CategoryRepository categoryRepository;

  @Override
  public CategoryDto save(CategoryDto categoryDto) {
    try {
      Category category = Mapper.getMapperFrom(categoryDto).mapTo(Category.class);
      category = categoryRepository.save(category);
      LOGGER.info("Saved category id: " + category.getId());

      categoryDto = category.mapTo(CategoryDto.class);
      LOGGER.info("Saved categoryDto id: " + categoryDto.getId());
      return categoryDto;
    } catch (ResultTypeInstantiationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
