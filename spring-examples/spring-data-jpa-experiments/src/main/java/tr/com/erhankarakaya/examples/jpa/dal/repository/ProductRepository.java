package tr.com.erhankarakaya.examples.jpa.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.erhankarakaya.examples.jpa.dal.entity.Product;

@Repository
public interface ProductRepository extends BaseRepository<Product, Integer> {
}
