package com.mybatis;

import com.mybatis.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import zheng.javalearn.ApfDto;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @author Zheng
 */
public class Main11Test {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
           List<Student> list =  session.selectList("selectStudent");
           list.forEach(System.out::println);
        }
        System.out.println("1");
        System.out.println("2");
        System.out.println(3);
        System.out.println(4);
    }


@Test

public void test3 (){
    HashMap <ApfDto , String> m1;
    m1 = new HashMap<>();

    ApfDto a1 = new ApfDto() ;
a1.setName("a1");
a1.setAge("10");

    ApfDto a2 = new ApfDto() ;
    a2.setName("a2");
    a2.setAge("11");
    m1.put(a1,"a1");
    m1.put(a2,"a2");
    ApfDto a3 = new ApfDto() ;
    a3.setName("a1");
    a3.setAge("10");
    System.out.println(m1.get(a3));
    System.out.println(m1.containsKey(a3));

}
    @Before
    public void before(){
        System.out.println("Before");
    }
    @Test
    public void test1(){
        System.out.println("Test1");
    }
    @Test
    public void test2(){
        System.out.println("Test2");
    }
    @After
    public void after(){
        System.out.println("After");
    }

}
