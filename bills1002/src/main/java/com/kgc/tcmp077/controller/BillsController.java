package com.kgc.tcmp077.controller;

import com.github.pagehelper.PageHelper;
import com.kgc.tcmp077.pojo.BillType;
import com.kgc.tcmp077.pojo.Bills;
import com.kgc.tcmp077.service.BillTypeService;
import com.kgc.tcmp077.service.BillsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Controller
public class BillsController {
    @Resource
    BillsService billsService;
    @Resource
    BillTypeService billTypeService;
    @RequestMapping("/")
    public String index(Model model){
        List<Bills> bills = billsService.selectAll();
        List<BillType> billType = billTypeService.typeList();
        model.addAttribute("bills",bills);
        model.addAttribute("billType",billType);
        return "index";
    }
    @RequestMapping("/mocha")
    public String mocha(String typeId, Date ksTime, Date jsTime, Model model) {
        List<Bills> bills = billsService.bList(typeId, ksTime, jsTime);
        List<BillType> billType = billTypeService.typeList();
        model.addAttribute("billType", billType);
        model.addAttribute("bills", bills);
        return "index";
    }
    @RequestMapping("/add")
    public String add(Model model){
        List<BillType> billTypes = billTypeService.typeList();
        model.addAttribute("billTypes", billTypes);
        return "add";
    }

    @RequestMapping("/addOver")
    public String addOver(Bills bills){
        billsService.addBills(bills);
        return "redirect:/";
    }
}
