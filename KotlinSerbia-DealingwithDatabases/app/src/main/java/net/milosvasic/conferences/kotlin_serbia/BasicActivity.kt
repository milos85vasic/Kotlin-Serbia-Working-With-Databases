package net.milosvasic.conferences.kotlin_serbia

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

abstract class BasicActivity : AppCompatActivity() {

    val tag = Application.tag

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        insert.setOnClickListener {
            Thread({
                val result = doInsert()
                Log.i(tag, "Insert [ $result ]")
            }).start()
        }

        delete.setOnClickListener {
            Thread({
                val result = doDelete()
                Log.i(tag, "Delete [ $result ]")
            }).start()
        }

    }

    abstract fun doInsert(): Boolean

    abstract fun doDelete(): Boolean

}


