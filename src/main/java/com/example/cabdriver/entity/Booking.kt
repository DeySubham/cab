package com.example.cabdriver.entity

import jakarta.persistence.*

@Entity
@Table(name = "booking", schema = "cab")
class Booking(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,

    var source: String = "",

    var destination: String = "",

    @ManyToOne
    var driver: Driver? = null,

    @ManyToOne
    var user: User? = null
) {
    constructor(source: String, destination: String) : this() {
        this.source = source
        this.destination = destination
    }
}