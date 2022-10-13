package com.tx.mydemo.mapper;

import com.tx.mydemo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;


@Mapper
@Repository
public interface UserXmlMapper {

    User login(@Param("User_Name") String username, @Param("User_Pass") String password);
    int findUserId(String username);

    List<User> selectAllByPageAndCondition(int begin, User user);

    int totalUser(User user);

    List<User> UserList();

    User selectById(Integer id);

    int updateUser(User user);
}
