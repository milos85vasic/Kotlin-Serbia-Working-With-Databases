package net.milosvasic.conferences.kotlin_serbia

import android.app.Application
import android.content.Context


class Application : Application() {

    companion object {
        var ctx: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        ctx = applicationContext
    }

}