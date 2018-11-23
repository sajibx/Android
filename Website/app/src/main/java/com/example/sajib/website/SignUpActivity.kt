package com.example.sajib.website

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.util.*
import kotlin.coroutines.experimental.EmptyCoroutineContext

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }
    var p = MainActivity()
    fun web2(view: View)
    {
        val webs2 = view as Button
        when(webs2.id)
        {
            signup1.id->
            {
                p.firstname[p.i] = (fsname.toString())
                p.lastname[p.i] = (lsname.toString())
                p.userpass[p.i] = (password.toString())
                p.user[p.i] = (usname.toString())
                p.i = p.i+1
                //if(fsname != null && lsname != null && password != null && uname != null)
                //{
                    startActivity(Intent(this, MainActivity::class.java))
                //}
                //p.user.add(username.toString())
            }
        }
    }
}
