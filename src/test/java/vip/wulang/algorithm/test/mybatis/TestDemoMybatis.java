package vip.wulang.algorithm.test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import vip.wulang.test.mybatis.DemoMybatis;
import vip.wulang.test.mybatis.mapper.UserMapper;

import java.util.Map;

public class TestDemoMybatis {
    @Before
    public void init() {
        DemoMybatis.create();
    }

    @Test
    public void create() {
        final SqlSessionFactory sessionFactory = DemoMybatis.getSessionFactory();
        try (final SqlSession sqlSession = sessionFactory.openSession()) {
            final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            final Map<String, Object> map = userMapper.findById(1L);
            System.out.println(map);
        }
    }
}
