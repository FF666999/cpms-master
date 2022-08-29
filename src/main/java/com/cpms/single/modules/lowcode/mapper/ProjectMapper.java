package com.cpms.single.modules.lowcode.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpms.single.modules.lowcode.dto.QueryProjectDTO;
import com.cpms.single.modules.lowcode.entity.ProjectEntity;
import com.cpms.single.modules.lowcode.vo.ProjectDbVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author gulang
 * @Description:
 * @time: 2021/8/21 16:09
 */
public interface ProjectMapper extends BaseMapper<ProjectEntity> {

    int listProjectCount(QueryProjectDTO queryProjectDTO);

    List<ProjectEntity> listProject(QueryProjectDTO queryProjectDTO);

    List<ProjectDbVO> selectProjectDbByProjectId(@Param("projectId") Long projectId);
}
