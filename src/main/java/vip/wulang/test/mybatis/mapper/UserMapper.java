package vip.wulang.test.mybatis.mapper;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    Map<String, Object> findById(Long id);

    List<Map<String, Object>> findAll();
}
