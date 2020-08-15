package com.sunyun;

import com.sunyun.dao.StudentDao;
import com.sunyun.domain.Student;
import com.sunyun.utils.MyBatisutils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Mytest01 {

    @Test
    public void test01select(){
        /**
         * 使用mybtis的动态代理机制，使用Sqlsession.getMapper（dao接口）
         * getMapper能获dao接口对应的实现类对象
         */
        SqlSession sqlSession = MyBatisutils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        System.out.println("dao======="+dao.getClass().getName());//jdk的动态代理
        //调用dao方法
        List<Student> studentList=dao.selectStudents();
        for (Student st:studentList){
            System.out.println(st);
        }
    }
    @Test
    public void test02insert(){
        SqlSession sqlSession = MyBatisutils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student= new Student();
        student.setAge(24);
        student.setEmail("1111@163.com");
        student.setName("小米");
        student.setId(1036);

        int nums=dao.insertStudents(student);
        sqlSession.commit();
        System.out.println(nums);
    }



    }

