package com.cpms.single.modules.system.controller;

import com.cpms.framework.common.core.api.Result;
import com.cpms.framework.common.core.api.ResultUtil;
import com.cpms.framework.common.core.base.BasePageVO;
import com.cpms.single.modules.system.dto.QueryLogDTO;
import com.cpms.single.modules.system.service.ISysLogService;
import com.cpms.single.modules.system.vo.SysLogVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description:
 * @author: gulang
 * @time: 2021/9/23 16:21
 */
@RestController
@RequestMapping("/sys-log")
public class SysLogController {
    @Resource
    private ISysLogService sysLogService;
    /**
     *  查看列表
     * @param listLogDTO
     * @return
     */
    @PostMapping("/list")
    public Result<BasePageVO<SysLogVO>> listLog(@RequestBody QueryLogDTO listLogDTO){
        return ResultUtil.success(sysLogService.listLog(listLogDTO));
    }

    /**
     *  删除操作
     * @param logId
     * @return
     */
    @PostMapping("/delete")
    public Result<BasePageVO<SysLogVO>> deleteLog(@RequestParam("logId") Long logId){
        return ResultUtil.status(sysLogService.deleteLog(logId));
    }
}
