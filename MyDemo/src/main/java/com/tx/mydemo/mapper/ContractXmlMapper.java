package com.tx.mydemo.mapper;

import com.tx.mydemo.domain.Contract;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ContractXmlMapper {

    List<Contract> selectAllByPageAndCondition(int begin, Contract contract);

    int totalContract(Contract contract);

    Contract selectById(Integer id);

    int updateContract(Contract contract);
}
