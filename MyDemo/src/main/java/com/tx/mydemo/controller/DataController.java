package com.tx.mydemo.controller;


import com.tx.mydemo.domain.Data;
import com.tx.mydemo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;


    /**
     * 添加数据
     *
     * @param datas
     * @return
     */
    @PostMapping("/addData")
    public int add(@RequestBody HashMap<String, Object> datas) {
        System.out.println(datas);
        Data data = new Data();
        data.setData_Time((String) datas.get("Data_Time"));
        data.setData_Amount((String) datas.get("Data_Amount"));
        data.setData_Info((String) datas.get("Data_Info"));
        data.setData_User((Integer) datas.get("Data_UserId"));
        int res = dataService.add(data);
        return res;
    }

    /**
     * 根据ID删除订单
     *
     * @param id
     * @return
     */
    @PostMapping("/deleteById/{id}")
    public int deleteById(@PathVariable("id") Integer id) {
        //如果删除成功是会返回删除的ID,所以如果ID大于0的话肯定是删除成功了
        if (dataService.deleteById(id) >= 0) {
            return 1;
        } else {
            return 0;
        }
    }


    /**
     * 更新数据，传进来的
     *
     * @param id
     * @return
     */
    @GetMapping("/updateData/{id}")
    public Data selectById(@PathVariable("id") Integer id) {
        return dataService.selectById(id);
    }


    @PostMapping("/updateData")
    public int updateData(@RequestBody HashMap<String, Object> datas) {
        Data data = new Data();
        data.setData_Time((String) datas.get("data_Time"));
        data.setData_User((Integer) datas.get("data_User"));
        data.setData_Info((String) datas.get("data_Info"));
        data.setData_Amount((String) datas.get("data_Amount"));
        data.setData_Id((Integer) datas.get("data_Id"));
        if (dataService.updateData(data) >= 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @GetMapping("/selectAllByPage/{currentPage}")
    public List<Data> selectAllByPage(
            @PathVariable("currentPage") Integer currentPage) {
        int begin = (currentPage - 1) * 10;
        return dataService.selectAllByPage(begin);

    }


    @PostMapping("/selectAllByPageAndCondition")
    public List<Data> selectAllByPageAndCondition(@RequestBody HashMap<String, Object> datas) {
        Data data = new Data();
        int currentPage = (Integer) datas.get("Page");
        int begin = (currentPage - 1) * 10;
        data.setData_Info((String) datas.get("Info"));
        data.setData_User((Integer) datas.get("UserId"));
        data.setData_Time((String) datas.get("Time"));
        List<Data> dataList = dataService.selectAllByPageAndCondition(begin, data);
        return dataList;
    }

    @PostMapping("/selectAllByPageAndConditionWithNull")
    public List<Data> selectAllByPageAndConditionWithNull(@RequestBody HashMap<String, Object> datas) {
        Data data = new Data();
        int currentPage = (Integer) datas.get("Page");
        int begin = (currentPage - 1) * 10;
        data.setData_Info((String) datas.get("Info"));
        data.setData_User((Integer) datas.get("UserId"));
        data.setData_Time((String) datas.get("Time"));
        List<Data> dataList = dataService.selectAllByPageAndConditionWithNull(begin, data);
        return dataList;
    }


    @PostMapping("/totalData")
    public Integer totalData(@RequestBody HashMap<String, Object> datas) {

        Data data = new Data();
        data.setData_Info((String) datas.get("Info"));
        data.setData_User((Integer) datas.get("UserId"));
        data.setData_Time((String) datas.get("Time"));
        int totalCount = this.dataService.totalData(data);
        return totalCount;
    }

    @PostMapping("/totalDataWithNull")
    public Integer totalDataWithNull(@RequestBody HashMap<String, Object> datas) {

        Data data = new Data();
        data.setData_Info((String) datas.get("Info"));
        data.setData_User((Integer) datas.get("UserId"));
        data.setData_Time((String) datas.get("Time"));
        int totalCount = this.dataService.totalDataWithNull(data);
        return totalCount;
    }


    @GetMapping("/totalByMonth/{start}/{end}")
    public int[] totalData(@PathVariable("start") String start, @PathVariable("end") String end) {

//        start=2022-12;
//        end=2023-03

        int countYear = Integer.parseInt(end.substring(0, 4)) - Integer.parseInt(start.substring(0, 4));
        int countMonth = Integer.parseInt(end.substring(5, 7)) - Integer.parseInt(start.substring(5, 7)) + countYear * 12 + 1;
        int[] sums = new int[countMonth];
        int j = 0;
        String StrStart = null;
        String StrEnd = null;
        String StrMonth = null;
        for (int i = Integer.parseInt(start.substring(5, 7)); i <= Integer.parseInt(start.substring(5, 7)) + countMonth; i++) {
            if (i <= 12) {
                if (i <= 9) {
                    StrMonth = "0" + i;
                } else {
                    StrMonth = String.valueOf(i);
                }
                StrStart = start.substring(0, 4) + "-" + StrMonth + "-01";
                StrEnd = start.substring(0, 4) + "-" + StrMonth + "-31";
                if (dataService.totalByMonth(StrStart, StrEnd) == null) {
                    sums[j] = 0;
                } else {
                    sums[j] = dataService.totalByMonth(StrStart, StrEnd);
                }
                if (j < countMonth - 1) {
                    j++;
                }
            } else {
                if (i - 12 <= 9 && i - 12 > 0) {
                    StrMonth = "0" + (i - 12);
                } else {
                    StrMonth = String.valueOf(i - 12);
                }
                StrStart = end.substring(0, 4) + "-" + StrMonth + "-01";
                StrEnd = end.substring(0, 4) + "-" + StrMonth + "-31";
                if (dataService.totalByMonth(StrStart, StrEnd) == null) {
                    sums[j] = 0;
                } else {
                    sums[j] = dataService.totalByMonth(StrStart, StrEnd);
                }
                if (j < countMonth - 1) {
                    j++;
                }
            }
        }
        return sums;
    }

    //        //假如month=1
//        String Month=null;
//        String start=null;
//        String end=null;
//        String iStr=null;
//        int sum=0;
//        int iMonth;
//        int[] sums = new int[12];
//        for(int i=0;i<=11;i++){
//            sum=0;
//            iMonth=i+1;
//            if(iMonth<=9){
//                Month="0"+ iMonth;
//            }else {
//                Month= String.valueOf(iMonth);
//            }
//            start=year+"-"+Month+"-01";
//            end=year+"-"+Month+"-31";
//            sum=dataService.totalByMonth(start,end);
//            sums[i]=sum;
//        }
//        return sums;
//    }
    @GetMapping("/totalByMonthById/{start}/{end}/{name}")
    public int[] totalDataById(@PathVariable("start") String start,
                               @PathVariable("end") String end,
                               @PathVariable("name") String name) {

//        start=2022-12;
//        end=2023-03
        int countYear = Integer.parseInt(end.substring(0, 4)) - Integer.parseInt(start.substring(0, 4));
        int countMonth = Integer.parseInt(end.substring(5, 7))
                - Integer.parseInt(start.substring(5, 7))
                + countYear * 12 + 1;
        int[] sums = new int[countMonth];
        int j = 0;
        String StrStart = null;
        String StrEnd = null;
        String StrMonth = null;
        for (int i = Integer.parseInt(start.substring(5, 7));
             i < Integer.parseInt(start.substring(5, 7)) + countMonth;
             i++) {
            if (i <= 12) {
                if (i <= 9) {
                    StrMonth = "0" + i;
                } else {
                    StrMonth = String.valueOf(i);
                }
                StrStart = start.substring(0, 4) + "-" + StrMonth + "-01";
                StrEnd = start.substring(0, 4) + "-" + StrMonth + "-31";
                if (dataService.totalByMonthById(StrStart, StrEnd, name) == null) {
                    sums[j] = 0;
                } else {
                    sums[j] = dataService.totalByMonthById(StrStart, StrEnd, name);
                }
                if (j < countMonth - 1) {
                    j++;
                }
            } else {
                if ((i - 12) <= 9 && i - 12 > 0) {
                    StrMonth = "0" + (i - 12);
                } else {
                    StrMonth = String.valueOf(i - 12);
                }
                StrStart = end.substring(0, 4) + "-" + StrMonth + "-01";
                StrEnd = end.substring(0, 4) + "-" + StrMonth + "-31";
                if (dataService.totalByMonthById(StrStart, StrEnd, name) == null) {
                    sums[j] = 0;
                } else {
                    sums[j] = dataService.totalByMonthById(StrStart, StrEnd, name);
                }
                if (j < countMonth - 1) {
                    j++;
                }
            }
        }
        for (int i = 0; i < countMonth; i++) {
            System.out.println(sums[i]);
        }
        return sums;
    }
}
