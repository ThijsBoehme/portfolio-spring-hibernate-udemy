package com.thijsboehme.springdemo.mvc

import javax.validation.constraints.*

class Customer {
    var firstName: String? = null

    // Validation does not actually work, don't know why
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    var lastName: String? = null

    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value = 10, message = "must be less than or equal to 10")
    var freePasses: Int? = null

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    var postalCode: String? = null
}
