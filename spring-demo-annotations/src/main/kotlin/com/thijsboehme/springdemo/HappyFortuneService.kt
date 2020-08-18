package com.thijsboehme.springdemo

import org.springframework.stereotype.Component

@Component
class HappyFortuneService: FortuneService {
    override fun getFortune(): String {
        return "Today is your lucky day!"
    }
}
