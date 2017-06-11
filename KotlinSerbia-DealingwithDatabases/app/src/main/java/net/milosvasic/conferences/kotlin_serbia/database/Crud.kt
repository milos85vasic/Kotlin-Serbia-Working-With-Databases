package net.milosvasic.conferences.kotlin_serbia.database


interface Crud<T> {

    fun insert(vararg what: T): Boolean

    fun select(vararg what: String): List<T>

    fun update(vararg what: T): Boolean

    fun delete(vararg what: T)

}