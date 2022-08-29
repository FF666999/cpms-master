package com.cpms.single.modules.lowcode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cpms.framework.common.utils.CsCollectionUtil;
import com.cpms.single.common.enums.DbTypeEnum;
import com.cpms.single.modules.lowcode.bo.DynamicDbInfoBO;
import com.cpms.single.modules.lowcode.dto.DynamicDbDTO;
import com.cpms.single.modules.lowcode.dto.QueryTableFieldDTO;
import com.cpms.single.modules.lowcode.dto.TableFieldDTO;
import com.cpms.single.modules.lowcode.entity.ProjectDbEntity;
import com.cpms.single.modules.lowcode.entity.TableEntity;
import com.cpms.single.modules.lowcode.manage.DynamicDbManage;
import com.cpms.single.modules.lowcode.service.IDynamicDbService;
import com.cpms.single.modules.lowcode.service.IProjectDbService;
import com.cpms.single.modules.lowcode.service.ITableService;
import com.cpms.single.modules.lowcode.vo.DbTableVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * @description:
 * @author: gulang
 * @time: 2022/1/28 15:46
 */
@Service
public class DynamicDbServiceImpl implements IDynamicDbService {
    @Resource
    private DynamicDbManage dynamicDbManage;
    @Resource
    private IProjectDbService projectDbService;

    @Resource
    private ITableService tableService;

    @Override
    public boolean testDb(DynamicDbDTO dynamicDbDTO) {
        DynamicDbInfoBO dynamicDbInfoBO = DynamicDbInfoBO.builder()
                .build()
                .initDBInfo(dynamicDbDTO.getDbIp()+":"+dynamicDbDTO.getDbPort(),dynamicDbDTO.getDbName(),
                        dynamicDbDTO.getDbUser(),
                        dynamicDbDTO.getDbPassword(),
                        DbTypeEnum.getByType(dynamicDbDTO.getDbDriverClass()).getDriverClass());
        return dynamicDbManage.testDb(dynamicDbInfoBO);
    }

    @Override
    public List<DbTableVO> selectInformationTables(Long dbId) {
        DynamicDbInfoBO dynamicDbInfoBO = buildDynamicDbInfoBO(dbId);
        List<DbTableVO> dbTablesDTOS = dynamicDbManage.selectInformationTables(dynamicDbInfoBO, dynamicDbInfoBO.getDbName());
        if(!CsCollectionUtil.isEmpty(dbTablesDTOS)){
            // 判断表是否已存在
            LambdaQueryWrapper<TableEntity> tableQueryWrapper = Wrappers.lambdaQuery();
            tableQueryWrapper.select(TableEntity::getTableName,TableEntity::getTableId);
            tableQueryWrapper.eq(TableEntity::getDbId,dbId);
            Map<String,TableEntity> tableMaps = tableService.list(tableQueryWrapper).stream().collect(Collectors.toMap(TableEntity::getTableName, TableEntity->TableEntity));
            dbTablesDTOS.forEach(e->{
                TableEntity val = tableMaps.get(e.getTableName());
                if(Objects.isNull(val)){
                    e.setSyncStatus(0);
                }else{
                    e.setSyncStatus(1);
                    e.setTableId(val.getTableId());
                }
            });
        }
        return dbTablesDTOS;
    }


    private DynamicDbInfoBO buildDynamicDbInfoBO(Long dbId){
        ProjectDbEntity dbEntity = projectDbService.getById(dbId);
       return DynamicDbInfoBO.builder()
                .build()
                .initDBInfo(dbEntity.getDbIp()+":"+dbEntity.getDbPort(),dbEntity.getDbName(),
                        dbEntity.getDbUser(),
                        dbEntity.getDbPassword(),
                        DbTypeEnum.getByType(dbEntity.getDbDriverClass()).getDriverClass());
    }
    @Override
    public List<TableFieldDTO> queryTableFields(QueryTableFieldDTO queryTableFieldDTO) {
        return dynamicDbManage.queryTableFields(buildDynamicDbInfoBO(queryTableFieldDTO.getDbId()),queryTableFieldDTO);
    }

}
