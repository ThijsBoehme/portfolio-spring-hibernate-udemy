package com.thijsboehme.springdemo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
//@ComponentScan("com.thijsboehme.springdemo")
@PropertySource("classpath:sport.properties")
class SportConfig {
    @Bean
    fun sadFortuneService(): FortuneService {
        return SadFortuneService()
    }

    @Bean
    fun swimCoach(): Coach {
        return SwimCoach(sadFortuneService())
    }
}
