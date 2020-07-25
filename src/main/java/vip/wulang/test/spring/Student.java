package vip.wulang.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
    private final SignRecordService signRecordService;

    @Autowired
    public Student(SignRecordService signRecordService) {
        this.signRecordService = signRecordService;
    }

    public void ccc() {
        signRecordService.add();
    }
}
