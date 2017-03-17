package tr.com.erhankarakaya.examples.jpa.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by erhan.karakaya on 3/17/2017.
 */
public class StringUtilTest {

  @Test
  public void generateRandomString_withCorrectLength() {
    final int length = 20;
    String randomString = StringUtil.generateRandomString(length);

    assertEquals(length,randomString.length());
  }

}