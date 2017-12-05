package tr.com.erhankarakaya.examples.jpa.dal.queryable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import javax.persistence.Table;
import javax.sql.DataSource;
import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;

/**
 * Created by erhan.karakaya on 4/4/2017.
 */
public class QueryableImpl<T> implements Queryable<T> {



  private static final Logger LOGGER = LoggerFactory.getLogger(QueryableImpl.class);

  private String query;

  private Class<T> type;

  private String tableName;

  private JdbcTemplate jdbcTemplate;


  public QueryableImpl(Class<T> type, JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    this.type = type;
    query = String.format("SELECT * FROM %s", getTableName());
  }

  @Override
  public List<T> toList() {
    List<T> list = jdbcTemplate.query(query,
        new BeanPropertyRowMapper(type));
    return list;
  }

  @Override
  public Queryable<T> where(Supplier<T> supplier) {
    return null;
  }


  private String getTableName() {
    if (tableName == null) {
      Table tableAnotation = type.getAnnotation(Table.class);
      if (tableAnotation == null) {
        tableName = type.getName().toUpperCase(Locale.ENGLISH);
      } else {
        tableName = tableAnotation.name().toUpperCase(Locale.ENGLISH);
      }
    }
    return tableName;
  }
}
