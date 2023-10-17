package com.github.dmj.listener;

import cn.hutool.json.JSONUtil;
import com.github.dmj.annotation.MjMsgListener;
import com.github.dmj.model.MjMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author ljjy1
 * @classname MyListener
 * @description 监听所有账号消息
 * @date 2023/10/17 14:36
 */
@Component
@MjMsgListener  //不填写注解参数 监听所有账号消息
@Slf4j
public class MyListener implements MjListener{
    @Override
    public void onEmbedMsg(MjMsg mjMsg) {
        log.info("收到所有账号消息:{} ", JSONUtil.toJsonStr(mjMsg));
    }
}
