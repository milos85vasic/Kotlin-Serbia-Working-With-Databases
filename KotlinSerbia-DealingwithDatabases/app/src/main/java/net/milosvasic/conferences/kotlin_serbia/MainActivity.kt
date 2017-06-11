package net.milosvasic.conferences.kotlin_serbia

import android.util.Log
import net.milosvasic.conferences.kotlin_serbia.common.Db
import net.milosvasic.conferences.kotlin_serbia.common.DbHelper
import net.milosvasic.conferences.kotlin_serbia.model.Student

class MainActivity : BasicActivity() {

    val students = mutableListOf<Student>()

    override fun doInsert(): Boolean {
        if (students.isEmpty()) {
            students.add(Student("Mihajlo", "Pupin", 1858))
            students.add(Student("Milutin", "Milanković", 1879))
            students.add(Student("Nikola", "Tesla", 1856))

            // INSERT:
            return Db.insert(students)
        }
        Log.w(tag, "We already added students.")
        return false
    }

    override fun doUpdate(): Boolean {
        if (students.isEmpty()) {
            Log.w(tag, "No students to update.")
            return false
        }

        val student0 = students[0]
        val student1 = students[1]
        student0.firstName = "CHANGED"
        student1.lastName = "CHANGED"

        // UPDATE:
        return Db.update(student0, student1)
    }

    override fun doDelete(): Boolean {
        // DELETE:
        val result = Db.delete(students)

        if (result) {
            students.clear()
        }
        return result
    }

    override fun doSelect(): List<Student> {
        // SELECT:
        return Db.select(Pair(DbHelper.FIRST_NAME, "Nikola"))
    }

    override fun doSelectAll(): List<Student> {
        // SELECT:
        return Db.select()
    }

}
