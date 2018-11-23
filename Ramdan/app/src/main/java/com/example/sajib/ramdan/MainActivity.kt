package com.example.sajib.ramdan

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.time.Clock
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seheridate.setText("$day / $month / $year")
        iftardate.setText("$day / $month / $year")






        if (day >= 17 && day <= 31 && month == 5)
        {
            if (day == 17)
                seheritime.setText("03:51 am")
            else if (day >= 18 || day <= 19)
                seheritime.setText("03:50 am")
            else if (day == 20)
                seheritime.setText("03:49 am")
            else if (day >= 21 || day <= 22)
                seheritime.setText("03:48 am")
            else if (day >= 23 || day <= 24)
                seheritime.setText("03:47 am")
            else if (day >= 25 || day <= 27)
                seheritime.setText("03:46 am")
            else if (day >= 28 || day <= 30)
                seheritime.setText("03:45 am")
            else if (day == 31)
                seheritime.setText("03:44 am")
        }

        else if (day >= 1 && day <= 15 && month == 6)
        {
            if (day >= 1 || day <= 2)
                seheritime.setText("03:44 am")
            else if (day >= 3 || day <= 8)
                seheritime.setText("03:43 am")
            else if (day >= 9 || day < 15)
                seheritime.setText("03:42 am")
        }



        if (day >= 17 && day <= 31 && month == 5)
        {
            if (day == 17)
                iftartime.setText("06:35 pm")
            else if (day >= 18 || day <= 19)
                iftartime.setText("06:36 pm")
            else if (day >= 20 || day <= 21)
                iftartime.setText("06:37 pm")
            else if (day >= 22 || day <= 23)
                iftartime.setText("06:38 pm")
            else if (day >= 24 || day <= 25)
                iftartime.setText("06:39 pm")
            else if (day >= 26 || day <= 28)
                iftartime.setText("06:40 pm")
            else if (day >= 29 || day <= 30)
                iftartime.setText("06:41 pm")
            else if (day == 31)
                iftartime.setText("06:42 pm")
        }






    }
    //var year: Int = 0
    //var month: Int = 0
    //var day: Int = 0

    var day3:Int=0
    var month3:Int=0
    var year3:Int=0

    var p = Calendar.getInstance()
    var day = p.get(Calendar.DAY_OF_MONTH)
    var month = p.get(Calendar.MONTH)
    var year = p.get(Calendar.YEAR)
    var click = false




        fun button(view: View)
        {

            val but = view as Button
            when (but.id)
            {
                button.id ->
                {
                    val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { name, year, monthOfYear, dayOfMonth ->}, year, month, day)
                    dpd.show()
                    click = true
                }
            }
        }

    }
