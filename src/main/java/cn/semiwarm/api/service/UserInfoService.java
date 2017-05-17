package cn.semiwarm.api.service;

import cn.semiwarm.api.entity.BaseResponse;
import cn.semiwarm.api.entity.UserInfo;

import java.io.Serializable;

/**
 * UserInfoService
 * Created by alibct on 2017/5/17.
 */
public interface UserInfoService {
    // 根据用户id获取用户信息
    BaseResponse<UserInfo> getUserInfoById(Serializable id) throws Exception;

    // 根据用户id修改用户信息
    BaseResponse<UserInfo> updateUserInfo(UserInfo userInfo) throws Exception;
}
