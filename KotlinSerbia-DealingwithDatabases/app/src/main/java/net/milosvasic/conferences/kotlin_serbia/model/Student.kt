package net.milosvasic.conferences.kotlin_serbia.model


// Pay attention: Data class extends abstract class.
data class Student(val firstName: String, val lastName: String, val yearOfBirth: Int) : DbModel() {
    override var id: Long
        get() = id
        set(value) {
            id = value
        }
}