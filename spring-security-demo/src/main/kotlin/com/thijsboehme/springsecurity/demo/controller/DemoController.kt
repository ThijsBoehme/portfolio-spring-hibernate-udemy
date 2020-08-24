package com.thijsboehme.springsecurity.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class DemoController {
    @GetMapping("/")
    fun showHome(): String {
        return "home"
    }
}
