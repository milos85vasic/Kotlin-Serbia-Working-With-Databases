package net.milosvasic.conferences.kotlin_serbia

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.milosvasic.conferences.kotlin_serbia.model.Student

abstract class BasicActivity : AppCompatActivity() {

    val tag = Application.tag

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        insert.setOnClickListener {
            Thread({
                val result = doInsert()
                val msg = "Insert [ $result ]"
                logResult(result, msg)
            }).start()
        }

        update.setOnClickListener {
            Thread({
                val result = doUpdate()
                val msg = "Update [ $result ]"
                logResult(result, msg)
            }).start()
        }

        delete.setOnClickListener {
            Thread({
                val result = doDelete()
                val msg = "Delete [ $result ]"
                logResult(result, msg)
            }).start()
        }

        select.setOnClickListener {
            Thread({
                val result = doSelect()
                Log.i(tag, "Select [ items: ${result.size} ]")
                result.forEach { student -> Log.v(tag, student.toString()) }
            }).start()
        }

        select_all.setOnClickListener {
            Thread({
                val result = doSelectAll()
                Log.i(tag, "Select All [ items: ${result.size} ]")
                result.forEach { student -> Log.v(tag, student.toString()) }
            }).start()
        }
    }

    abstract fun doInsert(): Boolean

    abstract fun doDelete(): Boolean

    abstract fun doUpdate(): Boolean

    abstract fun doSelect(): List<Student>

    abstract fun doSelectAll(): List<Student>

    private fun logResult(result: Boolean, msg: String) {
        if (result) {
            Log.i(tag, msg)
        } else {
            Log.w(tag, msg)
        }
    }

}


