package com.cpms.single.modules.lowcode.service;



import com.cpms.single.modules.lowcode.dto.DynamicDbDTO;
import com.cpms.single.modules.lowcode.dto.QueryTableFieldDTO;
import com.cpms.single.modules.lowcode.dto.TableFieldDTO;
import com.cpms.single.modules.lowcode.vo.DbTableVO;

import java.util.List;

/**
 * @description:
 * @author: gulang
 * @time: 2022/1/28 15:44
 */
public interface IDynamicDbService {
    boolean testDb(DynamicDbDTO dynamicDbDTO);

    List<DbTableVO> selectInformationTables(Long dbId);

    List<TableFieldDTO> queryTableFields(QueryTableFieldDTO queryTableFieldDTO);


}
