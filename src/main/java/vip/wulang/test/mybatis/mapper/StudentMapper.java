package vip.wulang.test.mybatis.mapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface StudentMapper {
    Map<String, Object> findById(Long id);

    List<Map<String, Object>> findAll();

    List<Map<String, Object>> findTime(LocalDate start, LocalDate end);

    void insert(String username, String password);
}
