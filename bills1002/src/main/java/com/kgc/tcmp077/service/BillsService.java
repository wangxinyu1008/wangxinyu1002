package com.kgc.tcmp077.service;

import com.kgc.tcmp077.pojo.Bills;

import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-02 18:00
 */
public interface BillsService {
    List<Bills> selectAll();
    List<Bills> bList(String typeId, Date ksTime, Date jsTime);
    void addBills(Bills bills);
}
