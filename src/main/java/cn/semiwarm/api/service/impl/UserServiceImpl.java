package cn.semiwarm.api.service.impl;

import cn.semiwarm.api.entity.User;
import cn.semiwarm.api.mapper.UserMapper;
import cn.semiwarm.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 用户服务具体实现类
 * Created by alibct on 2017/2/24.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    // 使用构造函数注入UserMapper接口

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> getAllUsers() {
        return userMapper.findAll();
    }

    public User getUserByPhone(String phone) {
        return userMapper.findUserByPhone(phone);
    }
}
