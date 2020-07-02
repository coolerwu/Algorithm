package vip.wulang.test.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAop {
    @Around(value = "execution(* vip.wulang.test.spring.Student.*(..))")
    public Object around(ProceedingJoinPoint point) {
        System.out.println("===========");
        try {
            return point.proceed();
        } catch (Throwable e) {
            return null;
        }
    }
}
