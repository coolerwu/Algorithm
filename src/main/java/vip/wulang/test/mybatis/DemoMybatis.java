package vip.wulang.test.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class DemoMybatis {
    private static SqlSessionFactory sessionFactory;

    public static void create() {
        final InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis/config/mybatis-config.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(stream);
    }

    public static SqlSessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
