package vip.wulang.test.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Student bean = context.getBean(Student.class);
        System.out.println(bean);
    }
}
