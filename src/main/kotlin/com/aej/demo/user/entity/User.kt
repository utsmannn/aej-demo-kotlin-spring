package com.aej.demo.user.entity

import java.util.*

data class User(
    var id: String = UUID.randomUUID().toString(),
    var name: String = "nama"
)