package myrabbit.test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * Created by jingbao on 18-9-12.
 */
public class ProduceTest {
    public static void main(String[] args) throws Exception {
        direct("qqqqqqq","queue-direct2");
        direct("ccccc","queue-direct1");

    }
    public static void direct(String data,String name) throws IOException
    {//direct模式
        Connection connection =getConnection();

        Channel channel = connection.createChannel();
        String queueName = name;
        String exchangeName = "direct-test";
        String routingKey = name;
        channel.exchangeDeclare(exchangeName,"direct");
        channel.queueDeclare(queueName,false,false,false,null);
        channel.queueBind(queueName,exchangeName,routingKey);
        channel.basicPublish(exchangeName,routingKey,null,data.getBytes());
        //发送消息
//        System.out.println("produce msg :"+data);
        channel.close();
        connection.close();

    }

    public static void fanout(String url){//fanout模式
        Connection connection =getConnection();try {
            Channel channel = connection.createChannel();
            channel.exchangeDeclare("test_exchange_fanout","fanout");//fanout交换器
            //消息内容
            channel.basicPublish("test_exchange_fanout","",null,url.getBytes());
            System.out.println(" [x] Sent'"+url+"'" );
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void topic() throws IOException {//topic模式
        Connection connection = getConnection();
        Channel channel = connection.createChannel();
        //声明exchange
        channel.exchangeDeclare("topic-test","topic");
        //消息内容
        String message = "插入商品，id=100";
        //发布消息
        channel.basicPublish("topic-test","item.insert",null,message.getBytes());
        System.out.println(" [x] Sent '"+message + "'");
        channel.close();
        connection.close();
    }

    public static Connection getConnection(){
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("test");
        factory.setPassword("123456");
        factory.setVirtualHost("/");
        Connection connection= null;
        try {
            connection=  factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;

    }
}
