package com.kgc.tcmp077.service.impl;

import com.kgc.tcmp077.mapper.BillTypeMapper;
import com.kgc.tcmp077.pojo.BillType;
import com.kgc.tcmp077.pojo.BillTypeExample;
import com.kgc.tcmp077.service.BillTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-02 17:52
 */
@Service("billTypeService")
public class BillTypeServiceImpl implements BillTypeService {
    @Resource
    BillTypeMapper billTypeMapper;
    @Override
    public List<BillType> selectById(Integer id) {
        BillTypeExample example=new BillTypeExample();
        BillTypeExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<BillType> billTypes = billTypeMapper.selectByExample(example);
        return billTypes;
    }
    @Override
    public List<BillType> typeList() {
        return  billTypeMapper.selectByExample(null);
    }
}
