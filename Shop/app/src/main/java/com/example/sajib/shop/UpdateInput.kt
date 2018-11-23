package com.example.sajib.shop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import io.realm.Realm
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_update_input.*

class UpdateInput : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_input)

        val realm = Realm.getDefaultInstance()

        updater(realm)
    }

    var positionNew: Int? = null
    var items: Array<String>? = null
    fun updater(realm: Realm)
    {

        items = arrayOf("type1", "type2", "type3", "type4")
        //Log.e("Data" , items.toString())
        var spinnerNew = findViewById<Spinner>(R.id.spinnerNew) //item names

        var spinnerAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items) // calling the spinner from system and Adapter

        spinnerNew?.adapter = spinnerAdapter   // since Adapet

        spinnerNew.onItemSelectedListener = object : AdapterView.OnItemSelectedListener  // calling the whole thing
        {
            override fun onNothingSelected(parent: AdapterView<*>?)
            {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, items: Int, id: Long)
            {
                positionNew = items
            }

        }

        updaterButton.setOnClickListener {

            var newNameData = newName.text.toString()
            var newPriceData = newPrice.text.toString()
            var newTypeData = items!![positionNew!!]
            var oldNameData = oldName.text.toString()
            //Log.e("Update Button Clicked", "".plus(oldNameData))

            realm.executeTransaction {
                var updaterValue = it.where(Data::class.java).equalTo("nameData", oldNameData).findFirst()

                updaterValue?.nameData = newNameData
                updaterValue?.priceData = newPriceData
                updaterValue?.typeData = newTypeData

                //Log.e("Old Data", updaterValue?.typeData.plus(" ").plus(updaterValue?.priceData))

            }
            //val updaterValue = realm.where(Data::class.java).equalTo("nameData", oldNameData).findFirst()
            //Log.e("New Data", updaterValue?.typeData.plus(" ").plus(updaterValue?.priceData))


        }

    }

}

