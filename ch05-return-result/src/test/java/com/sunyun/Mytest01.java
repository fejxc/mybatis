package com.sunyun;

import com.sunyun.dao.StudentDao;
import com.sunyun.domain.MyStudent;
import com.sunyun.domain.Student;
import com.sunyun.utils.MyBatisutils;
import com.sunyun.vo.QueryParam;
import com.sunyun.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

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
    public void test02SelectMultiParam(){
        SqlSession sqlSession = MyBatisutils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        List<Student> students=dao.selectMultiParam("孙昀",44);
        System.out.println("=============================");
        for (Student st:students){
            System.out.println("得到的结果"+st);
        }
        System.out.println("=============================");
        sqlSession.close();

    }

    @Test
    public void test03selectViewStudent(){

        SqlSession sqlSession = MyBatisutils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        // System.out.println("dao======="+dao.getClass().getName());//jdk的动态代理
        ViewStudent viewStudent =dao.selectStudentReturnViewStudent(1001);
        System.out.println("10001 student="+viewStudent);
        sqlSession.close();
    }

    @Test
    public void test04selectCountStudent(){

        SqlSession sqlSession = MyBatisutils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        // System.out.println("dao======="+dao.getClass().getName());//jdk的动态代理
       int count =dao.countStudent();
        System.out.println("学生数量----->"+count);
        sqlSession.close();
    }


    @Test
    public void test05selectMap(){

        SqlSession sqlSession = MyBatisutils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        // System.out.println("dao======="+dao.getClass().getName());//jdk的动态代理
        Map<Object,Object> map = dao.selectMapById(1001);
        System.out.println("学生数量----->"+map);
        sqlSession.close();
    }


    @Test
    public void test06SelectAllStudent(){
        SqlSession sqlSession = MyBatisutils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        List<Student> students=dao.selectAllStudent();
        System.out.println("=============================");
        for (Student st:students){
            System.out.println("得到的结果"+st);
        }
        System.out.println("=============================");
        sqlSession.close();

    }

    @Test
    public void test07SelectMylStudent(){
        SqlSession sqlSession = MyBatisutils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        List<MyStudent> students = dao.selectMyStudent();
        System.out.println("=============================");
        for (MyStudent st:students){
            System.out.println("得到的结果"+st);
        }
        System.out.println("=============================");
        sqlSession.close();

    }


    @Test
    public void test08SelectMylStudent2(){
        SqlSession sqlSession = MyBatisutils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        List<MyStudent> students = dao.selectDifferentColProperty();
        System.out.println("=============================");
        for (MyStudent st:students){
            System.out.println("得到的结果"+st);
        }
        System.out.println("=============================");
        sqlSession.close();

    }
    @Test
    public void test09SelectLikeOne(){
        SqlSession sqlSession = MyBatisutils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        String name="%孙%";
        List<Student> students = dao.selectLikeOne(name);
        System.out.println("=============================");
        for (Student st:students){
            System.out.println("得到的结果"+st);
        }
        System.out.println("=============================");
        sqlSession.close();

    }

    @Test
    public void test09SelectLikeTwo(){
        SqlSession sqlSession = MyBatisutils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        String name="孙";
        List<Student> students = dao.selectLikeTwo(name);
        System.out.println("=============================");
        for (Student st:students){
            System.out.println("得到的结果"+st);
        }
        System.out.println("=============================");
        sqlSession.close();

    }

    }

