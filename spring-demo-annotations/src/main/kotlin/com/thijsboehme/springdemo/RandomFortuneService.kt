package com.thijsboehme.springdemo

import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class RandomFortuneService: FortuneService {
    private val data = arrayOf(
        "Beware of the wolf in sheep's clothing",
        "Diligence is the mother of good luck",
        "The journey is the reward"
    )

    override fun getFortune(): String {
        return data[Random.nextInt(data.size)]
    }
}
