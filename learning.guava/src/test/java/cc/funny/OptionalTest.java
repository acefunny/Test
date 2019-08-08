package cc.funny;

import com.google.common.base.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

import javax.validation.constraints.AssertTrue;

import cc.zhangpz.entity.Student;
import lombok.extern.slf4j.Slf4j;

import static junit.framework.TestCase.assertTrue;

@Slf4j
@RunWith(SpringRunner.class)
public class OptionalTest {

  private CountDownLatch cdl;

  @Test
  public void op(){

    Student student = Student.builder().id(1).idCard("").name("WuHa").build();


    Optional possible  = Optional.fromNullable(student);
    log.info("{}", possible.get());
    assertTrue(null != possible.get());
  }
}
