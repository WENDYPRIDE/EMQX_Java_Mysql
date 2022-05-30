package com.vote01.Service;

import com.vote01.Dao.User;
import com.vote01.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public List<User> queryUserList(){
        return userMapper.queryUserList();
    }
    public void addUser(User user){
        userMapper.addUser(user);
    }
}
