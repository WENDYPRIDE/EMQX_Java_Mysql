package com.vote01.Controller;

import com.vote01.Dao.User;
import com.vote01.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class helloController {

    @Autowired
    private UserMapper userMapper;

    //参数可以为空
    @GetMapping("/test")
    public String hello(@RequestParam(name = "name", required = false) String name) {
        return "获取到的name是：" + name;
    }

    @PostMapping("/hello")
    public String hello(@RequestParam Map<String, Object> params) {
        return "id：" + params.get("id") +
                "\nname：" + params.get("name") +
                "\npassword：" + params.get("pwd");
    }

    @PostMapping("/add")
    public String add(@RequestParam Map<String, Object> params) {
//        User user = new User(id, name, password);
//        userMapper.addUser(user);
//        System.out.println("save====>" + user);
        System.out.println("save====>" + params);
        int id = Integer.parseInt(params.get("id").toString());
        String uname = params.get("uname").toString();
        String pwd = params.get("pwd").toString();
        User user = new User(id, uname, pwd);
        userMapper.addUser(user);
        System.out.println("save====>" + user);
        return "ok";
    }

}
