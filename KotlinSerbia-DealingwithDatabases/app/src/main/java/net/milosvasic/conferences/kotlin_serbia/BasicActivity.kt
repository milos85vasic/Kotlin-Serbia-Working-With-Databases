package net.milosvasic.conferences.kotlin_serbia

import android.os.AsyncTask
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
            object : AsyncTask<Unit, Unit, Boolean>() {
                override fun doInBackground(vararg params: Unit?): Boolean {
                    return doInsert()
                }

                override fun onPostExecute(result: Boolean?) {
                    Log.i(tag, "Insert [ $result ]")
                    super.onPostExecute(result)
                }
            }.execute()
        }

        delete.setOnClickListener {
            object : AsyncTask<Unit, Unit, Boolean>() {
                override fun doInBackground(vararg params: Unit?): Boolean {
                    return doDelete()
                }

                override fun onPostExecute(result: Boolean?) {
                    Log.i(tag, "Delete [ $result ]")
                    super.onPostExecute(result)
                }
            }.execute()
        }

    }

    abstract fun doInsert(): Boolean

    abstract fun doDelete(): Boolean

}


