package com.sunyun.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class MyBatisutils {
    private static SqlSessionFactory factory = null;
    static {
        String config="mybatis.xml";
        try {
            InputStream in =  Resources.getResourceAsStream(config);
            //创建SqlSessionFactory对象
            factory = new SqlSessionFactoryBuilder().build(in);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //获取SqlSession方法
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        if(factory!=null){
            sqlSession=factory.openSession();//非自动提交事务
        }
        return sqlSession;
    }
}