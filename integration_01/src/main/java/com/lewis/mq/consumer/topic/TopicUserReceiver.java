package com.lewis.mq.consumer.topic;

import com.lewis.service.ICacheService;
import com.lewis.service.IUserService;
import com.lewis.util.JsonUtil;
import com.lewis.vo.MsgVo;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by zhangminghua on 2016/4/2.
 */
@Component
public class TopicUserReceiver implements MessageListener {

    @Resource
    private IUserService userService;

    @Resource
    private ICacheService cacheService;

    public void onMessage(Message message) {
        System.out.println("TopicUserReceiver :"+message);
        if (message instanceof TextMessage) {
            try {
                String text = ((TextMessage) message).getText();
                System.out.println("TopicUserReceiver receiver: ["+text+"]");
                MsgVo msgVo = JsonUtil.toBean(text, MsgVo.class);
                System.out.println("msgVo :"+msgVo.toString());
                userService.deleteById(Integer.parseInt(msgVo.getContent()));
                cacheService.delCache("allUsers");
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
