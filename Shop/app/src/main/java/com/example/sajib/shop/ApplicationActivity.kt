package com.example.sajib.shop

import android.app.Application
import io.realm.Realm

class ApplicationActivity : Application()
{

    override fun onCreate()
    {
        super.onCreate()
        Realm.init(applicationContext)
    }
}

