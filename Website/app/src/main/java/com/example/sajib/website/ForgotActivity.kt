package com.example.sajib.website

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_forgot.*

class ForgotActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)
    }

    var q = MainActivity()
    fun web3(view:View)
    {
        val webs3 = view as Button

            when (webs3.id)
            {
                reset.id ->
                {
                    for (item in 0..q.i)
                    {
                        if(usernamereset.toString() == q.user[q.i])
                        {
                            q.userpass[q.i] = "123"
                            startActivity(Intent(this,MainActivity::class.java))
                            Log.e("Click Action ","password updated to 123")
                        }
                        else
                            Log.e("Click Action ","username not found")
                    }
                }
            }

    }
}
