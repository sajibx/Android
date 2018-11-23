package com.example.sajib.spinner

import android.bluetooth.le.AdvertiseData
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.*
import io.realm.Realm
import io.realm.RealmObject
import kotlinx.android.synthetic.main.activity_main.*

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        start()
    }

    fun start() {
        var realm = Realm.getDefaultInstance()

        val item = arrayOf("fruit", "vegetable", "drink", "baked")

        val spinner = findViewById<Spinner>(R.id.spinner)

        var selecteItemType = ""
        if (spinner != null)
        {
            val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, item)
            spinner.adapter = arrayAdapter as SpinnerAdapter?


            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener
            {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long)
                {
                    Log.e("From Speenir", item[position])

                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Code to perform some action when nothing is selected
                }
            }
        }

        inp.setOnClickListener {
            val price = price.text.toString()
            val name = name.text.toString()
            realm.beginTransaction()
            val dates: Dates = Dates(name, price.toInt(), selecteItemType)
            realm.copyToRealm(dates)
            realm.commitTransaction()

            Toast.makeText(this, "Hoise ", Toast.LENGTH_LONG).show()

        }

        del.setOnClickListener()
        {
            startActivity(Intent(this, Data::class.java))
        }
    }

}

open class Dates(var dateName: String? = null, var datePrice: Int? = null, var dateType: String? = null) : RealmObject()
