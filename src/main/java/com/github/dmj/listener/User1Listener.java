package com.github.dmj.listener;

import cn.hutool.json.JSONUtil;
import com.github.dmj.annotation.MjMsgListener;
import com.github.dmj.model.MjMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author ljjy1
 * @classname User1Listener
 * @description TODO
 * @date 2023/10/17 14:37
 */
@Component
@MjMsgListener(userKey = "user1")  //只监听自己userKey为user1的消息
@Slf4j
public class User1Listener implements MjListener{

    @Override
    public void onEmbedMsg(MjMsg mjMsg) {
        log.info("收到账号user1消息:{} ", JSONUtil.toJsonStr(mjMsg));
    }
}
