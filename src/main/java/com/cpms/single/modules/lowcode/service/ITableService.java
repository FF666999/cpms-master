package com.cpms.single.modules.lowcode.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpms.single.modules.lowcode.dto.TableDTO;
import com.cpms.single.modules.lowcode.entity.TableEntity;

import java.util.List;

/**
 * @description:
 * @author: gulang
 * @time: 2022/1/25 10:29
 */
public interface ITableService extends IService<TableEntity> {
    List<TableEntity> listTable(TableDTO tableDTO);

    boolean addTable(TableDTO tableDTO);

    boolean updateTable(TableDTO tableDTO);

    boolean delTable(TableDTO tableDTO);
}
