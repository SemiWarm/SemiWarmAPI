package cn.semiwarm.api.service.impl;

import cn.semiwarm.api.entity.BaseResponse;
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

    public BaseResponse<List<User>> getAllUsers() {
        BaseResponse<List<User>> response = new BaseResponse<List<User>>();
        List<User> users = userMapper.findAll();
        if (users.size() > 0) {
            response.setSuccess(1);
            response.setMessage("用户列表");
            response.setData(users);
        } else {
            response.setSuccess(0);
            response.setMessage("没有数据");
            response.setData(null);
        }
        return response;
    }

    public BaseResponse<User> getUserByAccount(String userAccount) {
        BaseResponse<User> response = new BaseResponse<User>();
        User user = userMapper.findUserByAccount(userAccount);
        if (null != user) {
            response.setSuccess(1);
            response.setMessage("用户信息");
            response.setData(user);
        } else {
            response.setSuccess(0);
            response.setMessage("没有数据");
            response.setData(null);
        }
        return response;
    }

    public BaseResponse<User> getUserByName(String userName) {
        BaseResponse<User> response = new BaseResponse<User>();
        User user = userMapper.findUserByName(userName);
        if (null != user) {
            response.setSuccess(1);
            response.setMessage("用户信息");
            response.setData(user);
        } else {
            response.setSuccess(0);
            response.setMessage("没有数据");
            response.setData(null);
        }
        return response;
    }


    /**
     * 注册用户
     * 向User表插入数据后必须还要向UserInfo表插入数据
     * user_id：当前时间的Long类型
     * status：默认可用
     * user_level：默认1级
     *
     * @param user 注册用户
     * @return 通用响应
     */
    public BaseResponse<User> signUp(User user) {
        BaseResponse<User> userResponse = new BaseResponse<User>();
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
            userResponse.setSuccess(1);
            userResponse.setMessage("注册成功!");
            userResponse.setData(null);
        } else {
            userResponse.setSuccess(0);
            userResponse.setMessage("注册失败!");
            userResponse.setData(null);
        }
        return userResponse;
    }
}
