package com.tx.mydemo.service.impl;

import com.tx.mydemo.domain.Data;
import com.tx.mydemo.mapper.DataXmlMapper;
import com.tx.mydemo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private DataXmlMapper dataXmlService;


    @Override
    public int add(Data data) {
        return dataXmlService.add(data);
    }

    @Override
    public int deleteById(Integer id) {
        return dataXmlService.deleteById(id);
    }

    @Override
    public Data selectById(Integer id) {
        return dataXmlService.selectById(id);
    }

    @Override
    public int updateData(Data data) {
        return dataXmlService.updateData(data);
    }

    @Override
    public List<Data> selectAllByPage(int begin) {
        return dataXmlService.selectAllByPage(begin);
    }

    @Override
    public List<Data> selectAllByPageAndCondition(int begin, Data data) {
        return dataXmlService.selectAllByPageAndCondition( begin,  data);
    }

    @Override
    public int totalData(Data data) {
        return dataXmlService.totalData(data);
    }

    @Override
    public List<Data> selectAllByPageAndConditionWithNull(int begin, Data data) {
        return dataXmlService.selectAllByPageAndConditionWithNull( begin,  data);
    }

    @Override
    public int totalDataWithNull(Data data) {
        return dataXmlService.totalDataWithNull(data);
    }

    @Override
    public Integer totalByMonth(String start,String end) {
        return dataXmlService.totalByMonth(start,end);
    }

    @Override
    public Integer totalByMonthById(String strStart, String strEnd, String name) {
        return dataXmlService.totalByMonthById(strStart,strEnd,name);
    }

}
