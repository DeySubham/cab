package com.example.cabdriver.entity;

import jakarta.persistence.*

@Entity
@Table(name = "driver", schema = "cab")
data class Driver(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,

    var name: String = "",

    var email: String = "",

    var password: String = ""
) {
    constructor(name: String, email: String, password: String) : this() {
        this.name = name
        this.email = email
        this.password = password
    }
}



