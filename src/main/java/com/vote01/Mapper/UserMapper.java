package com.vote01.Mapper;

import com.vote01.Dao.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> queryUserList();
    void addUser (User user);
    int updateUser(User user);
    int deleteUser(int id);
}
