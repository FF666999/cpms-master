package com.cpms.single.common.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description:
 * @author: gulang
 * @time: 2021/8/20 18:39
 */
@Data
@ToString
public class HandlerLogDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private Long tenantId;
    private String serviceName;
    private String handleIp;
    private String reqUrl;
    private String reqMethod;
    private String reqParams;
    private String createBy;
    private Long exeTime;
    private String resultMsg;
    private String className;
    private String methodName;
}
