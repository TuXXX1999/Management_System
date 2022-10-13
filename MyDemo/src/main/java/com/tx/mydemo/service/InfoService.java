package com.tx.mydemo.service;

import com.tx.mydemo.domain.Info;
import com.tx.mydemo.domain.User;

import java.util.List;

public interface InfoService {
//    public UserVO findByPage(Integer page);
//
//    public Integer save(User user);
//
//    public Integer deleteById(Integer id);
//
//    public User findById(Integer id);
//
//    public Integer update(User user);


    List<Info> InfoList();

    int add(Info info);

    int deleteById(Integer id);

    Info selectById(Integer id);

    int update(Info info);

    List<Info> selectAllByPageAndCondition(int begin,Info info);


    int totalInfo(Info info);

    List<Info> selectAllByPage(int begin);

}
