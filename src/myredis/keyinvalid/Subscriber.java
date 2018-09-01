package myredis.keyinvalid;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by jingbao on 18-8-7.
 */
public class Subscriber {

    public static void main(String[] args) {
        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.psubscribe(new KeyExpiredListener(), "__key*__:*");
    }

}
