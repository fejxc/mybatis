package com.sunyun;

import com.github.pagehelper.PageHelper;

import com.sunyun.dao.StudentDao;
import com.sunyun.domain.Student;
import com.sunyun.utils.MyBatisutils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Mytest01 {

    @Test
    public void test01selectStudentIf(){

        SqlSession sqlSession = MyBatisutils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
       // System.out.println("dao======="+dao.getClass().getName());//jdk的动态代
        Student student = new Student();
       student.setName("孙昀");
       student.setAge(37);
       List<Student> students=dao.selectStudentIf(student);
       for (Student st:students){
           System.out.println(st);
       }
        sqlSession.close();
    }


    @Test
    public void test01selectStudentWhere(){

        SqlSession sqlSession = MyBatisutils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        // System.out.println("dao======="+dao.getClass().getName());//jdk的动态代
        Student student = new Student();
        //student.setName("孙昀");
        //student.setAge(37);
        List<Student> students=dao.selectStudentWhere(student);
        for (Student st:students){
            System.out.println(st);
        }
        sqlSession.close();
    }
    //commond+d快速复制
    @Test
    public void testfor(){
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);

        //String sql="select * from student where id in (1001,1002,1003)";
        String sql = "select * from student where id in";

      StringBuilder builder = new StringBuilder();
        int init=0;
        int len=list.size();
        //添加开始小括号
        builder.append("(");
        for(Integer i:list){
            builder.append(i).append(",");
        }
        //结尾
        builder.deleteCharAt(builder.length()-1);
        builder.append(")");
        sql = sql + builder.toString();
        System.out.println("sql===="+sql);
    }



    @Test
    public void test01selectStudentForEachOne(){

        SqlSession sqlSession = MyBatisutils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        // System.out.println("dao======="+dao.getClass().getName());//jdk的动态代
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);

        List<Student> studentList=dao.selectForeachOne(list);
        for(Student st:studentList){
            System.out.println(st);
        }
        sqlSession.close();
    }

    @Test
    public void test01selectStudentForEachTwo(){

        SqlSession sqlSession = MyBatisutils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        // System.out.println("dao======="+dao.getClass().getName());//jdk的动态代
        List<Student> stulist = new ArrayList<>();
        Student student = new Student();
        student.setId(1001);

        stulist.add(student);

        student = new Student();
        student.setId(1005);

        stulist.add(student);

        List<Student> studentList=dao.selectForeachTwo(stulist);
        for(Student st:studentList){
            System.out.println(st);
        }
        sqlSession.close();
    }



    @Test
    public void test01selectPageHelp(){

        SqlSession sqlSession = MyBatisutils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        /**
         * 加入分页PageHelp
         * pageNum：第几页，从1开始
         * pageSize：一页中有多少数据
         */
        PageHelper.startPage(1,5);
        List<Student> studentList=dao.selectAll();
        for(Student st:studentList){
            System.out.println(st);
        }
        sqlSession.close();
    }


    }

