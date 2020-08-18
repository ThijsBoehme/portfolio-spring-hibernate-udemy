package com.thijsboehme.springdemo.mvc

class Student {
    var firstName = ""
    var lastName = ""
    var country = ""
    var favouriteLanguage = ""
    var operatingSystems = arrayOf("")

    val countryOptions = LinkedHashMap<String, String>()

    init {
        countryOptions["BR"] = "Brazil"
        countryOptions["FR"] = "France"
        countryOptions["DE"] = "Germany"
        countryOptions["IN"] = "India"
        countryOptions["US"] = "United States of America"
    }
}
