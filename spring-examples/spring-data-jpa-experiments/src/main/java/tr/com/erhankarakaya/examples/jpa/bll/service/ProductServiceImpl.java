package tr.com.erhankarakaya.examples.jpa.bll.service;

import mapper.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tr.com.erhankarakaya.examples.jpa.bll.dto.ProductDto;
import tr.com.erhankarakaya.examples.jpa.dal.entity.Category;
import tr.com.erhankarakaya.examples.jpa.dal.entity.Product;
import tr.com.erhankarakaya.examples.jpa.dal.queryable.Queryable;
import tr.com.erhankarakaya.examples.jpa.dal.repository.CategoryRepository;
import tr.com.erhankarakaya.examples.jpa.dal.repository.ProductRepository;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

  private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

  @Autowired
  ProductRepository productRepository;

  @Autowired
  CategoryRepository categoryRepository;


  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public ProductDto save(ProductDto productDto) {
    Assert.notNull(productDto);
    try {
      Product product = Mapper.getMapperFrom(productDto).mapTo(Product::new);
      Category category = categoryRepository.findOne(productDto.getCategoryDto().getId());
      Assert.notNull(category);
      product.setCategory(category);
      product = productRepository.save(product);
      return product.mapTo(ProductDto.class);
    } catch (Exception e) {
      logger.info("Error in saving Product: " + e.getMessage());
      return null;
    }
  }

  @Override

  public List<ProductDto> findAll() {
    List<Product> products = productRepository.findAll();
    List<ProductDto> productDtos = (List<ProductDto>) Mapper.getMapperFromList(products).mapToList(ProductDto::new);
    return productDtos;
  }

  @Override
  public Page<ProductDto> findAll(Pageable pageable) {
    Page<Product> products = productRepository.findAll(pageable);

    Iterable<ProductDto> productDtos = Mapper.getMapperFromList(products).mapToList(ProductDto::new);

    return new PageImpl<ProductDto>((List<ProductDto>) productDtos,pageable,products.getTotalElements());
  }

  @Override
  public List<ProductDto> getAll() {
    Queryable<Product> queryable = productRepository.getQueryable(Product.class, jdbcTemplate);
    List<Product> products = queryable.toList();
    products.stream()
    List<ProductDto> productDtos = (List<ProductDto>) Mapper.getMapperFromList(products).mapToList(ProductDto::new);
    return productDtos;
  }
}
