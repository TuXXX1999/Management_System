package com.tx.mydemo.controller;


import com.tx.mydemo.domain.Info;
import com.tx.mydemo.domain.User;
import com.tx.mydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/login/{username}/{password}")
    public String login(
            @PathVariable("username") String username,
            @PathVariable("password") String password) {
        User res = userService.login(username, password);
        if (res == null) {
            return "error";
        } else {
            String role = null;
            role = res.getRoles().getRole_Name();
            return role;
        }
    }

    @GetMapping("/findUserId/{username}")
    public int findUserId(@PathVariable("username") String username) {
//        System.out.println(username);
//        System.out.println(userService.findUserId(username));
        return userService.findUserId(username);
    }


    @PostMapping("/selectAllByPageAndCondition")
    public List<User> selectAllByPageAndCondition(@RequestBody HashMap<String, Object> datas) {
        User user = new User();
        int currentPage = (Integer) datas.get("Page");
        int begin = (currentPage - 1) * 10;
        user.setUser_Name((String) datas.get("Name"));
        user.setUser_Role(String.valueOf(datas.get("Type")));
        List<User> users = userService.selectAllByPageAndCondition(begin, user);
        return users;
    }


    @PostMapping("/totalUser")
    public Integer totalUser(@RequestBody HashMap<String, Object> datas) {

        User user = new User();
        user.setUser_Name((String) datas.get("Name"));
        user.setUser_Role(String.valueOf(datas.get("Type")));
        int totalCount = this.userService.totalUser(user);
        return totalCount;
    }
    @GetMapping("/selectAllUser")
    public String[] UserList() {


        List<User> users = userService.UserList();
        String[] name=new String[users.size()];
        for(int i=0;i<users.size();i++){
            name[i]= users.get(i).getUser_Name();
        }
        return name;
    }

    @GetMapping("/updateUser/{id}")
    public User selectById(@PathVariable("id") Integer id) {
        return userService.selectById(id);
    }


    @PostMapping("/updateUser")
    public int updateUser(@RequestBody User user) {
        if (userService.updateUser(user) >= 0) {
            return 1;
        } else {
            return 0;
        }
    }

}
