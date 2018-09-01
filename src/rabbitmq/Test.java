package rabbitmq;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * Created by jingbao on 18-8-13.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        ConnectionFactory connFac = new ConnectionFactory();
        // RabbitMQ-Server安装在本机，所以直接用127.0.0.1
        connFac.setHost("127.0.0.1");
        // 创建一个连接
        Connection conn = connFac.newConnection();
        // 创建一个渠道
        Channel channel = conn.createChannel();
        // 定义ExchangeName,第二个参数是Exchange的类型，fanout表示消息将会分列发送给多账户
        String exchangeName = "news";
        channel.exchangeDeclare(exchangeName, "fanout");//Exchange的类型有direct,topic,headers,fanout四种
        String msg = "Hello World!";
        // 发送消息，这里与前面的不同，这里第一个参数不再是字符串，而是ExchangeName ，第二个参数也不再是queueName，而是空字符串
        channel.basicPublish(exchangeName, "", null, msg.getBytes());
        System.out.println("send message[" + msg + "] to exchange "
                + exchangeName + " success!");
        channel.close();
        conn.close();
    }
}
