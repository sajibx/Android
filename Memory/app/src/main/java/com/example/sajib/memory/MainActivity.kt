package com.example.sajib.memory

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val realm = Realm.getDefaultInstance()

        submitB.setOnClickListener()
        {
            val realm:Realm = Realm.getDefaultInstance()
            save(realm)
        }
        viewB.setOnClickListener()
        {
            val realm:Realm = Realm.getDefaultInstance()
            view(realm)
        }
    }

    fun save(realm: Realm)
    {
        realm.beginTransaction()
        val meme:memory = memory(title.toString(), desc.toString())
        realm.copyToRealm(meme)
        realm.commitTransaction()
    }

    fun view(realm: Realm)
    {
        startActivity(Intent(this,viewM::class.java))
    }

}
