package com.tx.mydemo.controller;


import com.tx.mydemo.domain.Contract;
import com.tx.mydemo.domain.Data;
import com.tx.mydemo.domain.Info;
import com.tx.mydemo.service.ContractService;
import com.tx.mydemo.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @PostMapping("/selectAllByPageAndCondition")
    public List<Contract> selectAllByPageAndCondition(@RequestBody HashMap<String, Object> datas) {
        Contract contract = new Contract();
        int currentPage = (Integer) datas.get("Page");
        int begin = (currentPage - 1) * 10;
//可能会有起始时间
        contract.setContract_Start((String) datas.get("Start"));
        contract.setContract_End((String) datas.get("End"));
        String state = (String) datas.get("State");
        if (state != null) {
            if (state.equals("0")) {
                state = "已结算";
            } else if (state.equals("1")) {
                state = "未结算";
            }
        }

        contract.setContract_State(state);
        List<Contract> contracts = contractService.selectAllByPageAndCondition(begin, contract);
        return contracts;
    }


    @PostMapping("/totalContract")
    public Integer totalContract(@RequestBody HashMap<String, Object> datas) {
        Contract contract = new Contract();
        contract.setContract_Start((String) datas.get("Start"));
        contract.setContract_End((String) datas.get("End"));
        String state = (String) datas.get("State");
        if (state != null) {
            if (state.equals("0")) {
                state = "已结算";
            } else if (state.equals("1")) {
                state = "未结算";
            }
        }

        contract.setContract_State(state);
        int totalCount = this.contractService.totalContract(contract);
        return totalCount;
    }


    @GetMapping("/selectById/{id}")
    public Contract selectById(@PathVariable("id") int id) {
        return contractService.selectById(id);
    }



    @PostMapping("/updateContract")
    public int updateContract(@RequestBody Contract contract) {
        if (contractService.updateContract(contract) >= 0) {
            return 1;
        } else {
            return 0;
        }
    }

}
