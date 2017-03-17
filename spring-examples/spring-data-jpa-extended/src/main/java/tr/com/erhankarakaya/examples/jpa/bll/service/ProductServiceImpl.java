package tr.com.erhankarakaya.examples.jpa.bll.service;

import mapper.exception.ResultTypeInstantiationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tr.com.erhankarakaya.examples.jpa.bll.dto.ProductDto;
import tr.com.erhankarakaya.examples.jpa.dal.entity.Product;
import tr.com.erhankarakaya.examples.jpa.dal.repository.ProductRepository;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  ProductRepository productRepository;

  @Override
  public ProductDto save(ProductDto productDto) {
    Assert.notNull(productDto);
    try {
      Product product = productDto.mapTo(Product.class);
      product = productRepository.save(product);
      return product.mapTo(ProductDto.class);
    } catch (ResultTypeInstantiationException e) {
      return null;
    }
  }

  @Override
  public List<ProductDto> findAll() {
    return null;
  }

  @Override
  public List<ProductDto> findAll(Pageable pageable) {
    return null;
  }
}
