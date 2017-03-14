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
     * user_id：当前时间的Long类型
     * status：默认可用
     * user_level：默认1级
     *
     * @param user 用户信息
     * @return 结果信息
     */
    public String signUp(User user) {
        // 获取当前时间的Long类型
        Long userId = new Date().getTime();
        user.setUserId(userId);
        // 默认可用
        user.setStatus(true);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        // 等级默认1级
        userInfo.setUserLevel(1);
        if (userMapper.add(user) > 0 && userInfoMapper.add(userInfo) > 0) {
            return "注册成功！";
        }
        return "注册失败！";
    }
}
