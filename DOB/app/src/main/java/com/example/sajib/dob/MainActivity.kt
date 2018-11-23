package com.example.sajib.dob

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var cal = Calendar.getInstance()
    var day = cal.get(Calendar.DAY_OF_MONTH)
    var month = cal.get(Calendar.MONTH)
    var year = cal.get(Calendar.YEAR)


    fun ins(view: View) {
        val inst = view as Button

        when (inst.id) {
            input.id -> {
                val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener
                { datepicker, years, monthOfyear, dayOfmonth ->

                    calculateData(years, monthOfyear, dayOfmonth)

                }, year, month, day)
                dpd.show()
            }

        }
    }

    fun calculateData(years: Int, monthOfyear: Int, dayOfmonth: Int) {

        var t: Int = 0
        var p: Int = 0

        var mn1: Int = 0
        var dy1: Int = 0
        var yr1: Int = 0

        var mn2 = monthOfyear
        var dy2= dayOfmonth
        var yr2= years


        if (month<mn2)
        {
            yr1 = year-yr2-1
            p = (30-dayOfmonth)+day
            if(p>=30&&p<60)
            {
                p-30
                dy1=p
                mn1 +=1
            }
            else if(p<30)
            {
                if(dy2>day)
                {
                    dy1 = dy2-day
                }
                else if (day>dy2)
                {
                    dy1 = 30-(day-dy2)
                    mn1 -=1
                }
            }
            t = mn2-month
            mn1 +=t
        }

        else if(month>mn2)
        {
            yr1 = year-yr2
            p = (30-day)+dayOfmonth
            if (p>=30)
            {
                mn1 +=1
                p-30
                dy1=p
            }
            else if(p<30)
            {
                if(day>dy2)
                {
                    dy1= day-dy2
                }
                else if(dy2>day)
                {
                    mn1 -=1
                    dy1 = 30-(day-dy2)
                }
            }
            t = month-mn2
            mn1 +=t
        }

        else if(mn2==month)
        {
           yr1 = year-yr2
            if(day>dy2)
           {
               dy1= day-dy2
           }
            else
           {
               dy1 = dy2
               mn1 -=1

           }
        }

            year_d.text = yr1.toString()
            month_d.text = mn1.toString()
            day_d.text = dy1.toString()
        }
    }



