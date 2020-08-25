package com.thijsboehme.jackson.json.demo

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Student(
    var id: Int,
    var firstName: String,
    var lastName: String,
    var active: Boolean,
    var address: Address,
    var languages: Array<String>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Student

        if (id != other.id) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (active != other.active) return false
        if (address != other.address) return false
        if (!languages.contentEquals(other.languages)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + active.hashCode()
        result = 31 * result + address.hashCode()
        result = 31 * result + languages.contentHashCode()
        return result
    }
}
