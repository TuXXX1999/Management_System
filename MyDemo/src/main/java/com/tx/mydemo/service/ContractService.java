package com.tx.mydemo.service;

import com.tx.mydemo.domain.Contract;
import com.tx.mydemo.domain.Info;

import java.util.List;

public interface ContractService {

    List<Contract> selectAllByPageAndCondition(int begin, Contract contract);

    int totalContract(Contract contract);

    Contract selectById(Integer id);

    int updateContract(Contract contract);
}

