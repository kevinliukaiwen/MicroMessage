package com.cims.dbacess;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * Created by kevin on 2017/12/29.
 */
public class DBAcess {
    public SqlSession getSqlSession() throws IOException {
        //读取配置文件，转换成为输入流
        Reader reader = Resources.getResourceAsReader("Configuration.xml");
        //得到sqlsession的工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //通过工厂得到sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
