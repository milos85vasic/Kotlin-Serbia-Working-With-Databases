package net.milosvasic.conferences.kotlin_serbia.database


interface Crud<T> {

    fun insert(what: T): Boolean

    fun select(what: String): List<T>

    fun update(what: T): Boolean

    fun delete(what: T)

}