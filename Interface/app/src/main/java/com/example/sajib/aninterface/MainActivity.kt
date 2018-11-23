package com.example.sajib.aninterface

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun go(view: View){

        Log.e("Click Action ","Click Hoise")
        startActivity(Intent(this,Main2Activity::class.java))
    }
}
