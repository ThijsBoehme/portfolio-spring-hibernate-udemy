package com.thijsboehme.springdemo.mvc

import org.springframework.beans.propertyeditors.StringTrimmerEditor
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import javax.validation.Valid

@Controller
@RequestMapping("/customer")
class CustomerController {
    @RequestMapping("/showForm")
    fun showForm(model: Model): String {
        model.addAttribute("customer", Customer())
        return "customer-form"
    }

    @RequestMapping("/processForm")
    fun processForm(
        @Valid @ModelAttribute("customer") customer: Customer,
        bindingResult: BindingResult
    ): String {

        println("Processing the request")
        println("customer: ${customer.firstName} ${customer.lastName}")
        println("bindingResult: $bindingResult")

        return if (bindingResult.hasErrors()) {
            "customer-form"
        } else {
            "customer-confirmation"
        }
    }

    @InitBinder
    fun initBinder(dataBinder: WebDataBinder) {
        val stringTrimmerEditor = StringTrimmerEditor(true)
        dataBinder.registerCustomEditor(String::class.java, stringTrimmerEditor)
    }
}
