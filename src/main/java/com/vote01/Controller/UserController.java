package com.vote01.Controller;

import com.vote01.Dao.User;
import com.vote01.Mapper.UserMapper;
import com.vote01.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    private UserMapper userMapper;
    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = userService.queryUserList();
        for (User user : userList){
            System.out.println(user);
        }
        return userList;
    }
    @GetMapping("addUser")
    public String addUser(){
        userMapper.addUser(new User(106,"amao","123456"));
        return "ok";
    }
    @GetMapping("updateUser")
    public String updateUser(){
        userMapper.updateUser(new User(106,"amao","000456"));
        return "ok";
    }
    @GetMapping("deleteUser")
    public String deleteUser(){
        userMapper.deleteUser(106);
        return "ok";
    }
    @PostMapping("addUser")
    public String addUser(User user){
        System.out.println("save====>"+user.toString());
        return "ok";
    }
}
