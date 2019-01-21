package com.lswq.db.mybatis;


import com.lswq.db.mybatis.mode.Fruits;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class App {
    public static void main(String[] args) throws IOException {
        String resources = "SqlMapConfig.xml";
        InputStream inpputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inpputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Fruits u = sqlSession.selectOne("test.findUserById", 1);
        System.err.println(u);
        sqlSession.close();

    }
}
