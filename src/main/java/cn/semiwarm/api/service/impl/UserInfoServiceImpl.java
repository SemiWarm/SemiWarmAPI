package cn.semiwarm.api.service.impl;

import cn.semiwarm.api.entity.BaseResponse;
import cn.semiwarm.api.entity.UserInfo;
import cn.semiwarm.api.mapper.UserInfoMapper;
import cn.semiwarm.api.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * UserInfoServiceImpl
 * Created by alibct on 2017/5/17.
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoMapper userInfoMapper;

    @Autowired
    public UserInfoServiceImpl(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }


    public BaseResponse<UserInfo> getUserInfoById(Serializable id) throws Exception {
        BaseResponse<UserInfo> response = new BaseResponse<UserInfo>();
        UserInfo userInfo = userInfoMapper.findById(id);
        if (null != userInfo) {
            response.setSuccess(1);
            response.setMessage("用户信息");
            response.setData(userInfo);
        } else {
            response.setSuccess(0);
            response.setMessage("没有数据");
            response.setData(null);
        }
        return response;
    }

    public BaseResponse<UserInfo> updateUserInfo(UserInfo userInfo) throws Exception {
        BaseResponse<UserInfo> response = new BaseResponse<UserInfo>();
        int result = userInfoMapper.update(userInfo);
        if (result > 0) {
            response.setSuccess(1);
            response.setMessage("更新成功");
            response.setData(userInfoMapper.findById(userInfo.getUserId()));
        } else {
            response.setSuccess(0);
            response.setMessage("更新失败");
            response.setData(null);
        }
        return response;
    }
}
