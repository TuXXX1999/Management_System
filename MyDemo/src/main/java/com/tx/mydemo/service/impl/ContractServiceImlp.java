package com.tx.mydemo.service.impl;

import com.tx.mydemo.domain.Contract;
import com.tx.mydemo.mapper.ContractXmlMapper;
import com.tx.mydemo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContractServiceImlp implements ContractService {

    @Autowired
    private ContractXmlMapper contractXmlMapper;

    @Override
    public List<Contract> selectAllByPageAndCondition(int begin, Contract contract) {
        return contractXmlMapper.selectAllByPageAndCondition(begin,contract);
    }

    @Override
    public int totalContract(Contract contract) {
        return contractXmlMapper.totalContract(contract);
    }

    @Override
    public Contract selectById(Integer id) {
        return contractXmlMapper.selectById(id);
    }

    @Override
    public int updateContract(Contract contract) {
        return contractXmlMapper.updateContract(contract);
    }


}
