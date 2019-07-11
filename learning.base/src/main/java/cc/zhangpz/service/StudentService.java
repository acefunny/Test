package cc.zhangpz.service;

import cc.zhangpz.entity.Student;

public interface StudentService {

  Student addOne(Student student);

  Student getOneById(long id);

}
