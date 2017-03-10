package cn.semiwarm.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页请求
 * Created by alibct on 2017/3/1.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping(value = "/v1.0")
    public String index() {
        return "redirect:swagger-ui.html";
    }
}
