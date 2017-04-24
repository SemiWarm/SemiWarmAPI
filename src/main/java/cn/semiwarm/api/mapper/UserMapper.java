package cn.semiwarm.api.mapper;

import cn.semiwarm.api.entity.User;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * 描述：User表的基本查询接口
 *
 * Created by alibct on 2017/2/23.
 */
public interface UserMapper extends BaseMapper<User> {
    int add(User user);

    int delete(User user);

    int update(User user);

    User findById(Serializable id);

    List<User> findAll();


    // 根据账号查询用户
    User findUserByAccount(Serializable userAccount);

    // 根据用户名称查询用户
    User findUserByName(Serializable userName);

    // 根据用户名验证
    User verifyUserByName(HashMap hashMap);

    // 根据账号验证
    User verifyUserByAccount(HashMap hashMap);
}
