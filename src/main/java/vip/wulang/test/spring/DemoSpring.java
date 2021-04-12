package vip.wulang.test.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class DemoSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Student bean = context.getBean(Student.class);
        System.out.println(bean);

        Map<String, IName> beansOfType = context.getBeansOfType(IName.class);
        System.out.println(beansOfType);
    }
}
