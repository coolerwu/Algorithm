package vip.wulang.test.mybatis.mapper;

import java.util.Map;

public interface UserMapper {
    Map<String, Object> findById(Long id);
}
