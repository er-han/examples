package tr.com.erhankarakaya.examples.jpa.dal.repository;

import org.springframework.stereotype.Repository;
import tr.com.erhankarakaya.examples.jpa.dal.entity.Category;

/**
 * Created by erhan.karakaya on 4/18/2017.
 */
@Repository
public interface CategoryRepository extends BaseRepository<Category,Integer>{
}
