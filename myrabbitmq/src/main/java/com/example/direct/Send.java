package com.example.direct;

import com.example.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 路由模式，生产者
 *
 * @author Steven Shi
 * @date 2019/7/20 10:52
 */
public class Send {
    private final static String EXCHANGE_NAME = "test_exchange_direct";

    public static void main(String[] args) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // 声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        // 消息内容
        String message = "Hello World!";
        channel.basicPublish(EXCHANGE_NAME, "insert", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        // 关闭通道和连接
        channel.close();
        connection.close();
    }
}
