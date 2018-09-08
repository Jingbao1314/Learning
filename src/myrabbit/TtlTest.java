package myrabbit;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by jingbao on 18-9-5.
 */
public class TtlTest {
    private final static String QUEUE_NAME = "MAIN_QUEUE";
    private final static String _DIRECT_NAME = "_delay_delay";

    public static void main(String[] args) throws Exception {
        for(int i=0;i<3;i++){
            Connection con= (Connection) abq.take();
            Channel channel=init(con.createChannel());
            long delay = 5*1000;

            String message = "Hello World!";
            AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
            AMQP.BasicProperties properties = builder.expiration(delay+"").build();
            channel.basicPublish("", _DIRECT_NAME, properties, message.getBytes());
            channel.close();
            con.close();
        }


    }
    private static Channel myChannel=null;
    private static Connection myConnection=null;
    private final static int CON_SIZE=3;
    private static ArrayBlockingQueue abq=new ArrayBlockingQueue(CON_SIZE);


    static {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("test");
        factory.setPassword("123456");
        factory.setVirtualHost("/");
        try {
            int i=CON_SIZE;
            while (i-->0){
                Connection connection = factory.newConnection();
                try {
                    abq.put(connection);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static Channel init(Channel channel){
        try {
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            channel.queueBind(QUEUE_NAME, "amq.direct", QUEUE_NAME);
            Map<String, Object> arguments = new HashMap<>();
            arguments.put("x-dead-letter-exchange", "amq.direct");
            arguments.put("x-dead-letter-routing-key", QUEUE_NAME);
            channel.queueDeclare(_DIRECT_NAME, true, false, false,
                    arguments);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return channel;

    }
//    static {
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("127.0.0.1");
//        factory.setPort(5672);
//        factory.setUsername("test");
//        factory.setPassword("123456");
//        factory.setVirtualHost("/");
//        try {
//            Connection connection = factory.newConnection();
//            Channel channel = connection.createChannel();
//
//            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
//            channel.queueBind(QUEUE_NAME, "amq.direct", QUEUE_NAME);
////            Map<String, Object> arguments = new HashMap<>();
////            arguments.put("x-dead-letter-exchange", "amq.direct");
////            arguments.put("x-dead-letter-routing-key", QUEUE_NAME);
////            channel.queueDeclare(_DIRECT_NAME, true, false, false, arguments);
////            channel.queueBind(QUEUE_NAME, "amq.direct", QUEUE_NAME);
//            Map<String, Object> arguments = new HashMap<>();
//            arguments.put("x-dead-letter-exchange", "amq.direct");
//            arguments.put("x-dead-letter-routing-key", QUEUE_NAME);
//            channel.queueDeclare(_DIRECT_NAME, true, false, false,
//                    arguments);
//            myChannel=channel;
//            myConnection=connection;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }

    public static void publish(){
        long delay = 5*1000;

        String message = "Hello World!";
        AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
        AMQP.BasicProperties properties = builder.expiration(delay+"").build();
        try {
            myChannel.basicPublish("", _DIRECT_NAME, properties, message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void close(){
        try {
            myChannel.close();
            myConnection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void demo() throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("test");
        factory.setPassword("123456");
        factory.setVirtualHost("/");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        channel.queueBind(QUEUE_NAME, "amq.direct", QUEUE_NAME);

        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-dead-letter-exchange", "amq.direct");
        arguments.put("x-dead-letter-routing-key", QUEUE_NAME);
        channel.queueDeclare(_DIRECT_NAME, true, false, false, arguments);

        // 延迟5秒
        long delay = 5*1000;

        String message = "Hello World!";
        AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
        AMQP.BasicProperties properties = builder.expiration(delay+"").build();
        channel.basicPublish("", _DIRECT_NAME, properties, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}
