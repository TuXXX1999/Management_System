package com.tx.mydemo.controller;


import com.tx.mydemo.domain.Info;
import com.tx.mydemo.domain.User;
import com.tx.mydemo.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/info")
public class InfoController {
    @Autowired
    private InfoService infoService;

    @GetMapping("/selectAllInfo")
    public String[] InfoList() {


        List<Info> infos = infoService.InfoList();
        String[] name=new String[infos.size()];
        for(int i=0;i<infos.size();i++){
            name[i]= infos.get(i).getInfo_Name();
        }
        return name;
    }

    @PostMapping("/addInfo")
    public int add(@RequestBody HashMap<String, Object> datas) {

        Info info = new Info();
        info.setInfo_Name((String) datas.get("name"));
        info.setInfo_Phone((String) datas.get("phone"));
        info.setInfo_Type((String) datas.get("type"));
        info.setInfo_Cycle((String) datas.get("cycle"));
        info.setInfo_Address((String) datas.get("address"));
        info.setInfo_Others((String) datas.get("others"));
        int res = infoService.add(info);
        return res;
    }

    @PostMapping("/deleteById/{id}")
    public int deleteById(@PathVariable("id") Integer id) {
        if (infoService.deleteById(id) >= 0) {
            return 1;
        } else {
            return 0;
        }
    }


    @GetMapping("/updateInfo/{id}")
    public Info selectById(@PathVariable("id") Integer id) {
        return infoService.selectById(id);
    }


    @PostMapping("/updateInfo")
    public int update(@RequestBody Info info) {
        if (infoService.update(info) >= 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @GetMapping("/selectAllByPage/{currentPage}")
    public List<Info> selectAllByPage(
            @PathVariable("currentPage") Integer currentPage) {
        int begin = (currentPage - 1) * 10;
        return infoService.selectAllByPage(begin);

    }


    @PostMapping("/selectAllByPageAndCondition")
    public List<Info> selectAllByPageAndCondition(@RequestBody HashMap<String, Object> datas) {
        Info info = new Info();
        int currentPage = (Integer) datas.get("Page");
        int begin = (currentPage - 1) * 10;
        info.setInfo_Name((String) datas.get("Name"));
        info.setInfo_Phone((String) datas.get("Phone"));

        String type = (String) datas.get("Type");
        if (type != null) {
            if (type.equals("0")) {
                type = "常客户";
            } else if (type.equals("1")) {
                type = "临时客户";
            }
        }

        info.setInfo_Type(type);
        List<Info> infos = infoService.selectAllByPageAndCondition(begin, info);
        return infos;
    }


    @PostMapping("/totalInfo")
    public Integer totalInfo(@RequestBody HashMap<String, Object> datas) {

        Info info = new Info();
        info.setInfo_Name((String) datas.get("Name"));
        info.setInfo_Phone((String) datas.get("Phone"));
        String type = (String) datas.get("Type");
        if (type != null) {
            if (type.equals("0")) {
                type = "常客户";
            } else if (type.equals("1")) {
                type = "临时客户";
            }
        }

        info.setInfo_Type(type);
        int totalCount = this.infoService.totalInfo(info);
        return totalCount;
    }


}
