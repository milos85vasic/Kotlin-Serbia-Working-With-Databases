package net.milosvasic.conferences.kotlin_serbia

import net.milosvasic.conferences.kotlin_serbia.common.Db
import net.milosvasic.conferences.kotlin_serbia.model.Student

class MainActivity : BasicActivity() {

    val john = Student("John", "Smith", 1985)
    val steve = Student("Steve", "Smith", 1987)

    override fun doInsert(): Boolean {
        return Db.insert(john, steve)
    }

    override fun doDelete(): Boolean {
        return Db.delete(steve)
    }

}
