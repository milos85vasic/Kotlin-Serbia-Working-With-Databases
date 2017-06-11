package net.milosvasic.conferences.kotlin_serbia.model

// Pay attention: Data class extends abstract class.
data class Student(
        var firstName: String,
        var lastName: String,
        var yearOfBirth: Int
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