package com.kgc.tcmp077.service;

import com.kgc.tcmp077.pojo.BillType;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-02 17:51
 */
public interface BillTypeService {
    List<BillType> typeList();
    List<BillType> selectById(Integer id);
}
