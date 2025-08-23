package com.learning.spring_boot_learning.database.repository

import com.learning.spring_boot_learning.database.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User, String> {
    fun findByEmail(email: String): User?
}