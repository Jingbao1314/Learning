package myrabbit;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by jingbao on 18-9-4.
 */
public class RabbitmqConsumerMain {
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("test");
        factory.setPassword("123456");
        factory.setVirtualHost("/");

        Connection connection =  factory.newConnection();

        Channel channel = connection.createChannel();
        String queueName = "queueOne";
        channel.queueDeclare(queueName,false,false,false,null);

        channel.basicQos(5);  //每次取5条消息

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //消费消费
                String msg = new String(body,"utf-8");
                System.out.println("consume msg: "+msg);
                try {
                    TimeUnit.MILLISECONDS.sleep((long) (Math.random()*500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //手动消息确认
                getChannel().basicAck(envelope.getDeliveryTag(),false);
            }
        };


        //调用消费消息
        channel.basicConsume(queueName,false,"queueOne",consumer);

    }
}
