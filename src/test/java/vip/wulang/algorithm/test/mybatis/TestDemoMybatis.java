package vip.wulang.algorithm.test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import vip.wulang.test.mybatis.DemoMybatis;
import vip.wulang.test.mybatis.mapper.StudentMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class TestDemoMybatis {
    @Before
    public void init() {
        DemoMybatis.create();
    }

    @Test
    public void select() {
        final SqlSessionFactory sessionFactory = DemoMybatis.getSessionFactory();
        try (final SqlSession sqlSession = sessionFactory.openSession()) {
            final StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            LocalDate now = LocalDate.now();
            LocalDate end = now.minusMonths(3);
            System.out.println(now);
            System.out.println(end);
            final List<Map<String, Object>> map = studentMapper.findTime(end, now);
            System.out.println(map);
        }

        try (final SqlSession sqlSession = sessionFactory.openSession()) {
            final StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            LocalDate now = LocalDate.now();
            LocalDate end = now.minusMonths(3);
            System.out.println(now);
            System.out.println(end);
            final List<Map<String, Object>> map = studentMapper.findTime(end, now);
            System.out.println(map);
        }
    }

    @Test
    public void insert() {
        final SqlSessionFactory sessionFactory = DemoMybatis.getSessionFactory();
        try (final SqlSession sqlSession = sessionFactory.openSession()) {
            final StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.insert("tianwanggaidihu3", "1111213");
            sqlSession.commit();
        }
    }
}
