package com.demo.biz.web.controller.page;

import com.demo.biz.web.controller.AppController;
import com.demo.service.security.SecurityUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Sawyer on 2017/1/17.
 */
@Controller
@RequestMapping(value = "/page/auth")
public class AuthPageController extends AppController {

    /**
     * 登录
     * Created by Sawyer on 2017/1/23.
     */
    @GetMapping(value = "/login")
    public String index() {
        if (SecurityUtil.isAuthenticated()) {
            return "home";
        }
        return "auth/login";
    }

    /**
     * 登录失败
     * Created by Sawyer on 2017/1/23.
     */
    @GetMapping("/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "auth/login";
    }

    /**
     * 注册
     * Created by Sawyer on 2017/1/23.
     */
    @GetMapping("/registry")
    public String registry() {
        if (SecurityUtil.isAuthenticated()) {
            return "home";
        }
        return "auth/registry";
    }
}
