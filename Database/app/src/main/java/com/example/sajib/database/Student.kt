package com.example.sajib.database

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class Student(@PrimaryKey var id: Long = 0,
                   age: Int, name: String) : RealmObject() {

}