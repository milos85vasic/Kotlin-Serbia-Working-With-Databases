package net.milosvasic.conferences.kotlin_serbia.model


data class Student(
        val firstName: String,
        val lastName: String,
        val yearOfBirth: Int,
        val id: Long = 0
)