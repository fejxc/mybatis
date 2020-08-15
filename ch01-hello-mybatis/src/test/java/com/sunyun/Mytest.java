package com.sunyun;

import com.sunyun.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class Mytest {
    @Test
    public void test01_select() throws IOException {
        //访问mybtis读取student数据
        //1、定义mybatis主配置文件，从类路径根开始 target/classes
        String config="mybatis.xml";
        //2、读取config文件
       InputStream in = Resources.getResourceAsStream(config);
       //3、创建sqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4、创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        //5、【重要】获取sqlSession对象，从SqlSessionFactory获取
        SqlSession sqlSession = factory.openSession();
        //sql映射文件的namespace + "." + 标签的id值
        String sqlId ="com.sunyun.dao.StudentDao"+"."+"selectStudents";
        //7、执行sql语句，通过sqlId执行
        List<Student> studentList=sqlSession.selectList(sqlId);
        //8、结果
        for(Student st:studentList){
            System.out.println("student="+st);
        }
        //9、关闭sqlSession对象
        sqlSession.close();

    }
    @Test
    public void test02_insert() throws IOException {
        //访问mybtis读取student数据
        //1、定义mybatis主配置文件，从类路径根开始 target/classes
        String config="mybatis.xml";
        //2、读取config文件
        InputStream in = Resources.getResourceAsStream(config);
        //3、创建sqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4、创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        //5、【重要】获取sqlSession对象，从SqlSessionFactory获取
        //SqlSession sqlSession = factory.openSession();
        SqlSession sqlSession = factory.openSession(true);
        //sql映射文件的namespace + "." + 标签的id值
        String sqlId ="com.sunyun.dao.StudentDao"+"."+"insertStudents";
        //7、执行sql语句，通过sqlId执行
        Student student = new Student();
        student.setId(1033);
        student.setName("王夫人");
        student.setEmail("wfr@163.com");
        student.setAge(34);
       int nums=sqlSession.insert(sqlId,student);
       //mybatis不是默认提交事务的，在insert，update，delete后要手动提交事务
      //  sqlSession.commit();
        //8、结果
        System.out.println("影响行数"+nums);
        //9、关闭sqlSession对象
        sqlSession.close();


    }
}
