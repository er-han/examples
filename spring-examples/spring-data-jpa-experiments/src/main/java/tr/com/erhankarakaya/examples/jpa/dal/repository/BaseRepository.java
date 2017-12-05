package tr.com.erhankarakaya.examples.jpa.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.jdbc.core.JdbcTemplate;
import tr.com.erhankarakaya.examples.jpa.dal.queryable.Queryable;

import java.io.Serializable;

/**
 * Created by erhan.karakaya on 4/4/2017.
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
  Queryable<T> getQueryable(Class<T> type, JdbcTemplate jdbcTemplate);
}
