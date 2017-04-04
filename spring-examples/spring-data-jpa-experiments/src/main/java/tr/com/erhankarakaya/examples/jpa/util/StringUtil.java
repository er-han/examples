package tr.com.erhankarakaya.examples.jpa.util;

import java.util.Random;

/**
 * Created by erhan.karakaya on 3/17/2017.
 */
public class StringUtil {
  public static String generateRandomString(int length) {
    char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    StringBuilder sb = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < length; i++) {
      char c = chars[random.nextInt(chars.length)];
      sb.append(c);
    }
    String output = sb.toString();
    return output;
  }
}
