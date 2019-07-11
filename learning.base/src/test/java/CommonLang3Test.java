import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

public class CommonLang3Test {

  @Test
  public void lang() {
    System.out.println(RandomStringUtils.random(5, "abcdefghijklmn"));
  }
}
