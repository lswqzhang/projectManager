package com.lswq.db.mybatis;


import com.lswq.db.mybatis.mapper.UserMapper;
import com.lswq.db.mybatis.mode.Fruits;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class App {

    public void userInterfaceQuery() {
        String resources = "SqlMapConfigInterface.xml";
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Fruits u = mapper.findUserById(1);
        System.err.println(u);
        sqlSession.close();
    }

    public void userMyBatisSelect() {
        String resources = "SqlMapConfigMapperFile.xml";
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Fruits u = sqlSession.selectOne("com.lswq.db.mybatis.mapper.UserMapper.findUserById", 1);
        System.err.println(u);
        sqlSession.close();
    }
}
