import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import cc.zhangpz.entity.Student;

public class ListTest {


  List<Student> currentList = Lists.newArrayList();
  List<Student> requestList = Lists.newArrayList();

  @Before
  public void before() {
    for (int i = 0; i < 3; i++) {
      currentList.add(Student.builder().name("zhang-" + i).idCard("aaaa-" + i).gender(1).build());
      requestList.add(Student.builder().name("zhang-" + i).idCard("bbbb-" + i).build());
      requestList.add(Student.builder().name("wang-" + i).idCard("bbbb-" + i).build());
    }
  }

  @Test
  public void merge() {
    List<Student> list = Stream.concat(currentList.stream(), requestList.stream())
        .collect(Collectors.toMap(Student::getName, Function.identity(), (oldData, newData) -> oldData))
        .entrySet()
        .stream()
        .map(x -> Student.builder().name(x.getValue().getName()).idCard(x.getValue().getIdCard()).build())
        .collect(Collectors.toList());
  }

  @Test
  public void mergeOneSide() {
    Map<String,String> filter = requestList.stream().collect(Collectors.toMap(Student::getName, Student::getIdCard));

    currentList.stream()
        .map(x -> {
          if(filter.containsKey(x.getName()))
          {
            x.setIdCard(filter.get(x.getName()));
          }
          return x;
        })
        .collect(Collectors.toList()).forEach(System.out::println);



  }

  @Test
  public void now(){
    String s = "covered";
    String t = "combine,new_and_new";

     Splitter.on(",").trimResults().omitEmptyStrings().split(t);
  }


}
