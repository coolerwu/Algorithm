package vip.wulang.test.spring;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignRecordService {

    @Transactional
    public void add() {
        System.out.println("111111");
    }
}
