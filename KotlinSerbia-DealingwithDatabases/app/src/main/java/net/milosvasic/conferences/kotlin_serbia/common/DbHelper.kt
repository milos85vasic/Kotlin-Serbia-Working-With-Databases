package net.milosvasic.conferences.kotlin_serbia.common

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import net.milosvasic.conferences.kotlin_serbia.Application


class DbHelper(val dbName: String, val version: Int) : SQLiteOpenHelper(Application.ctx, dbName, null, version) {

    companion object {
        val ID: String = "_id"
        val FIRST_NAME: String = "FIRST_NAME"
        val LAST_NAME: String = "LAST_NAME"
        val YEAR: String = "YEAR"
        val SQL_CREATE_DB = "SQL_CREATE_DB"

        val queries = mapOf(
                Pair(
                        "SQL_CREATE_DB",
                        "CREATE TABLE if not exists students ($ID integer PRIMARY KEY autoincrement, $FIRST_NAME text, $LAST_NAME text, $YEAR integer)"
                )
        )
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(queries[SQL_CREATE_DB])
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Ingore for now.
    }

}