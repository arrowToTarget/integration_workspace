package com.lewis.service.impl;

import com.lewis.service.IProducerMqService;
import com.lewis.util.JsonUtil;
import com.lewis.vo.MsgVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by zhangminghua on 2016/4/2.
 */
@Service
public class ProducerMqServiceImpl implements IProducerMqService {

    @Resource(name="jmsTopicTemplate")
    private JmsTemplate jmsTemplate;

    @Value("mq.topicUser")
    private String topicName;

    public void sendMsg(final MsgVo msgVo) {
        jmsTemplate.send(topicName, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(JsonUtil.toString(msgVo));
            }
        });
    }
}
