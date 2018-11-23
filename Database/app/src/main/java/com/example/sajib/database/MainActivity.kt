package com.example.sajib.database

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm
import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.annotations.RealmClass


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      var student:Student = Student(10, 12,"Majed")
      var student1:Student = Student(11, 420,"ABC")
        Realm.init(this)
        saveSudentToDB(student)
        saveSudentToDB(student1)
        getAllStudent()
    }

    fun getAllStudent(): RealmResults<Student>? {
        var realm = Realm.getDefaultInstance()
        var myDate : RealmResults<Student>? = null;
        realm.executeTransaction {
            myDate = it.where(Student::class.java).findAll()
            Log.e("Student Sizee : " , "" + (myDate as RealmResults<Student>?)!!.size)

        }
        return myDate;
    }
    fun saveSudentToDB(stuent: Student) {
        var  realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.copyToRealm(stuent)
        realm.commitTransaction()
    }


}

