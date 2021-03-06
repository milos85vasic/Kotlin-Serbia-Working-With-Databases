package net.milosvasic.conferences.kotlin_serbia.common


interface Crud<T> {

    fun insert(vararg what: T): Boolean

    fun insert(what: Collection<T>): Boolean

    fun select(vararg args: Pair<String, String>): List<T>

    fun select(args: Collection<Pair<String, String>>): List<T>

    fun update(vararg what: T): Boolean

    fun update(what: Collection<T>): Boolean

    fun delete(vararg what: T) : Boolean

    fun delete(what: Collection<T>) : Boolean

}