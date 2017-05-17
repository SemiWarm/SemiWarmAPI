package cn.semiwarm.api.controller;

import cn.semiwarm.api.entity.BaseResponse;
import cn.semiwarm.api.entity.User;
import cn.semiwarm.api.entity.UserInfo;
import cn.semiwarm.api.service.impl.UserInfoServiceImpl;
import cn.semiwarm.api.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户前端控制器
 * Created by alibct on 2017/2/28.
 */
@Controller
@RequestMapping(value = "/v1.0")
public class UserController {

    private final UserServiceImpl userService;
    private final UserInfoServiceImpl userInfoService;

    @Autowired
    public UserController(UserServiceImpl userService, UserInfoServiceImpl userInfoService) {
        this.userService = userService;
        this.userInfoService = userInfoService;
    }

    /**
     * 获取用户列表
     * url:www.semiwarm.cn/api/v1.0/users
     *
     * @return 用户列表信息
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ApiOperation(value = "获取用户列表")
    @ResponseBody
    public BaseResponse<List<User>> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * 根据账号获取用户信息
     * url:www.semiwarm.cn/api/v1.0/users/account/{account}
     *
     * @param account 账号
     * @return 用户信息
     */
    @RequestMapping(value = "/users/account/{account}", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ApiOperation(value = "根据账号获取用户信息")
    @ResponseBody
    public BaseResponse<User> getUserByAccount(@PathVariable("account") String account) {
        return userService.getUserByAccount(account);
    }

    /**
     * 根据用户名获取用户信息
     * url:www.semiwarm.cn/api/v1.0/users/name/{name}
     *
     * @param name 用户名
     * @return 用户信息
     */
    @RequestMapping(value = "/users/name/{name}", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ApiOperation(value = "根据用户名获取用户信息")
    @ResponseBody
    public BaseResponse<User> getUserByName(@PathVariable("name") String name) {
        return userService.getUserByName(name);
    }

    /**
     * 注册用户
     * url:www.semiwarm.cn/api/v1.0/users
     *
     * @param user 用户信息
     * @return 受影响的行数
     */
    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    @ApiOperation(value = "注册用户")
    @ResponseBody
    public BaseResponse<User> signUp(@RequestBody User user) {
        return userService.signUp(user);
    }


    /**
     * 更新用户
     *
     * @param user 用户
     * @return 更新后的用户信息
     */
    @RequestMapping(value = "/update/user", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    @ApiOperation(value = "更新用户")
    @ResponseBody
    public BaseResponse<User> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    /**
     * 根据用户id获取用户信息
     *
     * @param userId 用户id
     * @return 用户信息
     * @throws Exception 异常
     */
    @RequestMapping(value = "/userId/{userId}/userInfo", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ApiOperation(value = "根据用户id获取用户信息")
    @ResponseBody
    public BaseResponse<UserInfo> getUserInfoById(@PathVariable("userId") Long userId) throws Exception {
        return userInfoService.getUserInfoById(userId);
    }

    /**
     * 更新用户信息
     *
     * @param userInfo 用户信息
     * @return 更新后的用户信息
     * @throws Exception 异常
     */
    @RequestMapping(value = "/update/userInfo", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    @ApiOperation(value = "更新用户信息")
    @ResponseBody
    public BaseResponse<UserInfo> updateUserInfo(@RequestBody UserInfo userInfo) throws Exception {
        return userInfoService.updateUserInfo(userInfo);
    }
}
