package com.demo.biz.web.controller.page;

import com.demo.biz.web.controller.AppController;
import com.demo.service.security.SecurityUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class IndexPageController extends AppController {

    @GetMapping(value = {"/", "/home"})
    public String home(Model model) {
        model.addAttribute("isAuthenticated", SecurityUtil.isAuthenticated());
        if (SecurityUtil.getCurrentAccount() != null) {
            model.addAttribute("phone", SecurityUtil.getCurrentAccount().getPhone());
            model.addAttribute("accountId", SecurityUtil.getCurrentAccountId());
        } else {
            model.addAttribute("phone", "未登录信息无法获取");
            model.addAttribute("accountId", "未登录信息无法获取");
        }
        return "home";
    }

    @GetMapping(value = "/authFailure")
    public String authFailure() {
        return "auth/authFailure";
    }
}
