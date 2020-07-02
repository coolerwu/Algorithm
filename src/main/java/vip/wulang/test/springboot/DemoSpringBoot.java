package vip.wulang.test.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import vip.wulang.test.spring.Student;

@SpringBootApplication
@Cus
public class DemoSpringBoot {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoSpringBoot.class, args);
        Student student = context.getBean(Student.class);
        student.ccc();
    }
}
