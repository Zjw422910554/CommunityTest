package com.nowcoder.community1.service;

import com.nowcoder.community1.dao.UserMapper;
import com.nowcoder.community1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by a4229 on 2021/2/1 14:59.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id){
        return userMapper.selectById(id);
    }


}
