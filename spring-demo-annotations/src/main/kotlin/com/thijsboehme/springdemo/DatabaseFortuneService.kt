package com.thijsboehme.springdemo

import org.springframework.stereotype.Component

@Component
class DatabaseFortuneService: FortuneService {
    override fun getFortune(): String {
        TODO("Not yet implemented")
    }
}
