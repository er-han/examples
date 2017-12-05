package tr.com.erhankarakaya.examples.jpa.dal.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;
import tr.com.erhankarakaya.examples.jpa.dal.queryable.Queryable;
import tr.com.erhankarakaya.examples.jpa.dal.queryable.QueryableImpl;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.io.Serializable;

/**
 * Created by erhan.karakaya on 4/4/2017.
 */
@NoRepositoryBean
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

  private static final Logger logger = LoggerFactory.getLogger(BaseRepositoryImpl.class);

  private final EntityManager entityManager;

  private JdbcTemplate jdbcTemplate;

  public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
    super(entityInformation, entityManager);

    this.entityManager = entityManager;
  }

  public Queryable<T> getQueryable(Class<T> type, JdbcTemplate jdbcTemplate) {
    T t = null; 
    this.jdbcTemplate = jdbcTemplate;
    Assert.notNull(jdbcTemplate,"6626");
    return new QueryableImpl<T>(type, jdbcTemplate);
  }
}
