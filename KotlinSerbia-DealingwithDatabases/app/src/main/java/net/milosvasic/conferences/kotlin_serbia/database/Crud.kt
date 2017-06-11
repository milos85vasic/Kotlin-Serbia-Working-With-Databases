package net.milosvasic.conferences.kotlin_serbia.database


interface Crud<T> {

    fun insert(vararg what: T): Boolean

    fun insert(what: Collection<T>): Boolean

    fun select(vararg what: String): List<T>

    fun select(what: Collection<String>): List<T>

    fun update(vararg what: T): Boolean

    fun update(what: Collection<T>): Boolean

    fun delete(vararg what: T)

    fun delete(what: Collection<T>)

}