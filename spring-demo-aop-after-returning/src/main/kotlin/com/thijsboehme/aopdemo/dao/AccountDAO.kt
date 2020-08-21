package com.thijsboehme.aopdemo.dao

import com.thijsboehme.aopdemo.Account
import org.springframework.stereotype.Component

@Component
class AccountDAO {
    var name: String = ""
        get() {
            println("$javaClass: in getName()")
            return field
        }
        set(value) {
            println("$javaClass: in setName()")
            field = value
        }

    var serviceCode: String = ""
        get() {
            println("$javaClass: in getServiceCode()")
            return field
        }
        set(value) {
            println("$javaClass: in setServiceCode()")
            field = value
        }

    fun addAccount(account: Account, vip: Boolean) {
        println("$javaClass: DOING MY DB WORK: ADDING AN ACCOUNT")
    }

    fun doWork(): Boolean {
        println("$javaClass: doWork()")
        return true
    }

    fun findAccounts(): List<Account> {
        return listOf(
            Account("John", "Silver"),
            Account("Madhu", "Platinum"),
            Account("Luca", "Gold")
        )
    }
}
