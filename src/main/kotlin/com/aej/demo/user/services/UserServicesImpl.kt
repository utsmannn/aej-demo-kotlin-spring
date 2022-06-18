package com.aej.demo.user.services

import com.aej.demo.user.entity.User
import com.aej.demo.user.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServicesImpl : UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    override fun getUserByName(name: String): User? {
        return userRepository.getUserByName(name)
    }

    override fun getUsers(): List<User> {
        return userRepository.getUsers()
    }

    override fun addUser(user: User): List<User> {
        return userRepository.addUser(user.name)
    }

    override fun getIds(): List<String> {
        return userRepository.getUsers().map { it.id }
    }
}