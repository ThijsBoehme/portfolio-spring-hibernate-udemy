package com.thijsboehme.springdemo.mvc.validation

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class CourseCodeConstraintValidator: ConstraintValidator<CourseCode, String> {
    private lateinit var coursePrefix: String

    override fun initialize(constraintAnnotation: CourseCode?) {
        super.initialize(constraintAnnotation)
        if (constraintAnnotation != null) {
            coursePrefix = constraintAnnotation.value
        }
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return value?.startsWith(coursePrefix) ?: false
    }
}
