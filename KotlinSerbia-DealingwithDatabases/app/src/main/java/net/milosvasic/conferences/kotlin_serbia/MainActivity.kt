package net.milosvasic.conferences.kotlin_serbia

import net.milosvasic.conferences.kotlin_serbia.common.Db
import net.milosvasic.conferences.kotlin_serbia.common.DbHelper
import net.milosvasic.conferences.kotlin_serbia.model.Student

class MainActivity : BasicActivity() {

    val students = mutableListOf<Student>()

    override fun doInsert(): Boolean {
        students.add(Student("John", "Smith", 1985))
        students.add(Student("Steve", "Smith", 1987))
        return Db.insert(students)
    }

    override fun doDelete(): Boolean {
        return Db.delete(students.filter { (firstName) -> firstName == "Steve" }) // Pay attention: Filter applied.
    }

    override fun doSelect(): List<Student> {
        return Db.select(Pair(DbHelper.FIRST_NAME, "Steve"))
    }

}
