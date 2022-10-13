package com.tx.mydemo.service;

import com.tx.mydemo.domain.Info;
import com.tx.mydemo.domain.OverDate;
import com.tx.mydemo.domain.User;

import java.util.List;

public interface OverDateService {
//    public UserVO findByPage(Integer page);
//
//    public Integer save(User user);
//
//    public Integer deleteById(Integer id);
//
//    public User findById(Integer id);
//
//    public Integer update(User user);


    List<OverDate> overDatelist();

    int add(OverDate overDate);

    int deleteById(Integer id);

    OverDate selectById(Integer id);

    int update(OverDate overDate);

    List<OverDate> selectAllByPageAndCondition(int begin,OverDate overDate);


    int totalInfo(OverDate overDate);

    List<OverDate> selectAllByPage(int begin);

    int checkOverDate();
}
