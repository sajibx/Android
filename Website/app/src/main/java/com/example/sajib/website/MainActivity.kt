package com.example.sajib.website

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.lastIndexOf
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    var user = Array<String>(10){""}
    var firstname = Array<String>(10){""}
    var lastname = Array<String>(10){""}
    var userpass = Array<String>(10){""}
    var i:Int  = 0
    var j:Int = 0

    fun web(view: View)
    {
        val webs = view as Button
        when(webs.id)
        {
            login.id->
            {
                for (item in 0..i)
                {
                    if(user[i]==username.toString() && userpass[i]==passwords.toString())
                    {
                        j=i
                        startActivity(Intent(this, LoginActivity::class.java))
                    }
                }
            }
            signup.id->
            {
                startActivity(Intent(this, SignUpActivity::class.java))
            }
            forgot.id->
            {
                startActivity(Intent( this,ForgotActivity::class.java))
            }
        }
    }
}
