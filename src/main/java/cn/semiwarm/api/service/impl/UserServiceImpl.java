package cn.semiwarm.api.service.impl;

import cn.semiwarm.api.entity.User;
import cn.semiwarm.api.entity.UserInfo;
import cn.semiwarm.api.mapper.UserInfoMapper;
import cn.semiwarm.api.mapper.UserMapper;
import cn.semiwarm.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * 用户服务具体实现类
 * Created by alibct on 2017/2/24.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    // 使用构造函数注入UserMapper接口

    private final UserMapper userMapper;

    private final UserInfoMapper userInfoMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserInfoMapper userInfoMapper) {
        this.userMapper = userMapper;
        this.userInfoMapper = userInfoMapper;
    }

    public List<User> getAllUsers() {
        return userMapper.findAll();
    }

    public User getUserByPhone(String userPhone) {
        return userMapper.findUserByPhone(userPhone);
    }

    public User getUserByName(String userName) {
        return userMapper.findUserByName(userName);
    }

    /**
     * 注册用户
     * 向User表插入数据后必须还要向UserInfo表插入数据
     *
     * @param user 用户信息
     * @return 受影响的行数
     */
    public int signUp(User user) {
        Long userId = new Date().getTime();
        user.setUserId(userId);
        user.setStatus(true);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfoMapper.add(userInfo);
        return userMapper.add(user);
    }
}
