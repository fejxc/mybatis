package com.sunyun.dao;

import com.sunyun.domain.Student;
import com.sunyun.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//一个接口，操作student表
public interface StudentDao {
    /**
     * 一个简单类型的参数
     *  简单类型：mybatis把java的基本数据类型和字符串String都叫简单类型
     *  Intager一个简单的数据类型
     *
     * @param id
     * @return
     */
    public Student selectStudentById(Integer id);

    /**
     * 多个参数：命名参数，在形参定义前面加@Param("自定义名称")
     */
    List<Student> selectMulitParam(@Param("myname") String name,
                                   @Param("myage") Integer age);

    /**
     * 多个参数，使用java对象作为接口中的方法的参数
     *
     */
    List<Student> selectMulitObject(QueryParam param);

    List<Student> selectMultiStudent(@Param("myname") String name,
                                     @Param("myage") Integer age);


    List<Student> selectMultiStudent(Student student);
}
