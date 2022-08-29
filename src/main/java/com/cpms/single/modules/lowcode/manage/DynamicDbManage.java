package com.cpms.single.modules.lowcode.manage;

import com.cpms.single.modules.lowcode.bo.DynamicDbInfoBO;
import com.cpms.single.modules.lowcode.dto.QueryTableFieldDTO;
import com.cpms.single.modules.lowcode.dto.TableFieldDTO;
import com.cpms.single.modules.lowcode.mapper.DynamicDbMapper;
import com.cpms.single.modules.lowcode.vo.DbTableVO;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;


/**
 * @author gulang
 * @Description:
 * @time: 2022/1/27 21:45
 */
@Component
public class DynamicDbManage {

    @Resource
    private DynamicDbMapper dynamicDBMapper;

    public boolean testDb(DynamicDbInfoBO dynamicDbInfoBO){
        return  true;
    }

    public List<DbTableVO> selectInformationTables(DynamicDbInfoBO dynamicDbInfoBO, String dbName){
        return dynamicDBMapper.selectInformationTables(dbName);
    }

    public List<TableFieldDTO> queryTableFields(DynamicDbInfoBO dynamicDbInfoBO, QueryTableFieldDTO queryTableFieldDTO){
        return dynamicDBMapper.queryTableFields(queryTableFieldDTO);
    }
}
