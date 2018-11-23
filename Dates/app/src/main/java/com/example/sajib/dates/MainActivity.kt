package com.example.sajib.dates

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import javax.xml.datatype.DatatypeConstants.MONTHS

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



        fun very(view:View)
        {
            val dp = view as Button
            when(dp.id)
            {
                button.id->
                {
                    val c = Calendar.getInstance()
                    val year = c.get(Calendar.YEAR)
                    val month = c.get(Calendar.MONTH)
                    val day = c.get(Calendar.DAY_OF_MONTH)

                    val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener {name, year, monthOfYear, dayOfMonth ->
                        // Display Selected date in textbox
                        var mon = monthOfYear+1
                        display.setText("" + dayOfMonth + "/" + mon + "/" + year)
                    }, year, month, day)

                    dpd.show()
                }
            }

        }


    }
