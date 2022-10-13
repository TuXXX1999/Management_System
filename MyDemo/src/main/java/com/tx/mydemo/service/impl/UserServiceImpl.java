package com.tx.mydemo.service.impl;

import com.tx.mydemo.domain.User;
import com.tx.mydemo.mapper.UserXmlMapper;
import com.tx.mydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserXmlMapper userXmlService;


    @Override
    public User login(String username, String password) {

        return userXmlService.login(username, password);
    }

    @Override
    public int findUserId(String username) {
        return userXmlService.findUserId(username);
    }

    @Override
    public List<User> selectAllByPageAndCondition(int begin, User user) {
        return userXmlService.selectAllByPageAndCondition(begin,user);
    }

    @Override
    public int totalUser(User user) {
        return userXmlService.totalUser(user);
    }

    @Override
    public List<User> UserList() {
        return userXmlService.UserList();
    }

    @Override
    public User selectById(Integer id) {
        return userXmlService.selectById(id);
    }

    @Override
    public int updateUser(User user) {
        return userXmlService.updateUser(user);
    }
}
