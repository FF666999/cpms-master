package com.cpms.single.modules.lowcode.controller;

import com.cpms.framework.common.core.api.Result;
import com.cpms.framework.common.core.api.ResultUtil;
import com.cpms.framework.common.core.base.BasePageVO;
import com.cpms.framework.mybatis.groups.ValidatorGroup;
import com.cpms.single.modules.lowcode.dto.ProjectDetailDTO;
import com.cpms.single.modules.lowcode.dto.QueryProjectDTO;
import com.cpms.single.modules.lowcode.service.IProjectDbService;
import com.cpms.single.modules.lowcode.service.IProjectService;
import com.cpms.single.modules.lowcode.vo.ProjectDbVO;
import com.cpms.single.modules.lowcode.vo.ProjectDetailVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author gulang
 * @Description:
 * @time: 2022/1/17 20:08
 */
@RestController
@RequestMapping("/project")
@Slf4j
public class ProjectController {
    @Resource
    private IProjectService projectService;
    @Resource
    private IProjectDbService projectDbService;

    @PostMapping("/listProject")
    public Result<BasePageVO<ProjectDetailVO>> listProject(@RequestBody QueryProjectDTO queryProjectDTO) {
        return ResultUtil.success(projectService.listProject(queryProjectDTO));
    }

    @PostMapping("/addProject")
    public Result<Void> addProject(@Validated(ValidatorGroup.Add.class)@RequestBody ProjectDetailDTO projectDTO){
        return ResultUtil.status(projectService.addProject(projectDTO));
    }

    @PostMapping("/updateProject")
    public Result<Void> updateProject(@RequestBody ProjectDetailDTO projectDTO){
        return ResultUtil.status(projectService.updateProject(projectDTO));

    }

    @PostMapping("/delProject")
    public Result<Void> delProject(@RequestBody ProjectDetailDTO projectDTO){
        return ResultUtil.status(projectService.delProject(projectDTO));

    }

    @GetMapping("/dbTables")
    public Result<List<ProjectDbVO>> projectDbs(@RequestParam(name = "projectId") Long projectId){
        return  ResultUtil.success(projectDbService.listProjectDb(projectId));
    }
}
