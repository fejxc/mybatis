package com.sunyun.dao;

import com.sunyun.domain.Student;

import java.util.List;

//一个接口，操作student表
public interface StudentDao {

    //查询student表的所有数据
    public List<Student> selectStudents();

    //插入方法
    //参数student ，插入数据库的数据
    //返回值 int 影响几行
    public int insertStudents(Student student);

}
