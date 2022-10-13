package com.tx.mydemo.service.impl;

import com.tx.mydemo.domain.Info;
import com.tx.mydemo.domain.OverDate;
import com.tx.mydemo.mapper.InfoXmlMapper;
import com.tx.mydemo.mapper.OverDateXmlMapper;
import com.tx.mydemo.service.OverDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OverDateServiceImlp implements OverDateService {
    //    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Autowired
    private OverDateXmlMapper overDateXmlService;

    @Override
    public List<OverDate> overDatelist() {

        List<OverDate> overDates = overDateXmlService.selectAll();
        //4. 调用方法
        return overDates;
    }

    @Override
    public int add(OverDate overDate) {
        return overDateXmlService.add(overDate);
    }

    @Override
    public int deleteById(Integer id) {
        System.out.println(overDateXmlService.deleteById(id));
        return overDateXmlService.deleteById(id);
    }

    @Override
    public OverDate selectById(Integer id) {
        return overDateXmlService.selectById(id);
    }

    @Override
    public int update(OverDate overDate) {
        return overDateXmlService.update(overDate);
    }
    @Override
    public List<OverDate> selectAllByPageAndCondition(int begin,OverDate overDate){
        return overDateXmlService.selectAllByPageAndCondition(begin,overDate);
    }

    @Override
    public List<OverDate> selectAllByPage(int begin) {
        return overDateXmlService.selectAllByPage(begin);
    }

    @Override
    public int checkOverDate() {
        return overDateXmlService.checkOverDate();
    }

    @Override
    public int totalInfo(OverDate overDate){
        return overDateXmlService.totalInfo(overDate);
    }


}
