package com.thijsboehme.springdemo

class SadFortuneService: FortuneService {
    override fun getFortune(): String {
        return "Today is a sad day"
    }
}
