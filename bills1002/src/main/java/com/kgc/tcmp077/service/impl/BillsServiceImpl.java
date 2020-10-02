package com.kgc.tcmp077.service.impl;

import com.kgc.tcmp077.mapper.BillsMapper;
import com.kgc.tcmp077.pojo.BillType;
import com.kgc.tcmp077.pojo.Bills;
import com.kgc.tcmp077.pojo.BillsExample;
import com.kgc.tcmp077.service.BillTypeService;
import com.kgc.tcmp077.service.BillsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-02 18:00
 */
@Service("billsService")
public class BillsServiceImpl implements BillsService{
    @Resource
    BillsMapper billsMapper;
    @Resource
    BillTypeService billTypeService;

    @Override
    public List<Bills> selectAll() {
        BillsExample billsExample=new BillsExample();
        billsExample.setOrderByClause("bill_time desc");
        List<Bills> bills = billsMapper.selectByExample(billsExample);
        for(int i=0;i<bills.size();i++){
            List<BillType> billTypes = billTypeService.selectById(bills.get(i).getTypeId());
            bills.get(i).setTypeName(billTypes.get(0).getName());
        }
        return bills;
    }

    @Override
    public List<Bills> bList(String typeId, Date ksTime, Date jsTime) {
        BillsExample example=new BillsExample();
        BillsExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("bill_time desc");
        if(typeId!=null&&typeId.equals("0")==false){
            criteria.andTypeIdEqualTo(Integer.valueOf(typeId));
        }
        if(ksTime!=null&&jsTime!=null){
            criteria.andBillTimeGreaterThan(ksTime);
            criteria.andBillTimeLessThan(jsTime);
        }
        List<Bills> bills = billsMapper.selectByExample(example);
        for(int i=0;i<bills.size();i++){
            List<BillType> billTypes = billTypeService.selectById(bills.get(i).getTypeId());
            bills.get(i).setTypeName(billTypes.get(0).getName());
        }
        return bills;

    }

    @Override
    public void addBills(Bills bills) {
        billsMapper.insertSelective(bills);
    }
}
