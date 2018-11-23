package com.example.sajib.shop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_display.*

class Display : AppCompatActivity() {
    val realm = Realm.getDefaultInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        Display(realm)
    }



    fun Display(realm: Realm)
    {
        val dataList = realm.where(Data::class.java).findAll()
        dataList.forEach {

            //var letter = "${it.nameData} , ${it.priceData} , ${it.typeData}"
            //displayView.text = "${it.nameData} , ${it.priceData} , ${it.typeData}"

            displayView.append("    Name: ${it.nameData} : Price ${it.priceData} : Type ${it.typeData} \n\n")
        }
    }
}
