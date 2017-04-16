package com.demo.biz.web.controller.page;

import com.demo.biz.web.controller.AppController;
import com.demo.common.enums.AccountType;
import com.demo.service.security.SecurityUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Sawyer on 2017/1/17.
 */
@Controller
@RequestMapping(value = "/")
public class IndexPageController extends AppController {

    @GetMapping(value = {"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping(value = "/agent")
    public String agentIndex() {
        return "agent/index";
    }

    @GetMapping(value = "/admin")
    public String adminIndex() {
        return "admin/index";
    }

    @GetMapping(value = "/vendor")
    public String vendorIndex() {
        return "vendor/index";
    }

    @GetMapping(value = "/authFailure")
    public String authFailure() {
        return "auth/authFailure";
    }

    /**
     * 测试securityUtil
     * Created by Sawyer on 2017/1/19.
     */
    @GetMapping(value = "test")
    public String test(Model model) {
        model.addAttribute("isAuthenticated", SecurityUtil.isAuthenticated());
        if (SecurityUtil.getCurrentAccount() != null) {
            model.addAttribute("phone", SecurityUtil.getCurrentAccount().getPhone());
            model.addAttribute("accountId", SecurityUtil.getCurrentAccountId());
        } else {
            model.addAttribute("phone", "未登录信息无法获取");
            model.addAttribute("accountId", "未登录信息无法获取");
        }
        model.addAttribute("isAdmin", SecurityUtil.isThisRoleAuthenticated(AccountType.ADMIN));
        model.addAttribute("isVendor", SecurityUtil.isThisRoleAuthenticated(AccountType.VENDOR));
        model.addAttribute("isAgent", SecurityUtil.isThisRoleAuthenticated(AccountType.AGENT));
        if (SecurityUtil.isThisRoleAuthenticated(AccountType.ADMIN)) {
            model.addAttribute("adminName", SecurityUtil.getCurrentAdmin().getName());
        }
        return "test/security";
    }
}
