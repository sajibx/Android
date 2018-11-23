package com.example.sajib.spinner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.sajib.spinner.R.id.del
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_data.*
import kotlinx.android.synthetic.main.activity_main.*

class Data : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        val realm: Realm = Realm.getDefaultInstance()


    }


/*

    fun delet(realm: Realm) {

        realm.beginTransaction()
        z = name2.text.toString()
        realm.where(Dates::class.java).equalTo("nam", z).findFirst()!!.deleteFromRealm()
        realm.commitTransaction()
    }
*/


}
