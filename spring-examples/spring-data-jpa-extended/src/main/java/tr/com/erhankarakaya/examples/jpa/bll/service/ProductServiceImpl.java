package tr.com.erhankarakaya.examples.jpa.bll.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tr.com.erhankarakaya.examples.jpa.bll.dto.ProductDto;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
  @Override
  public ProductDto save(ProductDto productDto) {
    return null;
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
