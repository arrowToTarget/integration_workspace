package com.lewis.mq.producer.topic;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by zhangminghua on 2016/4/2.
 */
@Component
public class TopicUserReceiver implements MessageListener {


    public void onMessage(Message message) {
        System.out.println("TopicUserReceiver :"+message);
        if (message instanceof TextMessage) {
            try {
                String text = ((TextMessage) message).getText();
                System.out.println("TopicUserReceiver receiver: ["+text+"]");
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
