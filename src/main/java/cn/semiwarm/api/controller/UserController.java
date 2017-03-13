package cn.semiwarm.api.controller;

import cn.semiwarm.api.entity.User;
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

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    /**
     * 获取用户列表
     * url:www.semiwarm.cn/api/v1.0/users
     *
     * @return 用户列表信息
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ApiOperation(value = "获取用户列表")
    public
    @ResponseBody
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * 根据手机号获取用户信息
     * url:www.semiwarm.cn/api/v1.0/users/phone/{phone}
     *
     * @param phone 手机号
     * @return 用户信息
     */
    @RequestMapping(value = "/users/phone/{phone}", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ApiOperation(value = "根据手机号获取用户信息")
    @ResponseBody
    User getUserByPhone(@PathVariable("phone") String phone) {
        return userService.getUserByPhone(phone);
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
    User getUserByName(@PathVariable("name") String name) {
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
    String signUp(@RequestBody User user) {
        return userService.signUp(user);
    }
}
