package com.mybatis;

import com.mybatis.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Zheng
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
           List<Student> list =  session.selectList("selectStudent");
           list.forEach(System.out::println);
        }

    }
    @Before
    public void Before(){
        System.out.println("Before");
    }
    @Test
    public void Test1(){
        System.out.println("Test1");
    }
    @Test
    public void Test2(){
        System.out.println("Test2");
    }
    @After
    public void After(){
        System.out.println("After");
    }

}
