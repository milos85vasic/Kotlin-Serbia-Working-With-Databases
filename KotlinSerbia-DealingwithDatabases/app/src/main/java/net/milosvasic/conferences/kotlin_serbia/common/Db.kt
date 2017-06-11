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
                Log.v(tag, "Id assigned [ $id ]")
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

    override fun select(vararg args: Pair<String, String>): List<Student> {
        val result = mutableListOf<Student>()
        val selection = StringBuilder()
        val selectionArgs = mutableListOf<String>()
        args.forEach {
            arg ->
            selection.append("${arg.first} == ?")
            selectionArgs.add(arg.second)
        }
        val cursor = db.query(
                true,
                DbHelper.TABLE,
                arrayOf(DbHelper.ID, DbHelper.FIRST_NAME, DbHelper.LAST_NAME, DbHelper.YEAR),
                selection.toString(),
                selectionArgs.toTypedArray(),
                null, null, null, null
        )
        while (cursor.moveToNext()) {
            val firstName = cursor.getString(cursor.getColumnIndexOrThrow(DbHelper.FIRST_NAME))
            val lastName = cursor.getString(cursor.getColumnIndexOrThrow(DbHelper.LAST_NAME))
            val id = cursor.getLong(cursor.getColumnIndexOrThrow(DbHelper.ID))
            val year = cursor.getInt(cursor.getColumnIndexOrThrow(DbHelper.YEAR))
            val student = Student(
                    firstName,
                    lastName,
                    year
            )
            student.id = id
            result.add(student)
        }
        cursor.close()
        return result
    }

    override fun select(args: Collection<Pair<String, String>>): List<Student> {
        return select(*args.toTypedArray())
    }

    override fun update(vararg what: Student): Boolean {
        db.beginTransaction()
        var updated = 0
        what.forEach {
            item ->
            val values = ContentValues()
            values.put(DbHelper.FIRST_NAME, item.firstName)
            values.put(DbHelper.LAST_NAME, item.lastName)
            values.put(DbHelper.YEAR, item.yearOfBirth)
            db.update(
                    DbHelper.TABLE,
                    values,
                    "_id = ?",
                    arrayOf(item.id.toString())
            )
            updated++
        }
        val result = updated == what.size
        if (result) {
            db.setTransactionSuccessful()
        }
        db.endTransaction()
        return result
    }

    override fun update(what: Collection<Student>): Boolean {
        return update(*what.toTypedArray())
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
        val count = statement.executeUpdateDelete()
        val success = count > 0
        if (success) {
            db.setTransactionSuccessful()
            Log.i(tag, "Delete [ SUCCESS ][ $count ][ $statement ]")
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