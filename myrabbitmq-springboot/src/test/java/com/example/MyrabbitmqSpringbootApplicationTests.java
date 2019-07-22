package com.example;

import com.example.direct.MsgSenderDirect;
import com.example.fanout.MsgSenderFanout;
import com.example.simple.SimpleHelloSender;
import com.example.topic.MsgSenderTopic;
import com.example.worker.WorkerHelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyrabbitmqSpringbootApplicationTests {
    @Autowired
    private SimpleHelloSender simpleHelloSender;
    @Autowired
    private WorkerHelloSender workerHelloSender;
    @Autowired
    private MsgSenderTopic msgSenderTopic;
    @Autowired
    private MsgSenderFanout msgSenderFanout;
    @Autowired
    private MsgSenderDirect msgSenderDirect;

    @Test
    public void contextLoads() {
    }

    @Test
    public void hello() {
        simpleHelloSender.send();
    }

    @Test
    public void oneToMany() throws Exception {
        for (int i = 0; i < 100; i++) {
            workerHelloSender.send(i);
            Thread.sleep(300);
        }
    }

    @Test
    public void sendMsg() {
        msgSenderTopic.send1();
    }

    @Test
    public void sendMsg2() {
        msgSenderTopic.send2();
    }

    @Test
    public void sendFanoutMsg() {
        msgSenderFanout.send();
    }

    @Test
    public void sendMsg3() {
        msgSenderDirect.send1();
    }

    @Test
    public void sendMsg4() {
        msgSenderDirect.send2();
    }
}
