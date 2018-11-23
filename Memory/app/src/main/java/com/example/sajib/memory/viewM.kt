package com.example.sajib.memory

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_view_m.*

class viewM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_m)
        val realm:Realm = Realm.getDefaultInstance()
        view(realm)
    }
    fun view(realm: Realm)
    {
        val dataList = realm.where(memory::class.java).findAll()
        dataList.forEach { titleV.append(" title :  ${it.titleM} " ) ; descV.append(" desc :  ${it.titleM} ")  }
    }
}
