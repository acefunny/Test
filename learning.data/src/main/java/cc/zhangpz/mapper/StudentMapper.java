package cc.zhangpz.mapper;

import org.apache.ibatis.annotations.Insert;

import cc.zhangpz.entity.Student;

public interface StudentMapper {

  @Insert("insert into student(name, gender, birthday, idCard) values (#{name}, #{gender}, #{birthday}, #{idCard})")
  int insertOne(Student student);
}
