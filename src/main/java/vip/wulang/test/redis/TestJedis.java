package vip.wulang.test.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

@SuppressWarnings("SpellCheckingInspection")
public class TestJedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 7999);
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
    }
}
