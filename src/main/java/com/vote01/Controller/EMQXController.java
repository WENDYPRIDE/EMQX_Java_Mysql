package com.vote01.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.vote01.Dao.User;
import com.vote01.Mapper.UserMapper;
import com.vote01.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
public class EMQXController {
    @Autowired
    private UserService userService;
    @GetMapping("/queryAll")
    public List<User> queryAll(){
        List<User> userList = userService.queryUserList();
        for (User user : userList){
            System.out.println(user);
        }
        return userList;
    }
    @PostMapping("/quick3")
    public String quick3(HttpServletRequest request) {
        ServletInputStream is = null;
        try {
            is = request.getInputStream();
            StringBuilder sb = new StringBuilder();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = is.read(buf)) != -1) {
                sb.append(new String(buf, 0, len));
            }
            System.out.println("sb:"+sb.toString());
            //本机测试不过   broker测试通过
            String temp=sb.toString();
            System.out.println("temp:"+temp);
            JSONObject J=JSON.parseObject(temp);
            System.out.println("json:"+J);
            User user = J.toJavaObject(User.class);
            System.out.println("user:"+user);
            userService.addUser(user);
            System.out.println("Save===>:"+user);

            return "获取到的文本内容为：" + sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
//    @RequestMapping(value = "/quick1")
//    public void save1(HttpServletRequest request,
//                      HttpServletResponse response,
//                      HttpSession session) throws Exception {
//        System.out.println(request);
//        System.out.println(response);
//        System.out.println(session);
//    }
//
//    @PostMapping("/quick2")
//    public String quick2(@RequestBody Map params) {
//        return "id：" + params.get("id") +
//                "\nname：" + params.get("uname") +
//                "\npassword：" + params.get("pwd");
//    }


//    @PostMapping("/quick4")
//    public String quick4(HttpServletRequest request) {
//        String uname = request.getParameter("uname");
//        String pwd = request.getParameter("pwd");
//        int id = Integer.parseInt(request.getParameter("id"));
//        System.out.println(uname+","+pwd+","+id);
//        User user = new User(id, uname, pwd);
//        userMapper.addUser(user);
//        System.out.println("save====>" + user);
//        return "ok";
//    }
//    @PostMapping("/quick5")
//    public String quick5( @RequestBody JSONObject object) {
//        System.out.println("object"+object);
//        User user = object.getObject("user", User.class);
//
//        System.out.println(user);
//        return "ok";
//    }
}