package com.thijsboehme.springdemo.mvc

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import javax.servlet.http.HttpServletRequest

@Controller
@RequestMapping("/hello")
class HelloWorldController {
    // Controller method to show the HTML form
    @RequestMapping("/showForm")
    fun showForm(): String {
        return "helloWorld-form"
    }

    // Controller method to process the HTML form
    @RequestMapping("/processForm")
    fun processForm(): String {
        return "helloworld"
    }

    // Controller method to read new form data and add data to the model
    @RequestMapping("/processFormVersionTwo")
    fun letsShoutDude(request: HttpServletRequest, model: Model): String {
        var name = request.getParameter("studentName")
        name = name.toUpperCase()
        val result = "Yo! $name"
        model.addAttribute("message", result)
        return "helloworld"
    }

    @RequestMapping("/processFormVersionThree")
    fun processFormVersionThree(@RequestParam("studentName") name: String, model: Model): String {
        val uppercaseName = name.toUpperCase()
        val result = "Hey my friend $uppercaseName from v3!"
        model.addAttribute("message", result)
        return "helloworld"
    }
}
