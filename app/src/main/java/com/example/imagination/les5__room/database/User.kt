package com.example.imagination.les5__room.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.random.Random

@Entity
class User (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,

    var name: String = "Empty " + Random.nextInt()
) {
    override fun toString(): String {
        return "User(id=$id, name='$name')"
    }
}