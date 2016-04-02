package com.lewis.vo;

import com.lewis.annotation.MsgType;

/**
 * Created by zhangminghua on 2016/4/2.
 */
public class MsgVo {

    private String sendTime;

    private MsgType msgType;

    private String content;

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public MsgType getMsgType() {
        return msgType;
    }

    public void setMsgType(MsgType msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MsgVo(String sendTime, MsgType msgType, String content) {
        this.sendTime = sendTime;
        this.msgType = msgType;
        this.content = content;
    }

    public MsgVo() {
    }

    @Override
    public String toString() {
        return "MsgVo{" +
                "sendTime='" + sendTime + '\'' +
                ", msgType=" + msgType +
                ", content='" + content + '\'' +
                '}';
    }
}
