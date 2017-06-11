package net.milosvasic.conferences.kotlin_serbia.model

// Pay attention: Data class extends abstract class.
data class Student(
        val firstName: String,
        val lastName: String,
        val yearOfBirth: Int
) : DbModel() {
    override var id = 0L

    override fun toString(): String { // Pay attention: Multiline string.
        return """
                Student(
                        firstName='$firstName',
                        lastName='$lastName',
                        yearOfBirth=$yearOfBirth,
                        id=$id
                    )
               """
    }
}