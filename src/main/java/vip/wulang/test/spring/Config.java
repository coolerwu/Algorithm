package vip.wulang.test.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"vip.wulang.test.spring"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
public class Config {

}
