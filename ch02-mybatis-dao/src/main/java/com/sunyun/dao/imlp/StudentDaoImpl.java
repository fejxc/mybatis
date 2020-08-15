package com.sunyun.dao.imlp;

import com.sunyun.dao.StudentDao;
import com.sunyun.domain.Student;
import com.sunyun.utils.MyBatisutils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public int insertStudents(Student student) {
        //获取Sqlsession对象
        SqlSession sqlSession = MyBatisutils.getSqlSession();
        String sqlId="com.sunyun.dao.StudentDao.insertStudents";
        int nums = sqlSession.insert(sqlId,student);//有两个参数
        sqlSession.commit();
        sqlSession.close();
        return nums;
    }

    @Override
    public List<Student> selectStudents() {
        //获取Sqlsession对象
        SqlSession sqlSession = MyBatisutils.getSqlSession();
        String sqlId="com.sunyun.dao.StudentDao.selectStudents";
        //执行sql
       List<Student> students= sqlSession.selectList(sqlId);
//       for(Student st:students){
//           System.out.println(st);
//       }
       sqlSession.close();
       return students;
    }
}
