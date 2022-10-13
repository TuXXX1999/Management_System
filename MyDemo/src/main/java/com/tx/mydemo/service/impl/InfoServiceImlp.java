package com.tx.mydemo.service.impl;

import com.tx.mydemo.domain.Info;
import com.tx.mydemo.mapper.InfoXmlMapper;
import com.tx.mydemo.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImlp implements InfoService {
//    private UserRepository userRepository;

//    private Integer limit = 10;

//    @Override
//    public UserVO findByPage(Integer page) {
//        Integer index = (page-1)*limit;
//        UserVO userVO = new UserVO();
//        userVO.setData(userRepository.find(index,limit));
//        userVO.setTotal(userRepository.count());
//        userVO.setPageSize(limit);
//        return userVO;
//    }

//    @Override
//    public Integer save(User user) {
//        return userRepository.save(user);
//    }
//
//    @Override
//    public Integer deleteById(Integer id) {
//        return userRepository.deleteById(id);
//    }
//
//    @Override
//    public User findById(Integer id) {
//        return userRepository.findById(id);
//    }
//
//    @Override
//    public Integer update(User user) {
//        return userRepository.update(user);
//    }

    //    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Autowired
    private InfoXmlMapper infoXmlService;

    @Override
    public List<Info> InfoList() {

        List<Info> infos = infoXmlService.selectAll();
        //4. 调用方法
        return infos;
    }

    @Override
    public int add(Info info) {
        return infoXmlService.add(info);
    }

    @Override
    public int deleteById(Integer id) {
        System.out.println(infoXmlService.deleteById(id));
        return infoXmlService.deleteById(id);
    }

    @Override
    public Info selectById(Integer id) {
        return infoXmlService.selectById(id);
    }

    @Override
    public int update(Info info) {
        return infoXmlService.update(info);
    }
    @Override
    public List<Info> selectAllByPageAndCondition(int begin,Info info){
        return infoXmlService.selectAllByPageAndCondition(begin,info);
    }

    @Override
    public List<Info> selectAllByPage(int begin) {
        return infoXmlService.selectAllByPage(begin);
    }

    @Override
    public int totalInfo(Info info){
        return infoXmlService.totalInfo(info);
    }


}
