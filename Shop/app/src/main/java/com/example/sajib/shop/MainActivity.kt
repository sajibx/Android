package com.example.sajib.shop

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.sajib.shop.R.id.deleteButton
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    var item:Array<String>? = null;
        var position:Int? = null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val realm = Realm.getDefaultInstance()
        item = arrayOf("type1","type2","type3","type4")
        initializeAction()
        interFace()
    }

    private fun initializeAction()
    {
        try {
            val item = arrayOf("type1","type2","type3","type4")

            val spinner = findViewById<Spinner>(R.id.spinner)

            val spinnerArrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, item)

            spinner?.adapter = spinnerArrayAdapter

            spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener
            {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, p: Int, id: Long) {
                            position = p
                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun interFace()
    {
        saveButton.setOnClickListener()
        {
            val realm = Realm.getDefaultInstance()
            saveData(realm)
        }
        deleteButton.setOnClickListener()
        {
            val realm = Realm.getDefaultInstance()
            deletesData(realm)
        }
        viewButton.setOnClickListener()
        {
            val realm = Realm.getDefaultInstance()
            viewData(realm)
        }
        updateButton.setOnClickListener()
        {
            val realm = Realm.getDefaultInstance()
            updateData(realm)
        }
    }

    fun saveData(realm: Realm)
    {
        var newValue = item!![this!!.position!!]

        realm.beginTransaction()
        val data:Data = Data(itemName.text.toString(),itemPrice.text.toString(),newValue)
        realm.copyToRealm(data)
        realm.commitTransaction()
        //startActivity(Intent(this, Display::class.java))

        //realm.commitTransaction()
        //Toast.makeText(this, "${realm.where(Data::class.java).findAll().size}", Toast.LENGTH_LONG).show()
        //val dataList = realm.where(Data::class.java).findAll()

    }

    fun deletesData(realm: Realm)
    {
        startActivity(Intent(this,DeletesData::class.java))
    }

    fun viewData(realm: Realm)
    {
        startActivity(Intent(this, Display::class.java))
    }

    fun updateData(realm: Realm)
    {
        startActivity(Intent(this,UpdateInput::class.java))
    }
}