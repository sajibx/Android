package com.example.sajib.website

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
    var r = MainActivity()

    fun lay()
    {
        fname.setText(r.firstname[r.j].toString())
        lname.setText(r.lastname[r.j].toString())
        usernamedisplay.setText(r.user[r.j])
    }
    fun web3(view: View)
    {
        val webs3 = view as Button
        when(webs3.id)
        {
            logout.id->
            {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }
}
