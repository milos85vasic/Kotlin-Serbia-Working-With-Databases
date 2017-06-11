package net.milosvasic.conferences.kotlin_serbia.common

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import net.milosvasic.conferences.kotlin_serbia.Application
import net.milosvasic.conferences.kotlin_serbia.model.Student


object Db : Crud<Student> {

    private val version = 1
    private val name = "students"
    private val tag = Application.tag
    private val db: SQLiteDatabase by lazy { DbHelper(name, version).writableDatabase } // Pay attention: Lazy initialization

    override fun insert(vararg what: Student): Boolean {
        db.beginTransaction()
        var inserted = 0
        for (item in what) {
            val values = ContentValues()
            values.put(DbHelper.FIRST_NAME, item.firstName)
            values.put(DbHelper.LAST_NAME, item.lastName)
            values.put(DbHelper.YEAR, item.yearOfBirth)
            val id = db.insert(DbHelper.TABLE, null, values)
            if (id > 0) {
                item.id = id
                inserted++
            } else {
                break
            }
        }
        val success = inserted == what.size
        if (success) {
            db.setTransactionSuccessful()
        }
        db.endTransaction()
        return success
    }

    override fun insert(what: Collection<Student>): Boolean {
        return insert(*what.toTypedArray()) // Pay attention: Spread Operator
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

    override fun delete(vararg what: Student): Boolean {
        db.beginTransaction()
        val ids = StringBuilder()
        what.forEachIndexed {
            index, item ->
            ids.append(item.id.toString())
            if (index < what.lastIndex) {
                ids.append(", ")
            }
        }
        val statement = db.compileStatement(
                "DELETE FROM ${DbHelper.TABLE} WHERE ${DbHelper.ID} IN ($ids);"
        )
        val success = statement.executeUpdateDelete() > 0
        if (success) {
            db.setTransactionSuccessful()
            Log.i(tag, "Delete [ SUCCESS ][ $statement ]")
        } else {
            Log.w(tag, "Delete [ FAILED ][ $statement ]")
        }
        db.endTransaction()
        return success
    }

    override fun delete(what: Collection<Student>): Boolean {
        return delete(*what.toTypedArray()) // Pay attention: Spread Operator
    }

}