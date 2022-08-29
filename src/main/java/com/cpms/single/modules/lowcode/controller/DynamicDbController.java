package com.cpms.single.modules.lowcode.controller;


import com.cpms.framework.common.core.api.Result;
import com.cpms.framework.common.core.api.ResultUtil;
import com.cpms.framework.mybatis.groups.ValidatorGroup;
import com.cpms.single.modules.lowcode.dto.DynamicDbDTO;
import com.cpms.single.modules.lowcode.service.IDynamicDbService;
import com.cpms.single.modules.lowcode.vo.DbTableVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @description:
 * @author: gulang
 * @time: 2022/1/28 15:37
 */
@RestController
@RequestMapping("/dynamic")
public class DynamicDbController {
    @Resource
    private IDynamicDbService dynamicDbService;
    /**
     * 测试是否链接数据库
     */
    @PostMapping("/test-db")
    public Result<Void> genScaffold(@Validated(ValidatorGroup.Other.class) @RequestBody DynamicDbDTO dynamicDbDTO){
       return  ResultUtil.status(dynamicDbService.testDb(dynamicDbDTO));
    }

    @GetMapping("/dbTables")
    public Result<List<DbTableVO>> dbTables(@RequestParam(name = "dbId") @NotNull Long dbId){
        return  ResultUtil.success(dynamicDbService.selectInformationTables(dbId));
    }

}
