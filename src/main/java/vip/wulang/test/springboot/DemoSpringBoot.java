package vip.wulang.test.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import vip.wulang.test.spring.Student;

@SpringBootApplication
@Cus
@Import(ImportCusImpl.class)
public class DemoSpringBoot {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoSpringBoot.class, args);
        Student student = context.getBean(Student.class);
        student.ccc();
        System.out.println(context.getBean("11111"));

    }
}
