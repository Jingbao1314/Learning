package rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

/**
 * Created by jingbao on 18-8-13.
 */
public class Res {
    public static void main(String[] args) throws Exception {
        ConnectionFactory connFac = new ConnectionFactory();
        connFac.setHost("127.0.0.1");
        Connection conn = connFac.newConnection();
        Channel channel = conn.createChannel();
        String exchangeName = "news";
        channel.exchangeDeclare(exchangeName, "fanout");
        // 这里使用没有参数的queueDeclare方法创建Queue并获取QueueName
        String queueName = channel.queueDeclare().getQueue();
        // 将queue绑定到Exchange中
        channel.queueBind(queueName, exchangeName, "");
        // 配置好获取消息的方式
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(queueName, true, consumer);
        // 循环获取消息
        while (true) {
            // 获取消息，如果没有消息，这一步将会一直阻塞
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String msg = new String(delivery.getBody());
            System.out.println("received message[" + msg + "] from "
                    + queueName);
        }
    }
}
