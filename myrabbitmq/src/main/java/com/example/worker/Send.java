package com.example.worker;

import com.example.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 生产者发送消息到队列
 *
 * @author Steven Shi
 * @date 2019/7/20 9:55
 */
public class Send {
    private final static String QUEUE_NAME = "test_queue_work";

    public static void main(String[] args) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明（创建）队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 消息内容
        for (int i = 0; i < 100; i++) {
            // 消息内容
            String message = "" + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

            Thread.sleep(i * 10);
        }
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
