package com.tx.mydemo.controller;


import com.tx.mydemo.domain.Info;
import com.tx.mydemo.domain.OverDate;
import com.tx.mydemo.service.InfoService;
import com.tx.mydemo.service.OverDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/overdate")
public class OverDateController {
    @Autowired
    private OverDateService overDateService;

    @GetMapping("/selectAll")
    public List<OverDate> overDateList() {
        return this.overDateService.overDatelist();
    }

    @PostMapping("/addOverDate")
    public int add(@RequestBody HashMap<String, Object> datas) {
        OverDate overDate = new OverDate();
        overDate.setOverDate_Name((String) datas.get("name"));
        overDate.setOverDate_Phone((String) datas.get("phone"));
        overDate.setOverDate_Type((String) datas.get("type"));
        overDate.setOverDate_Time((String) datas.get("time"));
        int res = overDateService.add(overDate);
        return res;
    }

    @PostMapping("/deleteById/{id}")
    public int deleteById(@PathVariable("id") Integer id) {
        if (overDateService.deleteById(id) >= 0) {
            return 1;
        } else {
            return 0;
        }
    }


    @GetMapping("/updateOverDate/{id}")
    public OverDate selectById(@PathVariable("id") Integer id) {
        return overDateService.selectById(id);
    }


    @PostMapping("/updateOverDate")
    public int update(@RequestBody OverDate overDate) {
        if (overDateService.update(overDate) >= 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @GetMapping("/selectAllByPage/{currentPage}")
    public List<OverDate> selectAllByPage(
            @PathVariable("currentPage") Integer currentPage) {
        int begin = (currentPage - 1) * 10;
        return overDateService.selectAllByPage(begin);

    }


    @PostMapping("/selectAllByPageAndCondition")
    public List<OverDate> selectAllByPageAndCondition(@RequestBody HashMap<String, Object> datas) {
        OverDate overDate = new OverDate();
        int currentPage = (Integer) datas.get("Page");
        int begin = (currentPage - 1) * 10;
        overDate.setOverDate_Name((String) datas.get("Name"));
        overDate.setOverDate_Phone((String) datas.get("Phone"));

        String type = (String) datas.get("Type");
        if (type != null) {
            if (type.equals("0")) {
                type = "常客户";
            } else if (type.equals("1")) {
                type = "临时客户";
            }
        }
        overDate.setOverDate_Type(type);
        List<OverDate> overDates = overDateService.selectAllByPageAndCondition(begin, overDate);
        return overDates;
    }


    @PostMapping("/totalOverDate")
    public Integer totalOverDate(@RequestBody HashMap<String, Object> datas) {

        OverDate overDate = new OverDate();
        overDate.setOverDate_Name((String) datas.get("Name"));
        overDate.setOverDate_Phone((String) datas.get("Phone"));
        String type = (String) datas.get("Type");
        if (type != null) {
            if (type.equals("0")) {
                type = "常客户";
            } else if (type.equals("1")) {
                type = "临时客户";
            }
        }
        overDate.setOverDate_Type(type);
        int totalCount = this.overDateService.totalInfo(overDate);
        return totalCount;
    }


    @PostMapping("/checkOverDate")
    public Integer checkOverDate() {
        int totalCount = this.overDateService.checkOverDate();
        return totalCount;
    }

}
