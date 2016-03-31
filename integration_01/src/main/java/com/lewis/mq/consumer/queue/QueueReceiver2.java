package com.lewis.mq.consumer.queue;

import org.springframework.stereotype.Component;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by zhangminghua on 2016/3/31.
 */
@Component
public class QueueReceiver2 implements MessageListener {

    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                String text = ((TextMessage) message).getText();
                System.out.println("QueueReceiver2 receive msg:"+text);
            } catch (JMSException e) {

            }
        }
    }
}
