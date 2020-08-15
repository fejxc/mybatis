package com.sunyun.dao;

import com.sunyun.domain.Student;
import java.util.*;
//一个接口，操作student表
public interface StudentDao {
    //动态sql，使用java对象作为参数
    List<Student> selectStudentIf(Student student);

    //where使用
    List<Student> selectStudentWhere(Student student);

    //foreach用法1
    List<Student> selectForeachOne(List<Integer> idlist);
    //foreach用法2
    List<Student> selectForeachTwo(List<Student> stulist);

    //使用PageHelper分页数据
    List<Student> selectAll();
}
