package myredis.keyinvalid;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by jingbao on 18-8-7.
 */
public class KeyExpiredListener extends JedisPubSub {
//    private String key="";
//    public KeyExpiredListener(String key){
//        this.key=key;
//
//    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPSubscribe "
                + pattern + " " + subscribedChannels);
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {

        System.out.println(message);
        Jedis jedis=new Jedis("127.0.0.1",6379);
        String par=String.valueOf(System.currentTimeMillis()).substring(0,9)
                +"*";
        Set s=jedis.keys(par);
        Iterator iterator=s.iterator();
        while (iterator.hasNext()){
            System.out.println(jedis.get((String) iterator.next()));
        }
//        System.out.println(jedis.exists(String.valueOf(System.currentTimeMillis())));
    }



}
