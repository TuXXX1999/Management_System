package com.tx.mydemo.service;

import com.tx.mydemo.domain.Data;

import java.util.List;

public interface DataService {
    int add(Data data);

    int deleteById(Integer id);

    Data selectById(Integer id);

    int updateData(Data data);

    List<Data> selectAllByPage(int begin);

    List<Data> selectAllByPageAndCondition(int begin, Data data);

    int totalData(Data data);

    List<Data> selectAllByPageAndConditionWithNull(int begin, Data data);

    int totalDataWithNull(Data data);

    Integer totalByMonth(String start,String end);

    Integer totalByMonthById(String strStart, String strEnd, String name);
}
