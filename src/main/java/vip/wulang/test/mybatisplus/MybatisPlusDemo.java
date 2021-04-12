package vip.wulang.test.mybatisplus;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.InputStream;

/**
 * @author CoolerWu
 * @version 1.0
 */
public class MybatisPlusDemo {
    public static void main(String[] args) {
        final InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis/config/mybatis-config.xml");
        SqlSessionFactory factory = new MybatisSqlSessionFactoryBuilder().build(stream, null, null);
    }
}
