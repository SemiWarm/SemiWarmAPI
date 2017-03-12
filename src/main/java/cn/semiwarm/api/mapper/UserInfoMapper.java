package cn.semiwarm.api.mapper;

import cn.semiwarm.api.entity.UserInfo;

import java.io.Serializable;
import java.util.List;

/**
 * UserInfoMapper
 * Created by alibct on 2017/3/12.
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    int add(UserInfo userInfo);

    int delete(UserInfo userInfo);

    int update(UserInfo userInfo);

    UserInfo findById(Serializable id);

    List<UserInfo> findAll();
}
