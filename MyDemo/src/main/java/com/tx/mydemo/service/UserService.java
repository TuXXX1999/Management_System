package com.tx.mydemo.service;

import com.tx.mydemo.domain.User;

import java.util.List;

public interface UserService {
    User login(String username,String password);
    int findUserId(String username);

    List<User> selectAllByPageAndCondition(int begin, User user);

    int totalUser(User user);

    List<User> UserList();

    User selectById(Integer id);

    int updateUser(User user);
}
