package com.example.cabdriver.entity

import jakarta.persistence.*

@Entity
data class User(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,

    var name: String = "",

    var email: String = ""
) {
    constructor(name: String, email: String) : this() {
        this.name = name
        this.email = email
    }
}
