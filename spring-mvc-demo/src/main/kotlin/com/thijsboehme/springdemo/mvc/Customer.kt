package com.thijsboehme.springdemo.mvc

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class Customer {
    var firstName: String? = null

    // Validation does not actually work, don't know why
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    var lastName: String? = null
}
