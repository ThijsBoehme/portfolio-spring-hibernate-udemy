package com.thijsboehme.springsecurity.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class LoginController {
    @GetMapping("/showMyLoginPage")
    fun showMyLoginPage(): String {
        return "plain-login"
    }
}
