package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    /**
     * ログイン画面に遷移するコントローラー。
     */
    @RequestMapping("loginForm")
    public String loginPage() {
        // src/main/resources/templates/login.htmlに遷移させる
        return "loginForm";
    }
}
