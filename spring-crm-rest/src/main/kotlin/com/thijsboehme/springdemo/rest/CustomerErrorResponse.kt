package com.thijsboehme.springdemo.rest

class CustomerErrorResponse(
    var status: Int,
    var message: String,
    var timeStamp: Long
)
