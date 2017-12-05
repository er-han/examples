package tr.com.erhankarakaya.examples.jpa.bll.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tr.com.erhankarakaya.examples.jpa.bll.dto.ProductDto;

import java.util.List;

public interface ProductService {

  ProductDto save(ProductDto productDto);

  List<ProductDto> findAll();
  Page<ProductDto> findAll(Pageable pageable);

  List<ProductDto> getAll();
}
