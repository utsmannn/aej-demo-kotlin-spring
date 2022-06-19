package com.aej.demo.database

import com.mongodb.client.MongoClient
import org.litote.kmongo.KMongo
import org.springframework.stereotype.Component

@Component
class DatabaseComponent {

    private val databaseURL = System.getenv("DATABASE_URL")

    init {
        println("database url ----> $databaseURL")
    }

    val database: MongoClient = KMongo.createClient(databaseURL)
}