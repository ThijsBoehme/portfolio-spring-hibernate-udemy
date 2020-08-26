package com.thijsboehme.springboot.thymeleafdemo.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.util.*

@Controller
class DemoController {
    @GetMapping("/hello")
    fun sayHello(model: Model): String {
        model.addAttribute("date", Date())
        return "hello-world"
    }
}
