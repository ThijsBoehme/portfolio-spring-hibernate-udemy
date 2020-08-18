package com.thijsboehme.springdemo

class HappyFortuneService : FortuneService {
    override fun getFortune(): String {
        return "Today is your lucky day!"
    }
}
