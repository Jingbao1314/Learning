package myrabbit;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by jingbao on 18-9-4.
 */
public class RabbitmqProducerMain {
    //http://pdf.us/2018/06/01/1167.html   :rabbitmq开发指导 以及简单原理
    //https://blog.csdn.net/qq_20545159/article/details/53857351
    //https://www.linuxidc.com/Linux/2017-12/149210.htm
    //https://blog.csdn.net/fxq8866/article/details/62049393
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("test");
        factory.setPassword("123456");
        factory.setVirtualHost("/");

        Connection connection =  factory.newConnection();

        Channel channel = connection.createChannel();
//        Map<String, Object> argss = new HashMap<String, Object>();
//        argss.put("vhost", "/");
//        argss.put("username","root");
//        argss.put("password", "root");
//        argss.put("x-message-ttl",1000);
        String queueName = "queueOne";
        String exchangeName = "exchangerOne";
        String routingKey = "queueOne";
        channel.exchangeDeclare(exchangeName,"direct");
        channel.queueDeclare(queueName,false,false,false,null);
        channel.queueBind(queueName,exchangeName,routingKey);
//        run(exchangeName);

        int msgCnt =15;
        while(msgCnt-->0){
            String msg = "msg"+Math.random()*100;
            channel.basicPublish(exchangeName,routingKey,null,msg.getBytes());  //发送消息
//            channel.basicPublish(exchangeName,routingKey, new AMQP
//                            .BasicProperties.Builder().expiration(String
//                            .valueOf(10* 1000)).build(),
//                    msg.getBytes());
            System.out.println("produce msg :"+msg);
//            TimeUnit.SECONDS.sleep(5);
        }
        channel.close();
        connection.close();
    }

}
