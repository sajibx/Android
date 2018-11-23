package com.example.sajib.shop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_deletes_data.*

class DeletesData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deletes_data)
        DeletesData(realm)
    }
    val realm = Realm.getDefaultInstance()


    fun DeletesData(realm: Realm)
    {
        deleteButton2.setOnClickListener()
        {
            realm.beginTransaction()
            var new = itemName2.text.toString()
            realm.where(Data::class.java).equalTo("nameData", new).findFirst()?.deleteFromRealm()
            realm.commitTransaction()
            //Toast.makeText(this, "${realm.where(Data::class.java).findAll().size}", Toast.LENGTH_LONG).show()
        }

        deleteAll.setOnClickListener()
        {
            realm.beginTransaction()
            realm.where(Data::class.java).findAll()?.deleteAllFromRealm()
            realm.commitTransaction()
        }
    }
}
