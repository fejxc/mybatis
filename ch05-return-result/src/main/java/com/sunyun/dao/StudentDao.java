package com.sunyun.dao;

import com.sunyun.domain.MyStudent;
import com.sunyun.domain.Student;
import com.sunyun.vo.QueryParam;
import com.sunyun.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//一个接口，操作student表
public interface StudentDao {

    public Student selectStudentById(Integer id);

    List<Student> selectMultiParam(@Param("myname") String name,
                                   @Param("myage") Integer age);

    ViewStudent selectStudentReturnViewStudent(@Param("sid")Integer id);

    int countStudent();

    //定义方法返回Map
    Map<Object,Object> selectMapById(Integer id);

    /**
     * 使用resultMap定义映射关系
     */
    List<Student> selectAllStudent();


    List<MyStudent> selectMyStudent();

    List<MyStudent> selectDifferentColProperty();

    /**
     * 第一种模糊查询，在java代码指定，like的内容  简单方便  推荐使用
     */
    List<Student> selectLikeOne(String name);

    /**
     * 第二种模糊查询， 在mapper文件中
     * name就是李值，在mapper中平接 like "%" 李 "%"
     */
    List<Student> selectLikeTwo(String name);
}
