package com.cpms.single.handler;

import com.alibaba.fastjson.JSON;
import com.cpms.framework.common.utils.CsBeanUtil;
import com.cpms.framework.log.dto.LogDTO;
import com.cpms.framework.log.event.LogEvent;
import com.cpms.single.common.dto.HandlerLogDTO;
import com.cpms.single.modules.system.service.ISysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * @description: 事件监听处理类
 * @author: gulang
 * @time: 2021/8/18 17:39
 */
@Slf4j
@Component
@EnableAsync
public class AsyncEventHandler {
    @Resource
    private ISysLogService sysLogService;
    /**
     *  指定线程池 defaultAsyncTaskPool
     * @param event
     */
    @Async("defaultAsyncTaskPool")
    @EventListener
    public void onHandlerLogEvent(LogEvent event) {
        log.info("[onHandlerLogEvent] 监听操作日志事件....LogEvent={},source={}", JSON.toJSONString(event),JSON.toJSONString(event.getSource()));
        LogDTO eventData = event.getEventData();
        HandlerLogDTO handlerLogDTO = new HandlerLogDTO();
        CsBeanUtil.copyProperties(eventData,handlerLogDTO);
        sysLogService.recordHandlerLog(handlerLogDTO);
    }
}
