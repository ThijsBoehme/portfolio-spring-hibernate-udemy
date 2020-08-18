package com.thijsboehme.springdemo.mvc

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class SillyController {
    @RequestMapping("/showForm")
    fun displayTheForm(): String {
        return "silly"
    }
}
