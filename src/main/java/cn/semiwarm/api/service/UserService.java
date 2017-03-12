package cn.semiwarm.api.service;


import cn.semiwarm.api.entity.User;

import java.util.List;

/**
 *  用户服务接口
 * Created by alibct on 2017/2/24.
 */
public interface UserService extends BaseService<User> {
    // 获取所有用户
    List<User> getAllUsers();
    // 根据手机号获取用户信息
    User getUserByPhone(String phone);
    // 根据用户名获取用户信息
    User getUserByName(String name);
    // 注册用户
    int signUp(User user);
}
