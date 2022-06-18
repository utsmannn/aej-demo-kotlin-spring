package com.aej.demo.user.repository

import com.aej.demo.database.DatabaseComponent
import com.aej.demo.user.entity.User
import com.mongodb.client.MongoCollection
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl : UserRepository {

    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

    private fun userCollection(): MongoCollection<User> =
        databaseComponent.database.getDatabase("user").getCollection()

    override fun getUserByName(name: String): User? {
        return userCollection().findOne(User::name eq name)
    }

    override fun getUsers(): List<User> {
        return userCollection().find().toList()
    }

    override fun addUser(name: String): List<User> {
        val newUser = User(name = name)
        val insert = userCollection().insertOne(newUser)
        return if (insert.wasAcknowledged()) {
            getUsers()
        } else {
            throw IllegalStateException("insert gagal")
        }
    }
}