package com.sunyun;

import com.sunyun.dao.StudentDao;
import com.sunyun.domain.Student;
import com.sunyun.utils.MyBatisutils;
import com.sunyun.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Mytest01 {

    @Test
    public void test01selectById(){

        SqlSession sqlSession = MyBatisutils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
       // System.out.println("dao======="+dao.getClass().getName());//jdk的动态代理
        Student student=dao.selectStudentById(1008);
        System.out.println("student="+student);
        sqlSession.close();
    }

    @Test
    public void test02SelectMulitParam(){
        SqlSession sqlSession = MyBatisutils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        List<Student> students=dao.selectMulitParam("孙昀",44);
        System.out.println("=============================");
        for (Student st:students){
            System.out.println("得到的结果"+st);
        }
        System.out.println("=============================");
        sqlSession.close();

    }

    @Test
    public void test03SelectMulitObject(){
        SqlSession sqlSession = MyBatisutils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        QueryParam queryParam = new QueryParam();
        queryParam.setParamAge(22);
        queryParam.setParamName("孙昀");
        List<Student> students=dao.selectMulitObject(queryParam);
        System.out.println("=============================");
        for (Student st:students){
            System.out.println("得到的结果"+st);
        }
        System.out.println("=============================");
        sqlSession.close();
    }
    @Test
    public void test03SelectMulitStudent(){
        SqlSession sqlSession = MyBatisutils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setAge(22);
        student.setName("孙昀");
        List<Student> students=dao.selectMultiStudent(student);
        System.out.println("=============================");
        for (Student st:students){
            System.out.println("得到的结果"+st);
        }
        System.out.println("=============================");
        sqlSession.close();
    }




    }

