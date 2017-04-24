package cn.semiwarm.api.service;


import cn.semiwarm.api.entity.BaseResponse;
import cn.semiwarm.api.entity.User;

import java.util.List;

/**
 *  用户服务接口
 * Created by alibct on 2017/2/24.
 */
public interface UserService extends BaseService<User> {
    // 获取所有用户
    BaseResponse<List<User>> getAllUsers();
    // 根据账号获取用户信息
    BaseResponse<User> getUserByAccount(String userAccount);
    // 根据用户名获取用户信息
    BaseResponse<User> getUserByName(String userName);
    // 注册用户
    BaseResponse<User> signUp(User user);
}
