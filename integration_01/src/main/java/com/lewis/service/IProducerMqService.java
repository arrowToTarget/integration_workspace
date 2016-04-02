package com.lewis.service;

import com.lewis.vo.MsgVo;

/**
 * Created by zhangminghua on 2016/4/2.
 */
public interface IProducerMqService {

    public void sendMsg(MsgVo msgVo);

}
