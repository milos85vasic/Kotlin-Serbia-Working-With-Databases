package net.milosvasic.conferences.kotlin_serbia.common

import net.milosvasic.conferences.kotlin_serbia.model.Student


object Db : Crud<Student> {

    private val version = 1
    private val name = "students"
    private val dbHelper: DbHelper by lazy { DbHelper(name, version) }


    override fun insert(vararg what: Student): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insert(what: Collection<Student>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun select(vararg what: String): List<Student> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun select(what: Collection<String>): List<Student> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(vararg what: Student): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(what: Collection<Student>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(vararg what: Student) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(what: Collection<Student>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}