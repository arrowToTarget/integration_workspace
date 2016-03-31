package com.lewis.mq.consumer.queue;

import org.springframework.stereotype.Component;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by zhangminghua on 2016/3/31.
 */
@Component
public class QueueReceiver1 implements MessageListener {

    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage){
                String msg = ((TextMessage) message).getText();
                System.out.println("QueueReceiver1 receiver msg:"+msg);
            }
        } catch (Exception e) {

        }

    }
}
