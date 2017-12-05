package tr.com.erhankarakaya.examples.jpa.dal.queryable;

import java.util.List;
import java.util.function.Supplier;

/**
 * Created by erhan.karakaya on 4/4/2017.
 */
public interface Queryable<T>  {
  List<T> toList();
  Queryable<T> where(Supplier<T> supplier);
}
