package com.sunyun;

import com.sunyun.dao.StudentDao;
import com.sunyun.dao.imlp.StudentDaoImpl;
import com.sunyun.domain.Student;
import org.junit.Test;

import java.util.List;

public class Mytest01 {

    @Test
    public void test01select(){
        StudentDao dao = new StudentDaoImpl();
        List<Student> studentList = dao.selectStudents();
        for(Student st:studentList){
            System.out.println(st);
        }
    }
    @Test
    public void test02insert(){
        StudentDao dao = new StudentDaoImpl();
        Student student= new Student();
        student.setAge(22);
        student.setEmail("11121@163.com");
        student.setName("苹果");
        student.setId(1035);
        int nums = dao.insertStudents(student);
        System.out.println(nums);
    }



    }

