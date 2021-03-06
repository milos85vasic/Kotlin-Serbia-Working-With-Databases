package net.milosvasic.conferences.kotlin_serbia.common

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import net.milosvasic.conferences.kotlin_serbia.Application


class DbHelper(val dbName: String, val version: Int) : SQLiteOpenHelper(Application.ctx, dbName, null, version) {

    // Pay attention: Companion object.
    companion object {
        val ID: String = "_id"
        val FIRST_NAME: String = "FIRST_NAME"
        val LAST_NAME: String = "LAST_NAME"
        val YEAR: String = "YEAR"
        val TABLE = "students"
    }

    // Pay attention: Multiline string!
    private val createTable = """
                                    CREATE TABLE if not exists $TABLE
                                    (
                                        $ID integer PRIMARY KEY autoincrement,
                                        $FIRST_NAME text,
                                        $LAST_NAME text,
                                        $YEAR integer
                                    )
                              """

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(createTable)
        Log.d(Application.tag, "Database [ CREATED ]")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Ignore for now.
    }

}