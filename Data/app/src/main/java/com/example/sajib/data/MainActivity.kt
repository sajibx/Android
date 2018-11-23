package com.example.sajib.data


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import io.realm.Realm
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_application.*
import kotlinx.android.synthetic.main.activity_main.*
import smartfreez.mm.com.realm.ApplicationActivity

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initActions()
    }

    fun initActions() {
        val realm = Realm.getDefaultInstance()


        saveB.setOnClickListener {
            saveData(realm)
        }

        delB.setOnClickListener {
            startActivity(Intent(this, ApplicationActivity::class.java))
        }


    }

    fun saveData(realm: Realm)
    {
        try {
            realm.beginTransaction()

            var us = user.text.toString()
            var pa = passs.text.toString()
            var id = realm.where(User::class.java).count()
            id++
            val user: User = User(us, pa)

            realm.copyToRealm(user)

            realm.commitTransaction()

            Toast.makeText(this, "${realm.where(User::class.java).findAll().size}", Toast.LENGTH_LONG).show()

            val userList = realm.where(User::class.java).findAll()


            userList.forEach {

                Log.e(" USer Details" , "Name : " +it.names+ "  Pass: " + it.pass)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}
